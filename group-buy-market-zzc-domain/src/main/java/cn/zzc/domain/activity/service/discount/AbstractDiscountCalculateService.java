package cn.zzc.domain.activity.service.discount;

import cn.zzc.domain.activity.model.valobj.DiscountTypeEnum;
import cn.zzc.domain.activity.model.valobj.GroupBuyActivityDiscountVO;

import java.math.BigDecimal;

/**
 * -
 *
 * @author zc
 * @create 2025-09-11
 */

public abstract class AbstractDiscountCalculateService implements IDiscountCalculateService {

    private static final BigDecimal MINIMUM_PAYMENT = new BigDecimal("0.01");

    @Override
    public BigDecimal calculate(String userId, BigDecimal originalPrice, GroupBuyActivityDiscountVO.GroupBuyDiscount groupBuyDiscount) {
        if(DiscountTypeEnum.TAG.equals(groupBuyDiscount.getDiscountType())){
            boolean isCrowdRange = filterTagId(userId, groupBuyDiscount.getTagId());
            if(!isCrowdRange){
                return originalPrice;
            }
        }

        return doCalculate(originalPrice, groupBuyDiscount);
    }

    private boolean filterTagId(String userId, String tagId) {
        return true;
    }

    protected abstract BigDecimal doCalculate(BigDecimal originalPrice, GroupBuyActivityDiscountVO.GroupBuyDiscount groupBuyDiscount);

    /**
     * 提供最低支付金额保护的方法
     * 子类在需要时可以在doCalculate方法中调用此方法
     */
    protected BigDecimal ensureMinimumPayment(BigDecimal calculatedPrice) {
        if (calculatedPrice.compareTo(BigDecimal.ZERO) <= 0) {
            return MINIMUM_PAYMENT;
        }
        return calculatedPrice;
    }

}
