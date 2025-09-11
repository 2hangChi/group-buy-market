package cn.zzc.domain.activity.service.discount.impl;

import cn.zzc.domain.activity.model.valobj.GroupBuyActivityDiscountVO;
import cn.zzc.domain.activity.service.discount.AbstractDiscountCalculateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * -
 *
 * @author zc
 * @create 2025-09-11
 */

@Slf4j
@Service("ZK")
public class ZKCalculateService extends AbstractDiscountCalculateService {
    @Override
    protected BigDecimal doCalculate(BigDecimal originalPrice, GroupBuyActivityDiscountVO.GroupBuyDiscount groupBuyDiscount) {

        String marketExpr = groupBuyDiscount.getMarketExpr();

        BigDecimal deductionPrice = originalPrice.multiply(new BigDecimal(marketExpr));

//        if (deductionPrice.compareTo(BigDecimal.ZERO) <= 0) {
//            return new BigDecimal(0.01); // 最低支付0.01元
//        }
//
//        return deductionPrice;

        return ensureMinimumPayment(deductionPrice);
    }
}
