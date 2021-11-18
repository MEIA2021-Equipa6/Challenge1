package org.engcia.model;

public class Sensor {

    private String subSystem;
    private String type;
    private int number;
    private double value;

    public Sensor(String name,int value) {
        this.subSystem = name;
        this.value = value;
    }

    public Sensor(String subSystem, String type, int number, int value) {
        this.subSystem = subSystem;
        this.type = type;
        this.number = number;
        this.value = value;
    }

    public Sensor() {

    }

    public String getSubSystem() {
        return subSystem;
    }

    public void setSubSystem(String subSystem) {
        this.subSystem = subSystem;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
