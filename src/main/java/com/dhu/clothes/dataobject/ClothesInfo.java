package com.dhu.clothes.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class ClothesInfo {
    @Id
    private Long clothesId;
    /** 标题*/
    private String title;
    /** 图片的链接*/
    private String url;
    /** 服装风格 */
    private String style;
    /** 服装适合的肤色 */
    private String skin;

    /** 服装主色 */
    private String color;
    /** 服装主类别
     * 四类：1（上衣）2（外套）3（裙装）4（裤子）
     * */
    private Integer category;
    /**  服装子类别*/
    private Integer subCategory;
    /**  服装款型*/
    private String body;
    /**  描述*/
    private String description;
    /**  服装主色的r值*/
    private Integer red;
    /**  服装主色的g值*/
    private Integer green;
    /**  服装主色的b值*/
    private Integer blue;

}
