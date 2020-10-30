package com.gc.generic;/*
/*
	泛型方法和静态方法泛型
	泛型类定义的泛型 在整个类中有效 如果被方法使用
	那么泛型类的对象明确要操作的具体类型后，所有要操作的类型就已经固定
	为了让不同方法可以操作不同类型  而且类型还不确定
	那么可以将泛型定义在方法上 
	
	静态方法泛型：
	静态方法不可以访问类上定义的泛型
	如果静态方法操作的应用数据类型不确定，可以将泛型定义在方法上
*/

class Demo<T> {
    public void method(T t) {
        System.out.println("method :" + t);
    }

    public static <W> void staticMethod(W w) {
        System.out.println("staticMethod :" + w);
    }

    public <K> void show(K k) {
        System.out.println("Show :" + k);
    }

    public <Q> void print(Q q) {
        System.out.println("Print :" + q);
    }
}

class TestDemo {
    public static void main(String[] arags) {
        Demo<Double> d = new Demo<Double>();

        d.method(3.4);

        Demo.staticMethod(true);

        d.show("haha");

        d.print(new Integer(4));
    }
}