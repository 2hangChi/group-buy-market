package cn.zzc.infrastructure.dao;

import cn.zzc.infrastructure.dao.po.GroupBuyDiscount;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 折扣配置Dao
 *
 * @author zc
 * @create 2025-09-08
 */

@Mapper
public interface IGroupBuyDiscountDao {

    List<GroupBuyDiscount> queryGroupBuyDiscountList();

}
