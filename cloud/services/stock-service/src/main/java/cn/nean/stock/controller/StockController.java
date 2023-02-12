package cn.nean.stock.controller;

import cn.nean.stock.mapper.GoodsMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/stock")
@Slf4j
public class StockController {

    @Autowired
    GoodsMapper goodsMapper;

    /*
    *  扣减商品库存
    * */
    @GetMapping("/deduct/{goodsId}")
    public String deductGoodsStock(@PathVariable Long goodsId){
        int i = goodsMapper.updateGoods(goodsId);
        if(i > 0){
            log.info(goodsId + "  号商品扣减库存成功");
            return "success";
        }
        log.error(goodsId + "  号商品扣减库存失败");
        return "fail";
    }
}
