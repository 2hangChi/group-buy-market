package cn.zzc.domain.activity.service.trial.node;

import cn.zzc.domain.activity.model.entity.MarketProductEntity;
import cn.zzc.domain.activity.model.entity.TrialBalanceEntity;
import cn.zzc.domain.activity.service.trial.AbstractGroupBuyMarketSupport;
import cn.zzc.domain.activity.service.trial.factory.DefaultActivityStrategyFactory;
import cn.zzc.types.design.framework.tree.StrategyHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 根节点
 *
 * @author zc
 * @create 2025-09-09
 */

@Slf4j
@Service
public class RootNode extends AbstractGroupBuyMarketSupport<MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, TrialBalanceEntity> {

    @Resource
    private SwitchRoot switchRoot;

    // 受理功能
    @Override
    public TrialBalanceEntity apply(MarketProductEntity requestParameter, DefaultActivityStrategyFactory.DynamicContext dynamicContext) throws Exception {
        return null;
    }

    // 路由
    @Override
    public StrategyHandler<MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, TrialBalanceEntity> get(MarketProductEntity requestParameter, DefaultActivityStrategyFactory.DynamicContext dynamicContext) {
        return switchRoot;
    }
}
