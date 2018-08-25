package com.dhu.clothes.service;

import com.dhu.clothes.ClothesApplicationTests;
import com.dhu.clothes.dataobject.ClothesInfo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.junit.Assert.*;

@Component
public class ClothesServiceTest extends ClothesApplicationTests {
    @Autowired
    private ClothesService clothesService;
    @Test
    public void findCuteAll() throws Exception {
        List<ClothesInfo> list = clothesService.findCuteAll();
        Assert.assertTrue(list.size()>0);
    }
}