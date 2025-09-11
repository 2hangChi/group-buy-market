package cn.zzc.infrastructure.dao;

import cn.zzc.infrastructure.dao.po.Sku;
import org.apache.ibatis.annotations.Mapper;

/**
 * -
 *
 * @author zc
 * @create 2025-09-09
 */

@Mapper
public interface ISkuDao {

    Sku querySkuByGoodsId(String goodsId);

}
