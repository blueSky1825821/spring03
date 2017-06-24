package com.test.test;

/**
 * Created by sky on 2017/5/18.
 * 多态
 */
class A {
    public String show(D obj) {
        return ("Comp and D");
    }

    public String show(A obj) {
        return ("Comp and Comp");
    }

    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new B();
        B b = new B();
        C c = new C();
        D d = new D();
        System.out.println(a1.show(b));//指向子类的父类引用由于向上转型了，它只能访问父类中拥有的方法和属性
        System.out.println(a1.show(c));
        System.out.println(a1.show(d));
        //4--B and Comp .首先a2是A引用，B实例，调用show（B b）方法，此方法在父类A中没有定义，所以B中方法show(B b)不会调用
        // （多态必须父类中已定义该方法），再按优先级为：this.show(O)、super.show(O)、this.show((super)O)、super.show((super)O)，
        // 即先查this对象的父类，没有重头再查参数的父类。查找super.show((super)O)时，B中没有，再向上，找到A中show(Comp a),因此执行。
        System.out.println(a2.show(b));
        System.out.println(a2.show(c));
        System.out.println(a2.show(d));
        System.out.println(b.show(b));
        System.out.println(b.show(c));
        System.out.println(b.show(d));
    }
}

class B extends A {
    public String show(B obj) {
        return ("B and B");
    }

    public String show(A obj) {
        return ("B and Comp");
    }
}

class C extends B {
}

class D extends B {
}
