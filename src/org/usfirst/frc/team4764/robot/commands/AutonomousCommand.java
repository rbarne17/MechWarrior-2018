 package org.usfirst.frc.team4764.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousCommand extends CommandGroup {

	public AutonomousCommand() {

	}

	/*
	 * possible paths: OneLeftSwitch OneLeftSwitchWait OneRightSwitchDefense
	 * OneLeftScale OneLeftScaleWait OneRightScaleDefense TwoLeftSwitch
	 * TwoLeftSwitchWait TwoLeftSwitchDefense TwoRightSwitch TwoRightSwitchWait
	 * TwoRightSwitchDefense TwoLeftScale TwoLeftScaleWait TwoLeftScaleDefense
	 * TwoRightScale TwoRightScaleWait TwoRightScaleDefense ThreeRightSwitch
	 * ThreeRightSwitchWait ThreeLeftSwitchDefense ThreeRightScale
	 * ThreeRightScaleWait ThreeLeftScaleDefense
	 */

	public AutonomousCommand(String autonomousCommandName) {
		switch (autonomousCommandName) {
		case "OneLeftSwitchScore":
			//? ft to drive foward
			;
			break;
		case "OneLeftSwitchWaitScore":
			//? ft to drive foward
			;
			break;
		case "OneRightSwitchDefend":
			//? ft to drive foward
			;
			break;
		case "OneLeftScaleScore":
			//Drive 13.5 ft straight
			// raise lifter 5.5 ft high
			;
			break;
		case "OneLeftScaleWaitScore":
			//Drive 13.5 ft straight
			//raise lifter 5.5 ft high
			;
			break;
		case "OneRightScaleDefend":
			//raise lifter 5.5 ft high
			//Drive 13.5 ft straight
			;
			break;
		case "TwoLeftSwitchScore":
			;
			break;
		case "TwoLeftSwitchWaitScore":
			;
			break;
		case "TwoLeftSwitchDefend":
			;
			break;
		case "TwoRightSwitchScore":
			;
			break;
		case "TwoRightSwitchWaitScore":
			;
			break;
		case "TwoRightSwitchDefend":
			;
			break;
		case "TwoLeftScaleScore":
			;
			break;
		case "TwoLeftScaleWaitScore":
			;
			break;
		case "TwoLeftScaleDefend":
			;
			break;
		case "TwoRightScaleScore":
			;
			break;
		case "TwoRightScaleWaitScore":
			;
			break;
		case "TwoRightScaleDefend":
			;
			break;
		case "ThreeRightSwitchSore":
			;
			break;
		case "ThreeRightSwitchWaitScore":
			;
			break;
		case "ThreeLeftSwitchDefend":
			;
			break;
		case "ThreeRightScaleScore":
			;
			break;
		case "ThreeRightScaleWaitScore":
			;
			break;
		case "ThreeLeftScaleDefend":
			;
			break;
		}
	}
}
