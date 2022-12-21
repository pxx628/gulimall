package com.pxx.gulimall.product.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.pxx.gulimall.common.utils.UpTencentUtils;
import com.pxx.gulimall.common.validator.group.AddGroup;
import com.pxx.gulimall.common.validator.group.UpdateGroup;
import com.pxx.gulimall.common.validator.group.UpdateStatusGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pxx.gulimall.product.entity.BrandEntity;
import com.pxx.gulimall.product.service.BrandService;
import com.pxx.gulimall.common.utils.PageUtils;
import com.pxx.gulimall.common.utils.R;

import javax.validation.Valid;


/**
 * Ʒ?
 *
 * @author pxx
 * @email pxx@gmail.com
 * @date 2022-12-10 17:02:56
 */
@RestController
@RefreshScope
@RequestMapping("product/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = brandService.queryPage(params);

        return R.ok().put("page", page);
    }




    /**
     * 信息
     */
    @RequestMapping("/info/{brandId}")
    public R info(@PathVariable("brandId") Long brandId){
		BrandEntity brand = brandService.getById(brandId);

        return R.ok().put("brand", brand);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@Validated(AddGroup.class) @RequestBody BrandEntity brand/* , BindingResult result*/){
//        if (result.hasErrors()){
//            Map<String,String> map=new HashMap<>();
//            result.getFieldErrors().forEach(item->{
//                //获取请求错误的列名
//                String field = item.getField();
//                //获取默认错误提示
//                String message = item.getDefaultMessage();
//                map.put(field,message);
//            });
//            return R.error(400,"数据异常").put("data",map);
//        }else {
            brandService.save(brand);
            return R.ok();
//        }

    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@Validated(UpdateGroup.class) @RequestBody BrandEntity brand){
		brandService.updateById(brand);

        return R.ok();
    }
    /**
     * 修改
     */
    @RequestMapping("/update/status")
    public R updateStatus(@Validated(UpdateStatusGroup.class) @RequestBody BrandEntity brand){
        brandService.updateById(brand);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] brandIds){
		brandService.removeByIds(Arrays.asList(brandIds));

        return R.ok();
    }

}
