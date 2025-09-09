package cn.zzc.domain.activity.service;

import cn.zzc.domain.activity.model.entity.MarketProductEntity;
import cn.zzc.domain.activity.model.entity.TrialBalanceEntity;
import cn.zzc.domain.activity.service.trial.factory.DefaultActivityStrategyFactory;
import cn.zzc.types.design.framework.tree.StrategyHandler;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * -
 *
 * @author zc
 * @create 2025-09-09
 */

@Service
public class IndexGroupBuyMarketServiceImpl implements IIndexGroupBuyMarketService {

    @Resource
    private DefaultActivityStrategyFactory defaultActivityStrategyFactory;

    @Override
    public TrialBalanceEntity indexMarketTrial(MarketProductEntity marketProductEntity) throws Exception {

        StrategyHandler<MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, TrialBalanceEntity> strategyHandler = defaultActivityStrategyFactory.strategyHandler();

        TrialBalanceEntity trialBalanceEntity = strategyHandler.apply(marketProductEntity, new DefaultActivityStrategyFactory.DynamicContext());

        return trialBalanceEntity;
    }

}
