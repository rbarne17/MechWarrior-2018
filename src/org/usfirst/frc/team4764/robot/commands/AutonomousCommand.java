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
			//drive foward 275ft
			new Drive(275.0,0.7);
			//raise the lifter 5.5 high
			new Lift(5.5,0.7);
			//turn 90 degrees to the right
			new Turn(90,0.7);
			//drive foward 1ft
			new Drive(1.2,0.7);
			//drop the cube
			new DropCube();
			;
			break;
		case "OneLeftScaleWaitScore":
			//wait 2.5 seconds
			//drive foward 27ft
			//raise the lifter 5.5 high
			//turn 90 degrees to the right
			//drive foward 1ft
			//drop the cube
			;
			break;
		case "OneRightScaleDefend":
			//Waiting for strategy			
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
			//drive 5ft foward
			//turn 90 degrees to the left
			//drive 3ft foward
			//turn 90 degrees to the right
			//drive foward 22ft
			//turn 90 degrees to the right
			//raise lifter 5.5 ft high
			//drive foward 1ft
			//drop cube.
			;
			break;
		case "TwoLeftScaleWaitScore":
			// wait 2.5 seconds
			//drive 5ft foward
			//turn 90 degrees to the left
			//drive 3ft foward
			//turn 90 degrees to the right
			//drive foward 22ft
			//turn 90 degrees to the right
			//raise lifter 5.5 ft high
			//drive foward 1ft
			//drop cube
			;
			break;
		case "TwoLeftScaleDefend":
			//Waiting for strategy
			;
			break;
		case "TwoRightScaleScore":
			//drive 5ft foward
			//turn 90 degrees to the right
			//drive 3ft foward
			//turn 90 degrees to the left
			//drive foward 22ft
			//turn 90 degrees to the left
			//raise lifter 5.5 ft high
			//drive foward 1ft
			//drop cube
			;
			break;
		case "TwoRightScaleWaitScore":
			//wait 2.5 seconds
			//drive 5ft foward
			//turn 90 degrees to the left
			//drive 3ft foward
			//turn 90 degrees to the right
			//drive foward 22ft
			//turn 90 degrees to the right
			//raise lifter 5.5 ft high
			//drive foward 1ft
			//drop cube
			;
			break;
		case "TwoRightScaleDefend":
			//Waiting for strategy
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
			//drive foward 27ft
			//raise the lifter 5.5 high
			//turn 90 degrees to the left
			//drive foward 1ft
			//drop the cube
			;
			break;
		case "ThreeRightScaleWaitScore":
			//drive foward 27ft
			//raise the lifter 5.5 high
			//turn 90 degrees to the left
			//drive foward 1ft
			//drop the cube
			;
			break;
		case "ThreeLeftScaleDefend":
			//Waiting for strategy
			;
			break;
		}
	}
}
