package com.pxx.gulimall.wave.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pxx.common.utils.PageUtils;
import com.pxx.gulimall.wave.entity.UndoLogEntity;

import java.util.Map;

/**
 * 
 *
 * @author pxx
 * @email pxx@gmail.com
 * @date 2022-12-11 15:34:50
 */
public interface UndoLogService extends IService<UndoLogEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

