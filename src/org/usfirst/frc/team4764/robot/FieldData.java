package org.usfirst.frc.team4764.robot;

import edu.wpi.first.wpilibj.DriverStation;

public class FieldData {
	public static DriverStation.Alliance alliance = DriverStation.getInstance().getAlliance();
	public static String allianceOrder = DriverStation.getInstance().getGameSpecificMessage();
	public static char switchSide = allianceOrder.charAt(1);
	public static char scaleSide = allianceOrder.charAt(2);
	public static int location = DriverStation.getInstance().getLocation();

	public FieldData() {
	}

}
