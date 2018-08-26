package com.dhu.clothes.service.impl;

import com.dhu.clothes.VO.ClothesInfoVO;
import com.dhu.clothes.dataobject.ClothesInfo;
import com.dhu.clothes.repository.ClothesInfoRepository;
import com.dhu.clothes.service.ClothesService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClothesServiceImpl implements ClothesService {
    @Autowired
    private ClothesInfoRepository clothesInfoRepository;
    @Override
    public List<ClothesInfo> findCuteAll() {
        return clothesInfoRepository.findByStyle("cute");
    }

    @Override
    public List<ClothesInfo> findByStyle(String style){
        return clothesInfoRepository.findByStyle(style);
    }

    @Override
    public List<ClothesInfoVO> findList(List<Long> clothesIdList ){
        return clothesInfoRepository.findByClothesIdIn(clothesIdList).stream().
                map(e->{
                    ClothesInfoVO output = new ClothesInfoVO();
                    BeanUtils.copyProperties(e,output);
                    return output;
                }).collect(Collectors.toList());
    }

    @Override
    public List<ClothesInfo> findForMatch(String style, String skin) {
        return clothesInfoRepository.findByStyleAndSkin(style, skin);
    }
}
