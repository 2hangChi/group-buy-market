package cn.zzc.domain.activity.service;

import cn.zzc.domain.activity.model.entity.MarketProductEntity;
import cn.zzc.domain.activity.model.entity.TrialBalanceEntity;

/**
 * -
 *
 * @author zc
 * @create 2025-09-09
 */

public interface IIndexGroupBuyMarketService {

    TrialBalanceEntity indexMarketTrial(MarketProductEntity marketProductEntity) throws Exception;

}
