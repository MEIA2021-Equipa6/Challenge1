package org.engcia.model;

public class Sensor {

    private java.lang.String name;
    private int value;

    public Sensor(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public Sensor() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
