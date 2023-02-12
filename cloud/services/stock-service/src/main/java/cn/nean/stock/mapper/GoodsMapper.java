package cn.nean.stock.mapper;

import cn.nean.model.stock.pojo.Goods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsMapper extends BaseMapper<Goods> {

    /*
    *  扣减库存
    * */
    int updateGoods(@Param("goodsId") Long goodsId);
}
