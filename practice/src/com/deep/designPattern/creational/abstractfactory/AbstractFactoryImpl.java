package com.deep.designPattern.creational.abstractfactory;

import com.deep.designPattern.creational.factory.Computer;

public class AbstractFactoryImpl {
    public static void main(String[] args) {
        Computer pc = ComputerFactory.getComputer(new PCFactory("2GB", "2.4GHz", "500GB"));
        Computer server = ComputerFactory.getComputer(new ServerFactory("8GB", "3.2GHz", "1TB"));

        System.out.println("PC -> " + pc);
        System.out.println("Server -> " + server);
    }
}
