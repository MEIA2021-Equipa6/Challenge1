package org.engcia.model;

public enum ConclusionType {

    SUB_SYSTEM_THERMAL_SENSOR_ERROR("{0} Thermal Sensor Error: {1}"),
    SUB_SYSTEM_THERMAL_SUB_SYSTEM_FAILURE("{0} Thermal Full Failure"),
    SUB_SYSTEM_THERMAL_SYS_SYSTEM_OK("{0} Thermal OK"),
    SUB_SYSTEM_VOLTAGE_SENSOR_ERROR("{0} Voltage Sensor Error: {1}"),
    SUB_SYSTEM_VOLTAGE_SUB_SYSTEM_FAILURE("{0} Voltage Full Failure"),
    SUB_SYSTEM_VOLTAGE_SUB_SYSTEM_OK("{0} Voltage OK"),
    SUB_SYSTEM_CURRENT_SENSOR_ERROR("{0} Current Sensor Error: {1}"),
    SUB_SYSTEM_CURRENT_SUB_SYSTEM_FAILURE("{0} Current Full Failure"),
    SUB_SYSTEM_CURRENT_SUB_SYSTEM_OK("{0} Current OK"),
    SUB_SYSTEM_SWITCH_NOT_OFF("{0} switch not off"),
    SUB_SYSTEM_SWITCH_NOT_ON("{0} switch not on");

    String description;

    ConclusionType(String description){
        this.description = description;
    }
}
