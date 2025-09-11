package cn.zzc.domain.activity.service.discount.impl;

import cn.zzc.domain.activity.model.valobj.GroupBuyActivityDiscountVO;
import cn.zzc.domain.activity.service.discount.AbstractDiscountCalculateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * N元购
 *
 * @author zc
 * @create 2025-09-11
 */

@Slf4j
@Service("N")
public class NCalculateService extends AbstractDiscountCalculateService {
    @Override
    protected BigDecimal doCalculate(BigDecimal originalPrice, GroupBuyActivityDiscountVO.GroupBuyDiscount groupBuyDiscount) {

        String marketExpr = groupBuyDiscount.getMarketExpr();

        return new BigDecimal(marketExpr);
    }
}
