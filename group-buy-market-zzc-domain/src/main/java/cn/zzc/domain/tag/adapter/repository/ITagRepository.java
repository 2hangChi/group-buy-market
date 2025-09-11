package cn.zzc.domain.tag.adapter.repository;

import cn.zzc.domain.tag.model.entity.CrowdTagsJobEntity;

/**
 * -
 *
 * @author zc
 * @create 2025-09-11
 */

public interface ITagRepository {

    CrowdTagsJobEntity queryCrowdTagsJobEntity(String tagId, String batchId);

    void addCrowdTagsUserId(String tagId, String userId);

    void updateCrowdTagsStatistics(String tagId, int size);

}
