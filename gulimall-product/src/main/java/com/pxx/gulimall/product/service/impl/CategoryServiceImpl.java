package com.pxx.gulimall.product.service.impl;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pxx.gulimall.common.utils.PageUtils;
import com.pxx.gulimall.common.utils.Query;

import com.pxx.gulimall.product.dao.CategoryDao;
import com.pxx.gulimall.product.entity.CategoryEntity;
import com.pxx.gulimall.product.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listWithTree() {
        //1、查询所有数据
        List<CategoryEntity> entities = baseMapper.selectList(null);
        List<CategoryEntity> all= entities.stream().filter(item->item.getParentCid()==0)
                .map(item-> {
                    item.setChildren(getChildren(item,entities));
                    return item;
                })
                .sorted(Comparator.comparingInt(s->s.getSort()==null?0:s.getSort()))
                .collect(Collectors.toList());
        return all;
    }

    @Override
    public void removeMenuByIds(List<Long> asList) {
        //TODO:等待完成的产品分类的删除功能
        baseMapper.deleteBatchIds(asList);
    }


    private List<CategoryEntity> getChildren(CategoryEntity entity, List<CategoryEntity> entities) {
        List<CategoryEntity> entityList= entities.stream().filter(item->item.getParentCid()==entity.getCatId())
                .map(item->{
                    item.setChildren(getChildren(item,entities));
                    return item;
                })
                .sorted(Comparator.comparingInt(s->s.getSort()==null?0:s.getSort()))
                .collect(Collectors.toList());
        return entityList;
    }

}