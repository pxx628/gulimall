package com.pxx.gulimall.product;

import com.pxx.gulimall.product.entity.BrandEntity;
import com.pxx.gulimall.product.service.BrandService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GulimallProductApplicationTests {

    @Autowired
    BrandService brandService;
    @Test
    void contextLoads() {
        BrandEntity brand = new BrandEntity();
        brand.setName("杜蕾斯");
        brand.setLogo("LOVE");
        brand.setSort(1);
        brand.setDescript("你好她也好");
//        brand.setFirstLetter("高级");
        brand.setShowStatus(1);

        brandService.save(brand);
        System.out.println("保存完成===================");
    }
    @Test
    void contextLoads1() {
        System.out.println(brandService.query());
    }

}
