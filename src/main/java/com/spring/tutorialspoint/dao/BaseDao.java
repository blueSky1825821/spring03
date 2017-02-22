package com.spring.tutorialspoint.dao;

import com.ibatis.sqlmap.client.SqlMapClient;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * Created by sky on 2017/2/6.
 */
public class BaseDao extends SqlMapClientDaoSupport {

    @Resource(name = "sqlMapClient")
    private SqlMapClient sqlMapClient;

    @PostConstruct
    public void initSqlMapClient(){
        super.setSqlMapClient(sqlMapClient);
    }
}
