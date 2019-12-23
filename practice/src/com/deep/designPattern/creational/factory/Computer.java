package com.deep.designPattern.creational.factory;

public abstract class Computer {
    public abstract String getRAM();
    public abstract String getCPU();
    public abstract String getHDD();

    @Override
    public String toString() {
        return "RAM : " + getRAM() + ", CPU : " + getCPU() + ", HDD : " + getHDD();
    }
}
