package com.design.pattern.oberserver;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wm on 18-1-4.
 * 目标对象
 * 1、一个目标可以被多个观察者观察
 * 2、目标提供对观察者注册和退订的维护
 * 3、当目标的状态发生变化时，目标负责同志所有注册的、有效的观察者
 */
public class Subject {
    /**
     * 用来保存注册的观察者对象
     */
    private List<Observer> observers = new ArrayList<>();

    /**
     * 注册观察者对象
     * @param observer
     */
    public void attach(Observer observer) {
        observers.add(observer);
    }

    /**
     * 删除观察者对象
     * @param observer
     */
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    /**
     * 通知所有注册的观察者对象
     */
    protected void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }
}
