package com.pxx.gulimall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pxx.common.utils.PageUtils;
import com.pxx.gulimall.member.entity.MemberStatisticsInfoEntity;

import java.util.Map;

/**
 * ??Աͳ????Ϣ
 *
 * @author pxx
 * @email pxx@gmail.com
 * @date 2022-12-11 09:55:05
 */
public interface MemberStatisticsInfoService extends IService<MemberStatisticsInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

