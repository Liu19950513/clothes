package com.dhu.clothes.controller;

import com.dhu.clothes.VO.ClothesInfoVO;
import com.dhu.clothes.VO.ClothesVO;
import com.dhu.clothes.VO.ResultVO;
import com.dhu.clothes.dataobject.ClothesInfo;
import com.dhu.clothes.enums.CategoryEnum;
import com.dhu.clothes.service.ClothesService;
import com.dhu.clothes.utils.Collocation;
import com.dhu.clothes.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/clothes")
public class ClothesController {

    @Autowired
    private ClothesService clothesService;

    /**
     *1.查询所有的符合对应风格的衣服
     *2. 获取对应类别的衣服
     * 3.查询类别
     * 4.构造数据
     **/
    @GetMapping("/list/{style}")
    public ResultVO<ClothesInfoVO> listForStyle(@PathVariable String style){
        //1.获取指定风格的衣服
        //List<ClothesInfo> clothesInfoList = clothesService.findCuteAll();
        List<ClothesInfo> clothesInfoList = clothesService.findByStyle(style);
        //2.将服装按类别分类
        List<Integer> categoryTypeList = new ArrayList<>();
        categoryTypeList.add(CategoryEnum.JACKET.getCode());
        categoryTypeList.add(CategoryEnum.COAT.getCode());
        categoryTypeList.add(CategoryEnum.DRESS.getCode());
        categoryTypeList.add(CategoryEnum.PANTS.getCode());
        //3.构造数据ClothesVOList
        List<ClothesVO> clothesVoList = new ArrayList<>();
        for(Integer clothesCategory: categoryTypeList){
            ClothesVO clothesVo = new ClothesVO();
            clothesVo.setCategoryType(clothesCategory);

            List<ClothesInfoVO> clothesInfoVOList = new ArrayList<>();
            for(ClothesInfo clothesInfo: clothesInfoList){
                if(clothesInfo.getCategory() == clothesCategory){
                    ClothesInfoVO clothesInfoVO = new ClothesInfoVO();
                    BeanUtils.copyProperties(clothesInfo, clothesInfoVO);
                    clothesInfoVOList.add(clothesInfoVO);
                }
            }
            clothesVo.setClothesInfoVoList(clothesInfoVOList);
            clothesVoList.add(clothesVo);
        }
        return ResultVOUtil.success(clothesVoList);
    }


    /**
     *获取服装列表
     * 给推荐搭配服务用
     */
    @RequestMapping(value = "/collocationClothes",method = RequestMethod.POST)
    public List<ClothesInfoVO> listForCollocation(@RequestBody Collocation searchResult){
        List<Long> clothesIdList = new ArrayList<>();
        clothesIdList.add(searchResult.getClothes1());
        clothesIdList.add(searchResult.getClothes2());
        clothesIdList.add(searchResult.getClothes3());
        List<ClothesInfoVO> clothesList = clothesService.findList(clothesIdList);
        return clothesList;
    }

    @RequestMapping(value = "/recommendClothes/{style}/{skin}",method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ClothesVO> listForRecommend(@PathVariable String style,@PathVariable String skin){
        //1.获取指定风格的衣服
        List<ClothesInfo> clothesInfoList = clothesService.findForMatch(style,skin);
        //2.将服装按类别分类
        List<Integer> categoryTypeList = new ArrayList<>();
        categoryTypeList.add(CategoryEnum.JACKET.getCode());
        categoryTypeList.add(CategoryEnum.COAT.getCode());
        categoryTypeList.add(CategoryEnum.DRESS.getCode());
        categoryTypeList.add(CategoryEnum.PANTS.getCode());
        //3.构造数据ClothesVOList
        List<ClothesVO> clothesVoList = new ArrayList<>();
        for(Integer clothesCategory: categoryTypeList){
            ClothesVO clothesVo = new ClothesVO();
            clothesVo.setCategoryType(clothesCategory);

            List<ClothesInfoVO> clothesInfoVOList = new ArrayList<>();
            for(ClothesInfo clothesInfo: clothesInfoList){
                if(clothesInfo.getCategory() == clothesCategory){
                    ClothesInfoVO clothesInfoVO = new ClothesInfoVO();
                    BeanUtils.copyProperties(clothesInfo, clothesInfoVO);
                    clothesInfoVOList.add(clothesInfoVO);
                }
            }
            clothesVo.setClothesInfoVoList(clothesInfoVOList);
            clothesVoList.add(clothesVo);
        }
        return clothesVoList;
    }
}
