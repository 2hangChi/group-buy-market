package cn.zzc.domain.activity.service.trial;

import cn.zzc.domain.activity.adapter.repository.IActivityRepository;
import cn.zzc.types.design.framework.tree.AbstractMultiThreadStrategyRouter;

import javax.annotation.Resource;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

/**
 * -
 *
 * @author zc
 * @create 2025-09-09
 */

public abstract class AbstractGroupBuyMarketSupport<MarketProductEntity, DynamicContext, TrialBalanceEntity> extends AbstractMultiThreadStrategyRouter<MarketProductEntity, DynamicContext, TrialBalanceEntity> {


    protected long timeout = 500;

    @Resource
    protected IActivityRepository repository;

    @Override
    protected void multiThread(MarketProductEntity requestParameter, DynamicContext dynamicContext) throws ExecutionException, InterruptedException, TimeoutException { // 默认的实现 避免每个节点都实现

    }
}
