package com.deep.designPattern.creational.singleton;

import java.io.Serializable;

public class Singleton implements Serializable {

    private static final long serialVersionUID = -1223457494875L;

    public static Singleton getInstance() {
        return SingletonHelper.INSTANCE;
    }

    /*
        implementing readResolve to fix singleton issue in serialization tp get same instance.
     */
//    public Object readResolve() {
//        return Singleton.getInstance();
//    }

    static class SingletonHelper {
        private static Singleton INSTANCE = new Singleton();
    }

    public static void main(String[] args) {
        Singleton singletonObj = Singleton.getInstance();
        System.out.println(singletonObj.hashCode());
        System.out.println(Singleton.getInstance().hashCode());
    }
}
