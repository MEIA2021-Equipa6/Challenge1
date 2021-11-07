package org.engcia.model;

public class Conclusion {
    public static final String SensorMismatch = "Sensor Mismatch";
    public static final String SensorBadValue = "Sensor Bad Value";


    private String description;
    private String sensorName;

    public Conclusion(String description, String sensorName) {
        super();
        this.description = description;
        this.sensorName = sensorName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString() {
        return "Diagnosis: " + description + " in the Sensor: " + sensorName;
    }

    public String getSensorName() {
        return sensorName;
    }

    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }

}
