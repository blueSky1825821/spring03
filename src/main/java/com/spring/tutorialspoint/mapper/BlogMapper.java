package com.spring.tutorialspoint.mapper;

import com.spring.tutorialspoint.po.Blog;
import org.apache.ibatis.annotations.Select;

/**
 * Created by sky on 2017/5/5.
 */
public interface BlogMapper {
    @Select("SELECT * FROM blog WHERE id = #{id}")
    Blog select(long id);

    Boolean insert(Blog blog);
}
