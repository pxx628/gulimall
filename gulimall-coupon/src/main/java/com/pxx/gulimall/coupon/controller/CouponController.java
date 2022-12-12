package com.pxx.gulimall.coupon.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import com.pxx.gulimall.coupon.entity.CouponEntity;
import com.pxx.gulimall.coupon.service.CouponService;
import com.pxx.common.utils.PageUtils;
import com.pxx.common.utils.R;



/**
 * ?Ż?ȯ??Ϣ
 *
 * @author pxx
 * @email pxx@gmail.com
 * @date 2022-12-11 09:44:49
 */
@RefreshScope
@RestController
@RequestMapping("coupon/coupon")
public class CouponController {
    @Autowired
    private CouponService couponService;

    /**
     * 测试feign
     * @return
     */
    @RequestMapping("/testList")
    public R lists(){
        List<CouponEntity> list = couponService.list();

        return R.ok().put("testList", list);
    }
    @Value("${coupon.user.name}")
    private String name;

    @Value("${coupon.user.age}")
    private Integer age;

    @GetMapping("/testConfig")
    public R testConfig(){
        return R.ok().put("name",name).put("age",age);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = couponService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		CouponEntity coupon = couponService.getById(id);

        return R.ok().put("coupon", coupon);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CouponEntity coupon){
		couponService.save(coupon);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody CouponEntity coupon){
		couponService.updateById(coupon);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		couponService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
