package com.spring.tutorialspoint.test;

import junit.framework.TestCase;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by sky on 2017/2/4.
 */
@ContextConfiguration(locations = {"classpath*:datasource.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public abstract class ImplTest extends TestCase {
}
