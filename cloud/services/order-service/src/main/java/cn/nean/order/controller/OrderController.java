package cn.nean.order.controller;

import cn.nean.feign.points.PointsFeignClient;
import cn.nean.model.order.pojo.Order;
import cn.nean.model.points.pojo.Points;
import cn.nean.order.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    PointsFeignClient pointsFeignClient;

    @GetMapping("/{id}")
    public Map<String,Object> getOrder(@PathVariable Long id){
        Order order = orderMapper.queryOrderById(id);
        Points points = pointsFeignClient.queryPoints(1L);
        Map<String,Object> map = new HashMap<>();
        map.put("order",order);
        map.put("points",points);
        return map;
    }
}
