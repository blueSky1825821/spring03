package com.design.pattern.agent;

/**
 * Created by wm on 18-1-4.
 * 要访问被代理角色必须通过代理
 * - 抽象主题角色：定义了被代理角色和代理角色的共同接口或者抽象类。
   - 被代理角色：实现或者继承抽象主题角色，定义实现具体业务逻辑的实现。
   - 代理角色：实现或者继承抽象主题角色，持有被代理角色的引用，控制和限制被代理角色的实现，并且拥有自己的处理方法（预处理和善后）
 */
public interface Subject {
    public void movie();
}
