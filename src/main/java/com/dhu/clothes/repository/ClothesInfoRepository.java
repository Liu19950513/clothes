package com.dhu.clothes.repository;

import com.dhu.clothes.dataobject.ClothesInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ClothesInfoRepository extends JpaRepository<ClothesInfo, String> {
    List<ClothesInfo> findByStyle(String style);

    List<ClothesInfo> findByClothesIdIn(List<Long> clothesIdList);

    List<ClothesInfo> findByStyleAndSkin(String style,String skin);
}
