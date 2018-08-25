package com.dhu.clothes.enums;

import lombok.Getter;

/**
 * creater: LIUYING
 * date:2018/8/15 16:41
 */
@Getter
public enum CategoryEnum {
    JACKET(1,"上衣"),
    COAT(2,"外套"),
    DRESS(3,"裙装"),
    PANTS(4,"裤子"),
    ;
    private Integer code;
    private String message;

    CategoryEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
