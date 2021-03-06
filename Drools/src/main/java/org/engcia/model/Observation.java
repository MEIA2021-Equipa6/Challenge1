package org.engcia.model;

import org.engcia.Main;

public class Observation extends Fact{
    public static final String AOCSThermalSensorError = "AOCS Thermal Sensor Error: ";
    public static final String AOCSThermalSubSystemFailure = "AOCS Thermal Full Failure";
    public static final String AOCSThermalSubSystemOK = "AOCS Thermal OK";
    public static final String AOCSVoltageSensorError = "AOCS Voltage Sensor Error: ";
    public static final String AOCSVoltageSubSystemFailure = "AOCS Voltage Full Failure";
    public static final String AOCSVoltageSubSystemOK = "AOCS Voltage OK";
    public static final String AOCSCurrentSensorError = "AOCS Current Sensor Error: ";
    public static final String AOCSCurrentSubSystemFailure = "AOCS Current Full Failure";
    public static final String AOCSCurrentSubSystemOK = "AOCS Current OK";

    public static final String PayloadThermalSensorError = "Payload Thermal Sensor Error: ";
    public static final String PayloadThermalSubSystemFailure = "Payload Thermal Full Failure";
    public static final String PayloadThermalSubSystemOK = "Payload Thermal OK";
    public static final String PayloadVoltageSensorError = "Payload Voltage Sensor Error: ";
    public static final String PayloadVoltageSubSystemFailure = "Payload Voltage Full Failure";
    public static final String PayloadVoltageSubSystemOK = "Payload Voltage OK";
    public static final String PayloadCurrentSensorError = "Payload Current Sensor Error: ";
    public static final String PayloadCurrentSubSystemFailure = "Payload Current Full Failure";
    public static final String PayloadCurrentSubSystemOK = "Payload Current OK";

    public static final String PowerThermalSensorError = "Power Module Thermal Sensor Error: ";
    public static final String PowerThermalSubSystemFailure = "Power Module Thermal Full Failure";
    public static final String PowerThermalSubSystemOK = "Power Thermal OK";
    public static final String PowerVoltageSensorError = "Power Module Voltage Sensor Error: ";
    public static final String PowerVoltageSubSystemFailure = "Power Module Voltage Full Failure";
    public static final String PowerVoltageSubSystemOK = "Voltage Thermal OK";
    public static final String PowerCurrentSensorError = "Power Module Current Sensor Error: ";
    public static final String PowerCurrentSubSystemFailure = "Power Module Current Full Failure";
    public static final String PowerCurrentSubSystemOK = "Power Current OK";

    public static final String OBCThermalSensorError = "OBC Thermal Sensor Error: ";
    public static final String OBCThermalSubSystemFailure = "OBC Thermal Full Failure";
    public static final String OBCThermalSubSystemOK = "OBC Thermal OK";
    public static final String OBCVoltageSensorError = "OBC Voltage Sensor Error: ";
    public static final String OBCVoltageSubSystemFailure = "OBC Voltage Full Failure";
    public static final String OBCVoltageSubSystemOK = "OBC Voltage OK";
    public static final String OBCCurrentSensorError = "OBC Current Sensor Error: ";
    public static final String OBCCurrentSubSystemFailure = "OBC Current Full Failure";
    public static final String OBCCurrentSubSystemOK = "OBC Current OK";

    public static final String CommunicationThermalSensorError = "Communication Thermal Sensor Error: ";
    public static final String CommunicationThermalSubSystemFailure = "Communication Thermal Full Failure";
    public static final String CommunicationThermalSubSystemOK = "Communication Thermal OK";
    public static final String CommunicationVoltageSensorError = "Communication Voltage Sensor Error: ";
    public static final String CommunicationVoltageSubSystemFailure = "Communication Voltage Full Failure";
    public static final String CommunicationVoltageSubSystemOK = "Communication Voltage OK";
    public static final String CommunicationCurrentSensorError = "Communication Current Sensor Error: ";
    public static final String CommunicationCurrentSubSystemFailure = "Communication Current Full Failure";
    public static final String CommunicationCurrentSubSystemOK = "Communication Current OK";

    public static final String ThermalControllerThermalSensorError = "Thermal Controller Thermal Sensor Error: ";
    public static final String ThermalControllerThermalSubSystemFailure = "Thermal Controller Thermal Full Failure";
    public static final String ThermalControllerThermalSubSystemOK = "Thermal Controller Thermal OK";
    public static final String ThermalControllerVoltageSensorError = "Thermal Controller Voltage Sensor Error: ";
    public static final String ThermalControllerVoltageSubSystemFailure = "Thermal Controller Voltage Full Failure";
    public static final String ThermalControllerVoltageSubSystemOK = "Thermal Controller Voltage OK";
    public static final String ThermalControllerCurrentSensorError = "Thermal Controller Current Sensor Error: ";
    public static final String ThermalControllerCurrentSubSystemFailure = "Thermal Controller Current Full Failure";
    public static final String ThermalControllerCurrentSubSystemOK = "Thermal Controller Current OK";

    public static final String PropulsionThermalSensorError = "Propulsion Thermal Sensor Error: ";
    public static final String PropulsionThermalSubSystemFailure = "Propulsion Thermal Full Failure";
    public static final String PropulsionThermalSubSystemOK = "Propulsion Thermal OK";
    public static final String PropulsionVoltageSensorError = "Propulsion Voltage Sensor Error: ";
    public static final String PropulsionVoltageSubSystemFailure = "Propulsion Voltage Full Failure";
    public static final String PropulsionVoltageSubSystemOK = "Propulsion Voltage OK";
    public static final String PropulsionCurrentSensorError = "Propulsion Current Sensor Error: ";
    public static final String PropulsionCurrentSubSystemFailure = "Propulsion Current Full Failure";
    public static final String PropulsionCurrentSubSystemOK = "Propulsion Current OK";

    public static final String  ReactionWheelsOn = "Reaction Wheels On";
    public static final String  ReactionWheelsOff = "Reaction Wheels Off";

    public String description;

    public Observation(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Observation{" +
                "description='" + description + '\'' +
                '}';
    }
}
