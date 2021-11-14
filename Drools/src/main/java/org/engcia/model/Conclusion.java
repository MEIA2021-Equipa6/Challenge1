package org.engcia.model;

public class Conclusion {
    public static final String AOCSThermalSensorError = "AOCS Thermal Sensor Error: ";
    public static final String AOCSThermalSubSystemFailure = "AOCS Thermal Full Failure";
    public static final String AOCSVoltageSensorError = "AOCS Voltage Sensor Error: ";
    public static final String AOCSVoltageSubSystemFailure = "AOCS Voltage Full Failure";
    public static final String AOCSCurrentSensorError = "AOCS Current Sensor Error: ";
    public static final String AOCSCurrentSubSystemFailure = "AOCS Current Full Failure";

    public static final String PayloadThermalSensorError = "Payload Thermal Sensor Error: ";
    public static final String PayloadThermalSubSystemFailure = "Payload Thermal Full Failure";
    public static final String PayloadVoltageSensorError = "Payload Voltage Sensor Error: ";
    public static final String PayloadVoltageSubSystemFailure = "Payload Voltage Full Failure";
    public static final String PayloadCurrentSensorError = "Payload Current Sensor Error: ";
    public static final String PayloadCurrentSubSystemFailure = "Payload Current Full Failure";

    public static final String SwitchThermalSensorError = "Switch Module Thermal Sensor Error: ";
    public static final String SwitchThermalSubSystemFailure = "Switch Module Thermal Full Failure";
    public static final String SwitchVoltageSensorError = "Switch Module Voltage Sensor Error: ";
    public static final String SwitchVoltageSubSystemFailure = "Switch Module Voltage Full Failure";
    public static final String SwitchCurrentSensorError = "Switch Module Current Sensor Error: ";
    public static final String SwitchCurrentSubSystemFailure = "Switch Module Current Full Failure";

    public static final String OBCThermalSensorError = "OBC Thermal Sensor Error: ";
    public static final String OBCThermalSubSystemFailure = "OBC Thermal Full Failure";
    public static final String OBCVoltageSensorError = "OBC Voltage Sensor Error: ";
    public static final String OBCVoltageSubSystemFailure = "OBC Voltage Full Failure";
    public static final String OBCCurrentSensorError = "OBC Current Sensor Error: ";
    public static final String OBCCurrentSubSystemFailure = "OBC Current Full Failure";

    public static final String CommunicationThermalSensorError = "Communication Thermal Sensor Error: ";
    public static final String CommunicationThermalSubSystemFailure = "Communication Thermal Full Failure";
    public static final String CommunicationVoltageSensorError = "Communication Voltage Sensor Error: ";
    public static final String CommunicationVoltageSubSystemFailure = "Communication Voltage Full Failure";
    public static final String CommunicationCurrentSensorError = "Communication Current Sensor Error: ";
    public static final String CommunicationCurrentSubSystemFailure = "Communication Current Full Failure";

    public static final String ThermalControllerThermalSensorError = "Thermal Controller Thermal Sensor Error: ";
    public static final String ThermalControllerThermalSubSystemFailure = "Thermal Controller Thermal Full Failure";
    public static final String ThermalControllerVoltageSensorError = "Thermal Controller Voltage Sensor Error: ";
    public static final String ThermalControllerVoltageSubSystemFailure = "Thermal Controller Voltage Full Failure";
    public static final String ThermalControllerCurrentSensorError = "Thermal Controller Current Sensor Error: ";
    public static final String ThermalControllerCurrentSubSystemFailure = "Thermal Controller Current Full Failure";

    public static final String PropulsionThermalSensorError = "Propulsion Thermal Sensor Error: ";
    public static final String PropulsionThermalSubSystemFailure = "Propulsion Thermal Full Failure";
    public static final String PropulsionVoltageSensorError = "Propulsion Voltage Sensor Error: ";
    public static final String PropulsionVoltageSubSystemFailure = "Propulsion Voltage Full Failure";
    public static final String PropulsionCurrentSensorError = "Propulsion Current Sensor Error: ";
    public static final String PropulsionCurrentSubSystemFailure = "Propulsion Current Full Failure";

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
