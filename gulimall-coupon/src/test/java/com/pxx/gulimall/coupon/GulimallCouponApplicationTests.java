package com.pxx.gulimall.coupon;

import com.pxx.gulimall.coupon.service.CouponService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GulimallCouponApplicationTests {
    @Autowired
    CouponService couponService;
    @Test
    void contextLoads() {

    }

}
