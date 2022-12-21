package com.pxx.gulimall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pxx.gulimall.common.utils.PageUtils;
import com.pxx.gulimall.member.entity.MemberCollectSubjectEntity;

import java.util.Map;

/**
 * ??Ա?ղص?ר???
 *
 * @author pxx
 * @email pxx@gmail.com
 * @date 2022-12-11 09:55:05
 */
public interface MemberCollectSubjectService extends IService<MemberCollectSubjectEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

