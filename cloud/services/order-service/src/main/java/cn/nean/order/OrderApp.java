package cn.nean.order;

import cn.nean.feign.points.PointsFeignClient;
import cn.nean.feign.config.FeignConfig;
import cn.nean.feign.stock.StockFeignClient;
import io.seata.spring.annotation.datasource.EnableAutoDataSourceProxy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableAutoDataSourceProxy
@EnableFeignClients(defaultConfiguration = FeignConfig.class,clients = {PointsFeignClient.class, StockFeignClient.class})
public class OrderApp {
    public static void main(String[] args) {
        SpringApplication.run(OrderApp.class,args);
    }
}
