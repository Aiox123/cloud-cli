package cn.nean.order.service.impl;

import cn.nean.feign.stock.StockFeignClient;
import cn.nean.model.order.pojo.Order;
import cn.nean.order.mapper.OrderMapper;
import cn.nean.order.service.OrderService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {


    @Autowired
    OrderMapper orderMapper;

    @Autowired
    StockFeignClient stockFeignClient;

    /*
    * 下单
    * */
    @Override
    @GlobalTransactional
    public String payOrder() {
        // 生成订单
        Order order = Order.builder()
                .userId(1L)
                .enterpriseId(10211L)
                .productId(2L)
                .status(1)
                .commodityAmount("15.00")
                .createTime(new Date())
                .updateTime(new Date())
                .build();
        int isSave = orderMapper.saveOrder(order);
        // 扣减库存
        String s = stockFeignClient.deductGoodsStock(2L);
        if("fail".equals(s)){
            log.info(s);
            throw new RuntimeException();
        }
        return s;
    }
}
