package cn.zzc.domain.tag.service;

import cn.zzc.domain.tag.adapter.repository.ITagRepository;
import cn.zzc.domain.tag.model.entity.CrowdTagsJobEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * -
 *
 * @author zc
 * @create 2025-09-11
 */

@Slf4j
@Service
public class TagService implements ITagService{

    @Resource
    private ITagRepository repository;

    @Override
    public void execTagBatchJob(String tagId, String batchId) {

        // 1. 查询标签任务
        CrowdTagsJobEntity crowdTagsJobEntity = repository.queryCrowdTagsJobEntity(tagId, batchId);

        // 2. 根据任务采集人物数据（现阶段模拟）

        List<String> userIdList = new ArrayList<String>(){{
            add("zzc");
            add("yyb");
        }};

        for(String userId : userIdList){
            repository.addCrowdTagsUserId(tagId, userId);
        }

        // 更新人群标签统计量
        repository.updateCrowdTagsStatistics(tagId, userIdList.size());
    }

}
