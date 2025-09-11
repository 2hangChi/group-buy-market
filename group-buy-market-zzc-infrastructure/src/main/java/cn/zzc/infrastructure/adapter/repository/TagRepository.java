package cn.zzc.infrastructure.adapter.repository;

import cn.zzc.domain.tag.adapter.repository.ITagRepository;
import cn.zzc.domain.tag.model.entity.CrowdTagsJobEntity;
import cn.zzc.infrastructure.dao.ICrowdTagsDao;
import cn.zzc.infrastructure.dao.ICrowdTagsDetailDao;
import cn.zzc.infrastructure.dao.ICrowdTagsJobDao;
import cn.zzc.infrastructure.dao.po.CrowdTags;
import cn.zzc.infrastructure.dao.po.CrowdTagsDetail;
import cn.zzc.infrastructure.dao.po.CrowdTagsJob;
import cn.zzc.infrastructure.redis.IRedisService;
import org.redisson.api.RBitSet;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * -
 *
 * @author zc
 * @create 2025-09-11
 */

@Repository
public class TagRepository implements ITagRepository {

    @Resource
    private ICrowdTagsDao crowdTagsDao;

    @Resource
    private ICrowdTagsDetailDao crowdTagsDetailDao;

    @Resource
    private ICrowdTagsJobDao crowdTagsJobDao;

    @Resource
    private IRedisService redisService;

    @Override
    public CrowdTagsJobEntity queryCrowdTagsJobEntity(String tagId, String batchId) {

        CrowdTagsJob crowdTagsJobReq = new CrowdTagsJob();
        crowdTagsJobReq.setTagId(tagId);
        crowdTagsJobReq.setBatchId(batchId);

        CrowdTagsJob crowdTagsJobRes = crowdTagsJobDao.queryCrowdTagsJob(crowdTagsJobReq);

        return CrowdTagsJobEntity.builder()
                .tagType(crowdTagsJobRes.getTagType())
                .tagRule(crowdTagsJobRes.getTagRule())
                .statStartTime(crowdTagsJobRes.getCreateTime())
                .statEndTime(crowdTagsJobRes.getStatEndTime())
                .build();
    }

    @Override
    public void addCrowdTagsUserId(String tagId, String userId) {

        CrowdTagsDetail crowdTagsDetailReq = new CrowdTagsDetail();
        crowdTagsDetailReq.setTagId(tagId);
        crowdTagsDetailReq.setUserId(userId);

        try { // 唯一索引冲突
            crowdTagsDetailDao.addCrowdTagsUserId(crowdTagsDetailReq);

            RBitSet bitSet = redisService.getBitSet(tagId);
            bitSet.set(redisService.getIndexFromUserId(userId));
        } catch (DuplicateKeyException ignore) {
        }

    }

    @Override
    public void updateCrowdTagsStatistics(String tagId, int size) {

        CrowdTags crowdTagsReq = new CrowdTags();
        crowdTagsReq.setTagId(tagId);
        crowdTagsReq.setStatistics(size);

        crowdTagsDao.updateCrowdTagsStatistics(crowdTagsReq);

    }

}
