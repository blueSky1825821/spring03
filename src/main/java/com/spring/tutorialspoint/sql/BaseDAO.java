package com.spring.tutorialspoint.sql;


import com.ibatis.sqlmap.engine.impl.SqlMapClientImpl;
import com.ibatis.sqlmap.engine.mapping.sql.Sql;
import com.ibatis.sqlmap.engine.scope.SessionScope;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import java.util.List;
import java.util.Map;


/**
 * 数据操作基础类
 * 
 * @author johny
 *
 */
public class BaseDAO implements InitializingBean {

  protected Logger logger = LoggerFactory.getLogger(this.getClass());

  protected SqlMapClientTemplate sqlMapClient;

  @Override
  public void afterPropertiesSet() throws Exception {
    if (sqlMapClient == null) {
      throw new Exception("BaseDAO initilize fail,check related spring's configuration file");
    }
  }


  public int update(String statementName, Object parameterObject) throws DAOException {
    try {
      int num = sqlMapClient.update(statementName, parameterObject);
      if (num > 0) {
        printSql(statementName, parameterObject);
      }

      return num;
    } catch (DataAccessException e) {
      throw new DAOException("[BaseDAO-update]", e);
    }
  }


  public Object insert(String statementName, Object parameterObject) throws DAOException {
    try {
      printSql(statementName, parameterObject);
      Object obj = sqlMapClient.insert(statementName, parameterObject);


      return obj;

    } catch (DataAccessException e) {
      throw new DAOException("[BaseDAO-insert]", e);
    }
  }



  public int delete(String statementName, Object parameterObject) throws DAOException {
    try {
      int num = sqlMapClient.delete(statementName, parameterObject);
      if (num > 0) {
        printSql(statementName, parameterObject);
      }

      return num;
    } catch (DataAccessException e) {
      throw new DAOException("[BaseDAO-delete]", e);
    }
  }


  public Object queryForObject(String statementName, Object parameterObject) throws DAOException {
    try {
      return sqlMapClient.queryForObject(statementName, parameterObject);
    } catch (DataAccessException e) {
      throw new DAOException("[BaseDAO-queryForObject]", e);
    }
  }

  public List queryForList(String statementName, Object parameterObject) throws DAOException {
    try {
      return sqlMapClient.queryForList(statementName, parameterObject);
    } catch (DataAccessException e) {
      throw new DAOException("[BaseDAO-queryForList]", e);
    }
  }

  /**
   * 取List，包含分页
   * 
   * @param statementName
   * @param parameterObject
   * @param pageNo 页次
   * @param pageSize 每页记录数
   * @return
   * @throws DAOException
   * @author zhengqing
   */
  public List<?> queryForList(String statementName, Object parameterObject, int pageNo, int pageSize)
      throws DAOException {
    try {
      return sqlMapClient.queryForList(statementName, parameterObject, pageSize * (pageNo - 1), pageSize);
    } catch (DataAccessException e) {
      throw new DAOException("[BaseDAO-queryForList]", e);
    }
  }

  public Map<?, ?> queryForMap(String statementName, Object parameterObject, String keyProperty) throws DAOException {
    try {
      return sqlMapClient.queryForMap(statementName, parameterObject, keyProperty);
    } catch (DataAccessException e) {
      throw new DAOException("[BaseDAO-queryForMap]", e);
    }
  }

  /**
   * ibatis sqlmap 不同版本的类区别太大，因为本jar采用了两套方案， 2.3.0 和 2.3.5 提取sql
   **/
  private void printSql(String statementName, Object parameterObject) {
    SqlMapClientImpl client = (SqlMapClientImpl)sqlMapClient.getSqlMapClient();
    com.ibatis.sqlmap.engine.mapping.statement.MappedStatement ms = client.getMappedStatement(statementName);
    Sql sql = ms.getSql();

    SessionScope sessionScope = new SessionScope();
    sessionScope.incrementRequestStackDepth();
    com.ibatis.sqlmap.engine.scope.RequestScope requestScope = new com.ibatis.sqlmap.engine.scope.RequestScope();
    requestScope.setStatement(ms);
    String sqlString = sql.getSql(requestScope, parameterObject);

    logger.error(sqlString);
  }



  public Object insertOrUpdate(String countStatementName, String insertStatementName, String updateStatementName,
      Object parameterObject) throws DAOException {
    Integer count = (Integer) this.queryForObject(countStatementName, parameterObject);
    if (null != count && count.intValue() > 0) {
      int u = this.update(updateStatementName, parameterObject);
      return new Integer(u);
    }
    return this.insert(insertStatementName, parameterObject);
  }

  public void setSqlMapClient(SqlMapClientTemplate sqlMapClient) {
    this.sqlMapClient = sqlMapClient;
  }

  public SqlMapClientTemplate getSqlMapClient() {
    return sqlMapClient;
  }

  public static void main(String[] args) {
    String em = "1";
    long uid = Long.parseLong(em);
    System.out.println(uid);
  }

}
