package com.dhu.clothes.enums;

import lombok.Getter;

/**
 * creater: LIUYING
 * date:2018/8/15 16:39
 */
@Getter
public enum ResultEnum {

    PRODUCT_NOT_EXIST(1, "商品不存在"),
    PRODUCT_STOCK_ERROR(2, "库存有误"),
    ;

    private Integer code;
    private String message;
    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}