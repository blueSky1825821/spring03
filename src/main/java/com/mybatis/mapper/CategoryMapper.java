package com.mybatis.mapper;

import com.mybatis.pojo.Category;

import java.util.List;

/**
 * Created by sky on 2017/5/7.
 */
public interface CategoryMapper {
    public int add(Category category);

    public void delete(int id);

    public Category get(int id);

    public int update(Category category);

    public List<Category> list();

    public int count();
}
