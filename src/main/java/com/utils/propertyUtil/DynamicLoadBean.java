package com.utils.propertyUtil;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.ChildBeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.ResourceEntityResolver;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

/**
 * 动态加载数据库
 *
 * @author johny
 */
public class DynamicLoadBean implements ApplicationContextAware {


    private ConfigurableApplicationContext applicationContext = null;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = (ConfigurableApplicationContext) applicationContext;
    }

    /**
     * 是否要加载
     */
    private String loadAble;

    /**
     * 加载的路径
     */
    private String loadPath;

    /**
     * 加载后生成的xml文件配置路径
     */
    private String loadTargetName;


    public ConfigurableApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public void init() {
        // 加载数据源
        if (StringUtils.equals(loadAble, "true")) {
            ConfigFileCreator.createConfigFile(loadPath, loadTargetName);
            loadBean("classpath:" + "/config/" + loadTargetName);
        }
    }

    /**
     * 1.配置文件的位置 2.配置文件中bean的名字
     *
     * @param fileName
     */
    public void loadBean(String fileName) {
        XmlBeanDefinitionReader beanDefinitionReader =
                new XmlBeanDefinitionReader((BeanDefinitionRegistry) getApplicationContext().getBeanFactory());
        beanDefinitionReader.setResourceLoader(getApplicationContext());
        beanDefinitionReader.setEntityResolver(new ResourceEntityResolver(getApplicationContext()));
        try {
            beanDefinitionReader.loadBeanDefinitions(getApplicationContext().getResources(fileName));
        } catch (BeansException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void registBean(String beanName, String parentName) {
        DefaultListableBeanFactory fcy = (DefaultListableBeanFactory) applicationContext.getAutowireCapableBeanFactory();
        BeanDefinition beanDefinition = new ChildBeanDefinition(parentName);
        fcy.registerBeanDefinition(beanName, beanDefinition);
    }

    public String getLoadAble() {
        return loadAble;
    }

    public void setLoadAble(String loadAble) {
        this.loadAble = loadAble;
    }

    public String getLoadPath() {
        return loadPath;
    }

    public void setLoadPath(String loadPath) {
        this.loadPath = loadPath;
    }

    public String getLoadTargetName() {
        return loadTargetName;
    }

    public void setLoadTargetName(String loadTargetName) {
        this.loadTargetName = loadTargetName;
    }
}
