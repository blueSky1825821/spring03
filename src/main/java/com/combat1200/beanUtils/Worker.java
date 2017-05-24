package com.combat1200.beanUtils;

import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by sky on 2017/5/23.
 * javaBean 动态排序
 */
public class Worker {
    private int id;
    private String name;
    private double salary;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.NO_FIELD_NAMES_STYLE).append(id).append(name).append(salary).toString();
    }

    public static void main(String[] args) {
        Worker worker1 = new Worker();
        worker1.setId(1);
        worker1.setName("wang");
        worker1.setSalary(1000);

        Worker worker2 = new Worker();
        worker2.setId(2);
        worker2.setName("li");
        worker2.setSalary(100);

        List<Worker> list = new ArrayList<>();
        list.add(worker1);
        list.add(worker2);
        for (Worker worker : list) {
            System.out.println(worker);
        }
        Collections.sort(list, new BeanComparator("salary"));
        System.out.println("按工资排序后");
        for (Worker worker : list) {
            System.out.println(worker);
        }

    }
}
