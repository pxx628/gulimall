package com.pxx.gulimall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pxx.common.utils.PageUtils;
import com.pxx.gulimall.order.entity.OrderOperateHistoryEntity;

import java.util.Map;

/**
 * ??????????ʷ??¼
 *
 * @author pxx
 * @email pxx@gmail.com
 * @date 2022-12-11 15:33:23
 */
public interface OrderOperateHistoryService extends IService<OrderOperateHistoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

