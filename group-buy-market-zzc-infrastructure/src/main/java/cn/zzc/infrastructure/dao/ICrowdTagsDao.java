package cn.zzc.infrastructure.dao;

import cn.zzc.infrastructure.dao.po.CrowdTags;
import org.apache.ibatis.annotations.Mapper;

/**
 * 人群标签
 *
 * @author zc
 * @create 2025-09-11
 */

@Mapper
public interface ICrowdTagsDao {

    void updateCrowdTagsStatistics(CrowdTags crowdTagsReq);

}
