package cn.nean.model.stock.pojo;


import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Goods implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 商品名
     */
    private String name;

    /**
     * 库存
     */
    private Long stock;

    /**
     * 价格
     */
    private BigDecimal price;
}