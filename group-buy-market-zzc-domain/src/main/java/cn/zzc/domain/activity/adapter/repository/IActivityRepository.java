package cn.zzc.domain.activity.adapter.repository;

import cn.zzc.domain.activity.model.valobj.GroupBuyActivityDiscountVO;
import cn.zzc.domain.activity.model.valobj.SkuVO;

/**
 * -
 *
 * @author zc
 * @create 2025-09-09
 */

public interface IActivityRepository {

    GroupBuyActivityDiscountVO queryGroupBuyActivityDiscountVO(String source, String channel);

    SkuVO querySkuByGoodsId(String goodsId);

}
