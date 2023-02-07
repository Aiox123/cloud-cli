package cn.nean.order.controller;

import cn.nean.model.order.pojo.Order;
import cn.nean.order.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderMapper orderMapper;

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable Long id){
        Order order = orderMapper.queryOrderById(id);
        return order;
    }
}
