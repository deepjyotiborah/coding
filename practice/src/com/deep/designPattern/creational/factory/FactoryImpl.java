package com.deep.designPattern.creational.factory;

public class FactoryImpl {
    public static void main(String[] args) {
        Computer pc = ComputerFactory.getComputer("PC","2GB","2.4GHz", "500GB");
        Computer server = ComputerFactory.getComputer("Server","8GB","3.1GHz", "2TB");

        System.out.println("PC details = " + pc);
        System.out.println("Server details = " + server);
    }
}
