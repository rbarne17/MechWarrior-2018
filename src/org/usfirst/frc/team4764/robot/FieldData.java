package org.usfirst.frc.team4764.robot;

import edu.wpi.first.wpilibj.DriverStation;

public class FieldData {
	public static DriverStation.Alliance alliance = DriverStation.getInstance().getAlliance();
	public static String allianceOrder = DriverStation.getInstance().getGameSpecificMessage();
	public static char switchSide = allianceOrder.charAt(1);
	public static char scaleSide = allianceOrder.charAt(2);
	public static int location = DriverStation.getInstance().getLocation();
	public static String locationString;
	public static String switchSideString;
	public static String scaleSideString;

	public FieldData() {
		switch(location) {
		case 1: locationString = "One";
		break;
		case 2: locationString = "Two";
		break;
		case 3: locationString = "Three";
		}
		
		switch(switchSide) {
		case 'L': switchSideString = "Left";
		break;
		case 'R': switchSideString = "Right";
		break;
		default: ; break;
		}
		
		switch(scaleSide) {
		case 'L': scaleSideString = "Left";
		break;
		case 'R': scaleSideString = "Right";
		break;
		}

	}

}
