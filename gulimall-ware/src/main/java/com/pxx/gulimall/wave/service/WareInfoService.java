package com.pxx.gulimall.wave.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pxx.gulimall.common.utils.PageUtils;
import com.pxx.gulimall.wave.entity.WareInfoEntity;

import java.util.Map;

/**
 * 仓库信息
 *
 * @author pxx
 * @email pxx@gmail.com
 * @date 2022-12-11 15:34:50
 */
public interface WareInfoService extends IService<WareInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

