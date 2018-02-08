package org.usfirst.frc.team4764.robot;

import edu.wpi.first.wpilibj.DriverStation;

public class FieldData {
	public static DriverStation.Alliance Alliance = DriverStation.getInstance().getAlliance();
	public static String AllianceOrder = DriverStation.getInstance().getGameSpecificMessage();
	public static int Location = DriverStation.getInstance().getLocation();
	public static String AutonomousPathName;

	public FieldData() {
		switch (Integer.toString(Location) + AllianceOrder) {
		case "1LLL":
			AutonomousPathName = "1LLL";
			break;
		default:
			AutonomousPathName = "";
			break;

		}
	}

}
