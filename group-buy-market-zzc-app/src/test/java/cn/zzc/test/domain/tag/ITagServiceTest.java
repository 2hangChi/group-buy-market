package cn.zzc.test.domain.tag;

import cn.zzc.domain.tag.service.ITagService;
import cn.zzc.infrastructure.redis.IRedisService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RBitSet;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * -
 *
 * @author zc
 * @create 2025-09-11
 */

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ITagServiceTest {

    @Resource
    private ITagService tagService;

    @Resource
    private IRedisService redisService;

    @Test
    public void test_tag_job() {
        tagService.execTagBatchJob("RQ_KJHKL98UU78H66554GFDV", "10001");
    }

    @Test
    public void test_get_tag_bitmap() {
        RBitSet bitSet = redisService.getBitSet("RQ_KJHKL98UU78H66554GFDV");
        log.info("zzc 存在，预期结果为 true，测试结果:{}", bitSet.get(redisService.getIndexFromUserId("zzc")));
        log.info("xxa 不存在，预期结果为 false，测试结果:{}", bitSet.get(redisService.getIndexFromUserId("xxa")));

    }
}
