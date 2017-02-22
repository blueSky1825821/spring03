package com.spring.tutorialspoint.impl;

import com.google.common.collect.Maps;
import com.spring.tutorialspoint.base.BaseDAO;
import com.spring.tutorialspoint.dao.TemplateDao;
import com.spring.tutorialspoint.exception.DAOException;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * Created by colar on 16-1-13.
 */
public abstract class TemplateDaoImpl<T extends Serializable> extends BaseDAO implements TemplateDao<T> {



    /** 实体类类型 */
    private Class<T> entityClass;


    @SuppressWarnings("unchecked")
    public TemplateDaoImpl() {
        Type type = getClass().getGenericSuperclass();
        Type[] parameterizedType = ((ParameterizedType) type).getActualTypeArguments();
        entityClass = (Class<T>) parameterizedType[0];
    }


    @Override
    public Long add(T e) throws DAOException {
        return (Long)insert(this.getClass().getName()+".insert",e);
    }

    @Override
    public int delete(Long id) throws DAOException {
        return delete(this.getClass().getName()+".delete",id);
    }

    @Override
    public T get(Long id) throws DAOException {
        return (T)queryForObject(this.getClass().getName()+".get",id);
    }

    @Override
    public int update(T t) throws DAOException {
        return update(this.getClass().getName()+".update",t);
    }

    @Override
    public int batchUpdateStatus(List<Long> idList) throws DAOException {
        Map<String, List<Long>> params = Maps.newConcurrentMap();
        params.put("idList",idList);
        return update(this.getClass().getName()+".batchUpdateStatusByIdList",params);
    }

    @Override
    public List<T> query(Map queryData) throws DAOException {
        return  queryForList(this.getClass().getName() + ".query", queryData);
    }
    @Override
    public Integer queryCount(Map queryData) throws DAOException {

        return  (Integer) queryForObject(this.getClass().getName()+".queryCount",queryData);
    }

    @Override
    public List<T> exportQuery(Map query) throws DAOException {
        return queryForList(this.getClass().getName()+".exportQuery",query);
    }
}
