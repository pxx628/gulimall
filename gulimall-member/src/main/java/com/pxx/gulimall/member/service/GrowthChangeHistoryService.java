package com.pxx.gulimall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pxx.common.utils.PageUtils;
import com.pxx.gulimall.member.entity.GrowthChangeHistoryEntity;

import java.util.Map;

/**
 * ?ɳ?ֵ?仯??ʷ??¼
 *
 * @author pxx
 * @email pxx@gmail.com
 * @date 2022-12-11 09:55:05
 */
public interface GrowthChangeHistoryService extends IService<GrowthChangeHistoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

