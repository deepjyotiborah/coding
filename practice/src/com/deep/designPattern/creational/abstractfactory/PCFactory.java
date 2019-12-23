package com.deep.designPattern.creational.abstractfactory;

import com.deep.designPattern.creational.factory.Computer;
import com.deep.designPattern.creational.factory.PC;

public class PCFactory implements AbstractComputerFactory {

    private String ram,  cpu,  hdd;

    public PCFactory(String ram, String cpu, String hdd) {
        this.ram = ram;
        this.cpu = cpu;
        this.hdd = hdd;
    }

    @Override
    public Computer createComputer() {
        return new PC(ram, cpu, hdd);
    }
}
