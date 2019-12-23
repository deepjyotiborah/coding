package com.deep.designPattern.creational.abstractfactory;

import com.deep.designPattern.creational.factory.Computer;

public class ComputerFactory {
    public static Computer getComputer(AbstractComputerFactory abstractComputerFactory) {
        return abstractComputerFactory.createComputer();
    }
}
