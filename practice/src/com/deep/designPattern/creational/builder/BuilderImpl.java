package com.deep.designPattern.creational.builder;

public class BuilderImpl {
    public static void main(String[] args) {
        Computer computer = new Computer.ComputerBuilder()
                                    .withRAM("3GB")
                                    .withCPU("2GHz")
                                    .withBluetooth(false)
                                    .withGraphics(true)
                                    .build();

        System.out.println(computer);
    }
}
