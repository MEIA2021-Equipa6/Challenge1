package org.engcia.model;

import org.engcia.Main;

import java.text.MessageFormat;

public class Conclusion extends Fact{
    public static final String AOCSSwitchNotOff = "AOCS switch not off";
    public static final String AOCSSwitchNotOn = "AOCS switch not on";
    public static final String AOCSLowCurrentError = "AOCS Low Current Error";
    public static final String AOCSHighCurrentError = "AOCS High Current Error";
    public static final String AOCSHighResistanceFailure = "AOCS High Resistance Failure";
    public static final String AOCSLowResistanceFailure = "AOCS Low Resistance Failure";
    public static final String AOCSRushFailure = "AOCS in rush error";

    public static final String PayloadSwitchNotOff = "Payload switch not off";
    public static final String PayloadSwitchNotOn = "Payload switch not on";
    public static final String PayloadLowCurrentError = "Payload Low Current Error";
    public static final String PayloadHighCurrentError = "Payload High Current Error";
    public static final String PayloadHighResistanceFailure = "Payload High Resistance Failure";
    public static final String PayloadLowResistanceFailure = "Payload Low Resistance Failure";
    public static final String PayloadRushFailure = "Payload in rush error";

    public static final String PowerSwitchNotOff = "Power switch not off";
    public static final String PowerSwitchNotOn = "Power switch not on";
    public static final String PowerLowCurrentError = "Power Low Current Error";
    public static final String PowerHighCurrentError = "Power High Current Error";
    public static final String PowerHighResistanceFailure = "Power High Resistance Failure";
    public static final String PowerLowResistanceFailure = "Power Low Resistance Failure";
    public static final String PowerRushFailure = "Power in rush error";

    public static final String OBCSwitchNotOff = "OBC switch not off";
    public static final String OBCSwitchNotOn = "OBC switch not on";
    public static final String OBCLowCurrentError = "OBC Low Current Error";
    public static final String OBCHighCurrentError = "OBC High Current Error";
    public static final String OBCHighResistanceFailure = "OBC High Resistance Failure";
    public static final String OBCLowResistanceFailure = "OBC Low Resistance Failure";
    public static final String OBCRushFailure = "OBC in rush error";

    public static final String CommunicationSwitchNotOff = "Communication switch not off";
    public static final String CommunicationSwitchNotOn = "Communication switch not on";
    public static final String CommunicationLowCurrentError = "Communication Low Current Error";
    public static final String CommunicationHighCurrentError = "Communication High Current Error";
    public static final String CommunicationHighResistanceFailure = "Communication High Resistance Failure";
    public static final String CommunicationLowResistanceFailure = "Communication Low Resistance Failure";
    public static final String CommunicationRushFailure = "Communication in rush error";

    public static final String ThermalControllerSwitchNotOff = "Thermal switch not off";
    public static final String ThermalControllerSwitchNotOn = "Thermal switch not on";
    public static final String ThermalControllerLowCurrentError = "Thermal Low Current Error";
    public static final String ThermalControllerHighCurrentError = "Thermal High Current Error";
    public static final String ThermalControllerHighResistanceFailure = "Thermal High Resistance Failure";
    public static final String ThermalControllerLowResistanceFailure = "Thermal Low Resistance Failure";
    public static final String ThermalControllerRushFailure = "Thermal in rush error";

    public static final String PropulsionSwitchNotOff = "Propulsion switch not off";
    public static final String PropulsionSwitchNotOn = "Propulsion switch not on";
    public static final String PropulsionLowCurrentError = "Propulsion Low Current Error";
    public static final String PropulsionHighCurrentError = "Propulsion High Current Error";
    public static final String PropulsionHighResistanceFailure = "Propulsion High Resistance Failure";
    public static final String PropulsionLowResistanceFailure = "Propulsion Low Resistance Failure";
    public static final String PropulsionRushFailure = "Propulsion in rush error";

    //Higher Level Conclusions
    public static final String PowerModuleEnergyGenerationFail = "Power Module Can't Provide Enough Energy";
    public static final String ThrustersNotOff = "Thrusters aren't off while Reaction wheels are working";
    public static final String AllReactionWheelsNotOn = "Not all Reaction Wheels turned On";
    public static final String GPSAndStarTrackSimultaneous = "GPS and Star Tracker can't Operate same time";

    private String description;

    public Conclusion(String description) {
        this.description = description;
        Main.agendaEventListener.addRhs(this);
    }

    public String toString() {
        return "Diagnosis: " + description;
    }

}
