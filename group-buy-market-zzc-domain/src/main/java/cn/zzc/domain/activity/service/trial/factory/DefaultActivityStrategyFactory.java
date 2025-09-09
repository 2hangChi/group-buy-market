package cn.zzc.domain.activity.service.trial.factory;

import cn.zzc.domain.activity.model.entity.MarketProductEntity;
import cn.zzc.domain.activity.model.entity.TrialBalanceEntity;
import cn.zzc.domain.activity.service.trial.node.RootNode;
import cn.zzc.types.design.framework.tree.StrategyHandler;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * -
 *
 * @author zc
 * @create 2025-09-09
 */

@Service
public class DefaultActivityStrategyFactory {

    private final RootNode rootNode;

    public DefaultActivityStrategyFactory(RootNode rootNode) {
        this.rootNode = rootNode;
    }

    public StrategyHandler<MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, TrialBalanceEntity> strategyHandler() {
        return rootNode;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DynamicContext { // 串联功能节点的数据

    }

}
