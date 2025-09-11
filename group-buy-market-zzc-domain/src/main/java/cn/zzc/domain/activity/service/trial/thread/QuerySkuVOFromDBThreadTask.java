package cn.zzc.domain.activity.service.trial.thread;

import cn.zzc.domain.activity.adapter.repository.IActivityRepository;
import cn.zzc.domain.activity.model.valobj.SkuVO;

import java.util.concurrent.Callable;

/**
 * -
 *
 * @author zc
 * @create 2025-09-10
 */

public class QuerySkuVOFromDBThreadTask implements Callable<SkuVO> {

    private final String goodsId;

    private final IActivityRepository activityRepository;

    public QuerySkuVOFromDBThreadTask(String goodsId, IActivityRepository activityRepository) {
        this.goodsId = goodsId;
        this.activityRepository = activityRepository;
    }

    @Override
    public SkuVO call() throws Exception {
        return activityRepository.querySkuByGoodsId(goodsId);
    }
}
