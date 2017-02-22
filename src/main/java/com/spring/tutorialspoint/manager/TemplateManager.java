package com.spring.tutorialspoint.manager;


import com.spring.tutorialspoint.dao.TemplateDao;
import com.spring.tutorialspoint.exception.DAOException;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by colar on 16-1-13.
 */
public interface TemplateManager<T extends Serializable> {



    /**
     * 添加设备状态
     * @param e
     * @return
     * @throws DAOException
     */
    public Long add(T e) ;


    /**
     * 删除一个设备状态
     * @param id
     * @return
     * @throws DAOException
     */
    public int delete(Long id);


    /**
     * 根据id查询设备
     * @param id
     * @return
     * @throws DAOException
     */
    public T get(Long id) ;


    /**
     * 更新设备
     * @param t
     * @return
     * @throws DAOException
     */
    public int update(T t) ;


    /**
     * 查询方法
     * @param queryData 根据数据列进行查询,
     *                  orderBy 按某一列排序,
     *                  startRow 分页开始行　
     *                  size 分页大小
     *                  beginDate  endDate gmtCreate 在这个区间的数据
     * @return
     * @throws DAOException
     */
    public List<T> query(Map queryData);


    /**
     * 查询总数
     * @param queryData
     * @return
     */
    public Integer queryCount(Map queryData);



    public TemplateDao<T> getDao();
}
