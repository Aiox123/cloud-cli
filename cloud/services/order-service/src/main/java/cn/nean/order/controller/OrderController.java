package cn.nean.order.controller;

import cn.nean.feign.points.PointsFeignClient;
import cn.nean.feign.stock.StockFeignClient;
import cn.nean.model.order.pojo.Order;
import cn.nean.model.points.pojo.Points;
import cn.nean.order.mapper.OrderMapper;
import cn.nean.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    StockFeignClient stockFeignClient;

    @Autowired
    PointsFeignClient pointsFeignClient;

    @Autowired
    OrderService orderService;

    @GetMapping("/pay")
    public String payOrder(){
        return orderService.payOrder();
    }

    @GetMapping("/{id}")
    public Map<String, Object> getOrder(@PathVariable Long id) {
        Order order = orderMapper.queryOrderById(id);
        Points points = pointsFeignClient.queryPoints(1L);
        Map<String, Object> map = new HashMap<>();
        map.put("order", order);
        map.put("points", points);
        return map;
    }

    @GetMapping("/place")
    public String placeOrder() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        Long userId = 1L,goodsId = 1L;
        int points = 2;
        CompletableFuture<String> pointsTask = CompletableFuture.supplyAsync(()-> pointsFeignClient.increasePoints(userId, points));
        CompletableFuture<String> stockTask = CompletableFuture.supplyAsync(()-> stockFeignClient.deductGoodsStock(goodsId));
        String pointsMsg = pointsTask.get();
        String stockMsg = stockTask.get();
        log.info("积分信息:  {}",pointsMsg);
        log.info("库存信息:  {}",stockMsg);
        System.out.println(System.currentTimeMillis() - start);
        return pointsMsg + stockMsg;
    }

}
