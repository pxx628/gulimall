package com.pxx.gulimall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pxx.gulimall.common.utils.PageUtils;
import com.pxx.gulimall.order.entity.OrderItemEntity;

import java.util.Map;

/**
 * ????????Ϣ
 *
 * @author pxx
 * @email pxx@gmail.com
 * @date 2022-12-11 15:33:23
 */
public interface OrderItemService extends IService<OrderItemEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

