package org.engcia.model;

public class Conclusion {
    public static final String AOCSThermalSensorPartialFailure = "AOCS Thermal Partial Failure";
    public static final String AOCSThermalSensorFullFailure = "AOCS Thermal Full Failure";
    public static final String AOCSPowerSensorPartialFailure = "AOCS Power Partial Failure";
    public static final String AOCSPowerSensorFullFailure = "AOCS Power Full Failure";
    public static final String AOCSVoltageSensorPartialFailure = "AOCS Voltage Partial Failure";
    public static final String AOCSVoltageSensorFullFailure = "AOCS Voltage Full Failure";
    public static final String AOCSCurrentSensorPartialFailure = "AOCS Current Partial Failure";
    public static final String AOCSCurrentSensorFullFailure = "AOCS Current Full Failure";

    public static final String PayloadThermalSensorPartialFailure = "Payload Thermal Partial Failure";
    public static final String PayloadThermalSensorFullFailure = "Payload Thermal Full Failure";
    public static final String PayloadPowerSensorPartialFailure = "Payload Power Partial Failure";
    public static final String PayloadPowerSensorFullFailure = "Payload Power Full Failure";
    public static final String PayloadVoltageSensorPartialFailure = "Payload Voltage Partial Failure";
    public static final String PayloadVoltageSensorFullFailure = "Payload Voltage Full Failure";
    public static final String PayloadCurrentSensorPartialFailure = "Payload Current Partial Failure";
    public static final String PayloadCurrentSensorFullFailure = "Payload Current Full Failure";

    public static final String PowerThermalSensorPartialFailure = "Power Module Thermal Partial Failure";
    public static final String PowerThermalSensorFullFailure = "Power Module Thermal Full Failure";
    public static final String PowerPowerSensorPartialFailure = "Power Module Power Partial Failure";
    public static final String PowerPowerSensorFullFailure = "Power Module Power Full Failure";
    public static final String PowerVoltageSensorPartialFailure = "Power Module Voltage Partial Failure";
    public static final String PowerVoltageSensorFullFailure = "Power Module Voltage Full Failure";
    public static final String PowerCurrentSensorPartialFailure = "Power Module Current Partial Failure";
    public static final String PowerCurrentSensorFullFailure = "Power Module Current Full Failure";

    public static final String OBCThermalSensorPartialFailure = "OBC Thermal Partial Failure";
    public static final String OBCThermalSensorFullFailure = "OBC Thermal Full Failure";
    public static final String OBCPowerSensorPartialFailure = "OBC Power Partial Failure";
    public static final String OBCPowerSensorFullFailure = "OBC Power Full Failure";
    public static final String OBCVoltageSensorPartialFailure = "OBC Voltage Partial Failure";
    public static final String OBCVoltageSensorFullFailure = "OBC Voltage Full Failure";
    public static final String OBCCurrentSensorPartialFailure = "OBC Current Partial Failure";
    public static final String OBCCurrentSensorFullFailure = "OBC Current Full Failure";

    public static final String CommunicationThermalSensorPartialFailure = "Communication Thermal Partial Failure";
    public static final String CommunicationThermalSensorFullFailure = "Communication Thermal Full Failure";
    public static final String CommunicationPowerSensorPartialFailure = "Communication Power Partial Failure";
    public static final String CommunicationPowerSensorFullFailure = "Communication Power Full Failure";
    public static final String CommunicationVoltageSensorPartialFailure = "Communication Voltage Partial Failure";
    public static final String CommunicationVoltageSensorFullFailure = "Communication Voltage Full Failure";
    public static final String CommunicationCurrentSensorPartialFailure = "Communication Current Partial Failure";
    public static final String CommunicationCurrentSensorFullFailure = "Communication Current Full Failure";

    public static final String ThermalControllerThermalSensorPartialFailure = "Thermal Controller Thermal Partial Failure";
    public static final String ThermalControllerThermalSensorFullFailure = "Thermal Controller Thermal Full Failure";
    public static final String ThermalControllerPowerSensorPartialFailure = "Thermal Controller Power Partial Failure";
    public static final String ThermalControllerPowerSensorFullFailure = "Thermal Controller Power Full Failure";
    public static final String ThermalControllerVoltageSensorPartialFailure = "Thermal Controller Voltage Partial Failure";
    public static final String ThermalControllerVoltageSensorFullFailure = "Thermal Controller Voltage Full Failure";
    public static final String ThermalControllerCurrentSensorPartialFailure = "Thermal Controller Current Partial Failure";
    public static final String ThermalControllerCurrentSensorFullFailure = "Thermal Controller Current Full Failure";

    public static final String PropulsionThermalSensorPartialFailure = "Propulsion Thermal Partial Failure";
    public static final String PropulsionThermalSensorFullFailure = "Propulsion Thermal Full Failure";
    public static final String PropulsionPowerSensorPartialFailure = "Propulsion Power Partial Failure";
    public static final String PropulsionPowerSensorFullFailure = "Propulsion Power Full Failure";
    public static final String PropulsionVoltageSensorPartialFailure = "Propulsion Voltage Partial Failure";
    public static final String PropulsionVoltageSensorFullFailure = "Propulsion Voltage Full Failure";
    public static final String PropulsionCurrentSensorPartialFailure = "Propulsion Current Partial Failure";
    public static final String PropulsionCurrentSensorFullFailure = "Propulsion Current Full Failure";

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
