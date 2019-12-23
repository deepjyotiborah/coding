package com.deep.designPattern.creational.singleton;

import java.io.*;

public class SerializeSingleton {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Singleton singletonObj_1 = Singleton.getInstance();
        ObjectOutput output = new ObjectOutputStream(new FileOutputStream("obj.ser"));
        output.writeObject(singletonObj_1);

        //Deserialize Object
        ObjectInput input = new ObjectInputStream(new FileInputStream("obj.ser"));
        Singleton singletonObj_2 = (Singleton) input.readObject();

        /*
            Hash code of objects before and after serialization is different.
            To resolve singleton issue in serialization implement readResolve method.(Uncomment readResolve in Singleton.)
         */
        System.out.println("Hash of first obj - " + singletonObj_1.hashCode());
        System.out.println("Hash of second obj - " + singletonObj_2.hashCode());

    }
}
