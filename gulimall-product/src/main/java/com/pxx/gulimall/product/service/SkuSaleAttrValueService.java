package com.pxx.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pxx.gulimall.common.utils.PageUtils;
import com.pxx.gulimall.product.entity.SkuSaleAttrValueEntity;

import java.util.Map;

/**
 * sku????????&ֵ
 *
 * @author pxx
 * @email pxx@gmail.com
 * @date 2022-12-10 17:02:55
 */
public interface SkuSaleAttrValueService extends IService<SkuSaleAttrValueEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

