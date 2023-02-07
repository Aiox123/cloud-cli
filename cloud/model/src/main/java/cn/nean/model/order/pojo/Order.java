package cn.nean.model.order.pojo;


import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 订单ID
     */
    private Long id;

    /**
     * 下单用户ID
     */
    private Long userId;

    /**
     * 商家ID
     */
    private Long enterpriseId;

    /**
     * 商品ID
     */
    private Long productId;

    /**
     * 订单状态
     */
    private Integer status;

    /**
     * 商品金额
     */
    private String commodityAmount;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

}