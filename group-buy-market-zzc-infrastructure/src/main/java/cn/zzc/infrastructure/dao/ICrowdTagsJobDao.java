package cn.zzc.infrastructure.dao;

import cn.zzc.infrastructure.dao.po.CrowdTagsJob;
import org.apache.ibatis.annotations.Mapper;

/**
 * -
 *
 * @author zc
 * @create 2025-09-11
 */

@Mapper
public interface ICrowdTagsJobDao {

    CrowdTagsJob queryCrowdTagsJob(CrowdTagsJob crowdTagsJobReq);

}
