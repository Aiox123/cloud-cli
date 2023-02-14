package cn.nean.order.mapper;

import cn.nean.model.order.pojo.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMapper extends BaseMapper<Order> {

    Order queryOrderById(@Param("id") Long id);

    /*
    * 生成订单
    * */
    int saveOrder(@Param("order") Order order);
}
