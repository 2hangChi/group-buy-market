package cn.zzc.domain.activity.service.trial.factory;

import cn.zzc.domain.activity.model.entity.MarketProductEntity;
import cn.zzc.domain.activity.model.entity.TrialBalanceEntity;
import cn.zzc.domain.activity.model.valobj.GroupBuyActivityDiscountVO;
import cn.zzc.domain.activity.model.valobj.SkuVO;
import cn.zzc.domain.activity.service.trial.node.RootNode;
import cn.zzc.types.design.framework.tree.StrategyHandler;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

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

        // 拼团活动营销配置值对象
        private GroupBuyActivityDiscountVO groupBuyActivityDiscountVO;

        // 商品信息
        private SkuVO skuVO;

        // 优惠后价格
        private BigDecimal deductionPrice;

    }

}
