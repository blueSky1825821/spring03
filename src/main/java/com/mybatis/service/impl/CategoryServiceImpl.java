package com.mybatis.service.impl;

import com.mybatis.mapper.CategoryMapper;
import com.mybatis.pojo.Category;
import com.mybatis.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by sky on 2017/5/7.
 */
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;

    public List<Category> list(){
        return categoryMapper.list();
    };
}
