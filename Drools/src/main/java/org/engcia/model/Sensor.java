package org.engcia.model;

public class Sensor extends Fact {

    private String subSystem;
    private String type;
    private int number;
    private double value;

    public Sensor(String subSystem, String type, int number, int value) {
        this.subSystem = subSystem;
        this.type = type;
        this.number = number;
        this.value = value;
    }

    public String getSubSystem() {
        return subSystem;
    }

    public String getType() {
        return type;
    }


    public double getValue() {
        return value;
    }

    @Override
    public String

    toString() {
        return "Sensor{" +
                "subSystem='" + subSystem + '\'' +
                ", type='" + type + '\'' +
                ", number=" + number +
                ", value=" + value +
                '}';
    }
}
