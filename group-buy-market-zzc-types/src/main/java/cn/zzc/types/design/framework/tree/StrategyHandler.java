package cn.zzc.types.design.framework.tree;

/**
 * 策略处理器
 *
 * @author zc
 * @create 2025-09-09
 */

public interface StrategyHandler<T, D, R> {

    StrategyHandler DEFAULT = (T, D) -> null; // 默认的空的返回结果

    R apply(T requestParameter, D dynamicContext) throws Exception;

}
