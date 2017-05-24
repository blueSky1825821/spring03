package com.combat1200.beanUtils;

import org.apache.commons.beanutils.PropertyUtils;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by sky on 2017/5/23.
 */
public class Company {
    private Employee employee = new Employee();

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public static void main(String[] args) {
        Company company = new Company();
        try {
            //使用PropertyUtils类的方法对Employee对象的域赋值
            PropertyUtils.setNestedProperty(company, "employee.name", "wang");
            PropertyUtils.setNestedProperty(company, "employee.phoneNumber[0]","1234567");
            PropertyUtils.setNestedProperty(company, "employee.address(home)", "anhui");

            //获得employee对象的属性值
            String name = (String) PropertyUtils.getNestedProperty(company, "employee.name");
            String phoneNumber = (String) PropertyUtils.getNestedProperty(company, "employee.phoneNumber[0]");
            String address = (String) PropertyUtils.getNestedProperty(company, "employee.address(home)");
            System.out.println(name + "\t" + phoneNumber + "\t" + address + "\t");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
