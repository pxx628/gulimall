package com.pxx.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pxx.common.utils.PageUtils;
import com.pxx.gulimall.product.entity.CategoryEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * ??Ʒ???????
 *
 * @author pxx
 * @email pxx@gmail.com
 * @date 2022-12-10 17:02:56
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<CategoryEntity> listWithTree();

    void removeMenuByIds(List<Long> asList);
}

