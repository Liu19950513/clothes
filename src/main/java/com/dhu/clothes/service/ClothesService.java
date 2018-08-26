package com.dhu.clothes.service;

import com.dhu.clothes.VO.ClothesInfoVO;
import com.dhu.clothes.dataobject.ClothesInfo;

import java.util.List;

public interface ClothesService {
    /**
     *查询所有可爱风格的衣服
     **/
    List<ClothesInfo> findCuteAll();

    List<ClothesInfo> findByStyle(String style);

    List<ClothesInfoVO> findList(List<Long> clothesIdList );

    List<ClothesInfo> findForMatch(String style,String skin);
}
