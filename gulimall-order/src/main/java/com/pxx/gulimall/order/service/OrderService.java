package com.pxx.gulimall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pxx.common.utils.PageUtils;
import com.pxx.gulimall.order.entity.OrderEntity;

import java.util.Map;

/**
 * ????
 *
 * @author pxx
 * @email pxx@gmail.com
 * @date 2022-12-11 15:33:23
 */
public interface OrderService extends IService<OrderEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

