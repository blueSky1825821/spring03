package com.spring.tutorialspoint.sql.test;


import junit.framework.TestCase;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration(locations = {"classpath*:datasource.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
//@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public abstract class BaseDaoTest extends TestCase {
}
