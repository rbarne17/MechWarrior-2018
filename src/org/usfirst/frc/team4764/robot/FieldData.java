package org.usfirst.frc.team4764.robot;

import edu.wpi.first.wpilibj.DriverStation;

public class FieldData {
	public DriverStation.Alliance alliance = DriverStation.getInstance().getAlliance();
	public String allianceOrder = DriverStation.getInstance().getGameSpecificMessage();
	public char switchSide = allianceOrder.charAt(1);
	public char scaleSide = allianceOrder.charAt(2);
	public String switchSideString;
	public String scaleSideString;

	public FieldData() {

		switch (switchSide) {
		case 'L':
			switchSideString = "Left";
			break;
		case 'R':
			switchSideString = "Right";
			break;
		default:
			;
			break;
		}

		switch (scaleSide) {
		case 'L':
			scaleSideString = "Left";
			break;
		case 'R':
			scaleSideString = "Right";
			break;
		}

	}

}
