package cn.nean.feign.stock;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "stock-service",path = "stock")
public interface StockFeignClient {

    @GetMapping("/deduct/{goodsId}")
    String deductGoodsStock(@PathVariable Long goodsId);
}
