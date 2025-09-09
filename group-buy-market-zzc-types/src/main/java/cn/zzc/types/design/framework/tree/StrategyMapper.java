package cn.zzc.types.design.framework.tree;

/**
 * 策略映射器
 *
 * @author zc
 * @create 2025-09-09
 */

public interface StrategyMapper<T, D, R> {

    StrategyHandler<T, D, R> get(T requestParameter, D dynamicContext);

}
