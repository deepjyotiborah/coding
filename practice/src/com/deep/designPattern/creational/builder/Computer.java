package com.deep.designPattern.creational.builder;

public class Computer {
    private String RAM;

    private String CPU;

    private boolean isGraphicsEnabled;

    private boolean isBluetoothEnabled;

    public Computer(ComputerBuilder computerBuilder) {
        this.RAM = computerBuilder.RAM;
        this.CPU = computerBuilder.CPU;
        this.isGraphicsEnabled = computerBuilder.isGraphicsEnabled;
        this.isBluetoothEnabled = computerBuilder.isBluetoothEnabled;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "RAM='" + RAM + '\'' +
                ", CPU='" + CPU + '\'' +
                ", isGraphicsEnabled=" + isGraphicsEnabled +
                ", isBluetoothEnabled=" + isBluetoothEnabled +
                '}';
    }

    public static class ComputerBuilder {
        private String RAM;

        private String CPU;

        private boolean isGraphicsEnabled;

        private boolean isBluetoothEnabled;


        public ComputerBuilder withRAM(String ram) {
            this.RAM = ram;
            return this;
        }

        public ComputerBuilder withCPU(String cpu) {
            this.CPU = cpu;
            return this;
        }

        public ComputerBuilder withGraphics(boolean isGraphicsEnabled) {
            this.isGraphicsEnabled = isGraphicsEnabled;
            return this;
        }

        public ComputerBuilder withBluetooth(boolean isBluetoothEnabled) {
            this.isBluetoothEnabled = isBluetoothEnabled;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}
