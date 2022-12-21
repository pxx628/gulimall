package com.pxx.gulimall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pxx.gulimall.common.utils.PageUtils;
import com.pxx.gulimall.coupon.entity.CouponEntity;

import java.util.Map;

/**
 * ?Ż?ȯ??Ϣ
 *
 * @author pxx
 * @email pxx@gmail.com
 * @date 2022-12-11 09:44:49
 */
public interface CouponService extends IService<CouponEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

