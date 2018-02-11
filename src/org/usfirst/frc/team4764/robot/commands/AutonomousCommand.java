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
			;
			break;
		case "OneLeftSwitchWaitScore":
			;
			break;
		case "OneRightSwitchDefend":
			;
			break;
		case "OneLeftScaleScore":
			;
			break;
		case "OneLeftScaleWaitScore":
			;
			break;
		case "OneRightScaleDefend":
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
