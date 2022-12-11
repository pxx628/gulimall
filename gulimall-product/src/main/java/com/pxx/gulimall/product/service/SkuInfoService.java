package com.pxx.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pxx.common.utils.PageUtils;
import com.pxx.gulimall.product.entity.SkuInfoEntity;

import java.util.Map;

/**
 * sku??Ϣ
 *
 * @author pxx
 * @email pxx@gmail.com
 * @date 2022-12-10 17:02:55
 */
public interface SkuInfoService extends IService<SkuInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

