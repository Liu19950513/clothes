package com.dhu.clothes.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * creater: LIUYING
 * date:2018/8/23 17:27
 */
@Data
public class ClothesMatchVO {

    @JsonProperty("id")
    private String clothesId;

    private String style;

    private String  skin;
}
