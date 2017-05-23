package com.test.www;

/**
 * Created by sky on 2017/5/18.
 */
class A {
    public void fly() {
        System.out.println("A is flying");
    }
}

class B extends A {
    @Override
    public void fly() {
        System.out.println("B is flying");
    }
}

class C extends B {
    @Override
    public void fly() {
        System.out.println("C is flying");
    }
}

class D extends B {
    @Override
    public void fly() {
        System.out.println("D is flying");
    }
}

public class Test1 {
    public static void main(String[] args) {
        B b = new B();
        A a = new A();
        f(a);//无多态
        f(b);//多态
        g(b);//多态
    }

    public static void f(A a1) {
        a1.fly();
    }

    public static void g(B b1) {
        b1 = new C();
        b1.fly(); //多态
    }
}

