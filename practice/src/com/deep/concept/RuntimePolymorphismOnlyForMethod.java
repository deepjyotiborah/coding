package com.deep.concept;


public class RuntimePolymorphismOnlyForMethod {
/*
    if a base class variable holds child class ref then it will refer to base class variable instead of child class variable.
    Reason is runtime polymorphism only for method. To access child class variable we need to typecast it.
 */
    public static void main(String[] args) {
        Base childRef = new Child();
        System.out.println("x value with child object ref : " + childRef.x);

        childRef.display();

        if (childRef instanceof Child) {
            System.out.println("Typecast value of x : " + ((Child) childRef).x);
        }
    }

}

class Base {
    int x = 10;

    protected void display() {
        System.out.println("Parent : x = " + x);
    }
}

class Child extends Base {
    int x = 200;

    protected void display() {
        System.out.println("Child : x = " + x);
    }
}
