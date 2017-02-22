package com.spring.tutorialspoint.manager.impls;


import com.spring.tutorialspoint.exception.DAOException;
import com.spring.tutorialspoint.manager.TemplateManager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class TemplateManagerImpl<T extends Serializable> implements TemplateManager<T> {


    @Override
    public Long add(T e) {
        try {
            return getDao().add(e);
        } catch (DAOException e1) {
            e1.printStackTrace();
            return -1l;
        }
    }

    @Override
    public int delete(Long id) {
        try {
            return getDao().delete(id);
        } catch (DAOException e) {
            e.printStackTrace();
            return  -1;
        }
    }

    @Override
    public T get(Long id) {
        try {
            return getDao().get(id);
        } catch (DAOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int update(T t) {
        try {
            return getDao().update(t);
        } catch (DAOException e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public List<T> query(Map queryData) {
        try {
            return getDao().query(queryData);
        } catch (DAOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public Integer queryCount(Map queryData) {
        try {
            return getDao().queryCount(queryData);
        } catch (DAOException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
