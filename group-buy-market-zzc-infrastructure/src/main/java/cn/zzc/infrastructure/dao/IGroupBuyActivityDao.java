package cn.zzc.infrastructure.dao;

import cn.zzc.infrastructure.dao.po.GroupBuyActivity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 拼团活动Dao
 *
 * @author zc
 * @create 2025-09-08
 */

@Mapper
public interface IGroupBuyActivityDao {

    List<GroupBuyActivity> queryGroupBuyActivityList();

}
