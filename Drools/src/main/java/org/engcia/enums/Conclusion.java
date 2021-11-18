package org.engcia.enums;

public enum Conclusion {

    SUB_SYSTEM_THERMAL_SENSOR_ERROR("% Thermal Sensor Error: "),
    SUB_SYSTEM_THERMAL_SUB_SYSTEM_FAILURE("% Thermal Full Failure"),
    SUB_SYSTEM_THERMAL_SYS_SYSTEM_OK("% Thermal OK"),
    SUB_SYSTEM_VOLTAGE_SENSOR_ERROR("% Voltage Sensor Error: "),
    SUB_SYSTEM_VOLTAGE_SUB_SYSTEM_FAILURE("% Voltage Full Failure"),
    SUB_SYSTEM_VOLTAGE_SUB_SYSTEM_OK("% Voltage OK"),
    SUB_SYSTEM_CURRENT_SENSOR_ERROR("% Current Sensor Error: "),
    SUB_SYSTEM_CURRENT_SUB_SYSTEM_FAILURE("% Current Full Failure"),
    SUB_SYSTEM_CURRENT_SUB_SYSTEM_OK("% Current OK");

    String subSystem;

    Conclusion(String subSystem){
        this.subSystem = subSystem;
    }
}
