package com.deep.random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Testing {
    public static void main(String[] args) {
        Dog dog  = new Dog("dog");
        Dog1 dog1 = new Dog1("dog1");
        Dog1 dog2 = new Dog1("dog2");

        List<Dog> list  = new ArrayList<>();
        list.add(dog);
        list.add(dog2);
        List<? super Dog> dogs = new ArrayList<>();
        dogs.add(dog);
        dogs.add(dog1);
        Arrays.stream(dogs.toArray()).forEach(a -> System.out.println(a));

        List<? extends Dog> dogs1 = new ArrayList<>();
        dogs1 = list;
        Arrays.stream(dogs1.toArray()).forEach(a -> System.out.println(a));
    }
}

class Dog {
    private String name;

    public Dog() {}
    public Dog(String name) {
        this.name = name;
    }
    public void print() {
        System.out.println("I am from dog " + name);
    }
}


class Dog1 extends Dog {
    private String name;

    public Dog1(String name) {
        super();
        this.name = name;
    }

    private void test() {
        System.out.println("Test from dog1");
    }

    public void print() {
        System.out.println("I am from dog1 " + name);
    }
}

class Dog12 extends Dog {
    private String name;

    public Dog12(String name) {
        super();
        this.name = name;
    }

    private void test() {
        System.out.println("Test from dog2");
    }

    public void print() {
        System.out.println("I am from dog2 " + name);
    }
}