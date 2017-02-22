package com.spring.tutorialspoint.dao;


import com.spring.tutorialspoint.exception.DAOException;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by colar on 16-1-13.
 */
public interface TemplateDao<T extends Serializable> {



    /**
     * 添加设备状态
     * @param e
     * @return 插入的id
     * @throws DAOException
     */
    public Long add(T e) throws DAOException, DAOException;


    /**
     * 删除一个设备状态
     * @param id
     * @return
     * @throws DAOException
     */
    public int delete(Long id) throws DAOException;


    /**
     * 根据id查询设备
     * @param id
     * @return
     * @throws DAOException
     */
    public T get(Long id) throws DAOException ;


    /**
     * 更新设备
     * @param t
     * @return
     * @throws DAOException
     */
    public int update(T t) throws  DAOException;

    /**
     * 更新导出状态
     * @param idList
     * @return
     * @throws DAOException
     */
    public int batchUpdateStatus(List<Long> idList) throws  DAOException;


    /**
     * 查询方法
     * @param queryData 根据数据列进行查询,
     *                  orderBy 按某一列排序,
     *                  startRow 分页开始行　
     *                  size 分页大小
     *                  beginDate  endDate 表示 gmtCreate 在这个区间的数据
     * @return
     * @throws DAOException
     */
    public List<T> query(Map queryData) throws DAOException;


    /**
     * 查询总数,对应query方法,参数去掉分页信息
     * @param queryData
     * @return
     * @throws DAOException
     */
    public Integer queryCount(Map queryData) throws  DAOException;

    /**
     * 导出数据
     *
     * @param query
     * @return
     * @throws DAOException
     */
    List<T> exportQuery(Map query) throws DAOException;
}
