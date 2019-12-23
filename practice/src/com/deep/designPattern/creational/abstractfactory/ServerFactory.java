package com.deep.designPattern.creational.abstractfactory;

import com.deep.designPattern.creational.factory.Computer;
import com.deep.designPattern.creational.factory.Server;

public class ServerFactory implements AbstractComputerFactory{

    private String ram,  cpu, hdd;

    public ServerFactory(String ram, String cpu, String hdd) {
        this.ram = ram;
        this.cpu = cpu;
        this.hdd = hdd;
    }

    @Override
    public Computer createComputer() {
        return new Server(ram, cpu, hdd);
    }
}
