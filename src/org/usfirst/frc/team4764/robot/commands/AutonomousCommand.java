 package org.usfirst.frc.team4764.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousCommand extends CommandGroup {

	public AutonomousCommand() {

	}

	/*
	 * possible paths: OneLeftSwitchScore OneLeftSwitchWaitScore OneRightSwitchDefense
	 * OneLeftScaleScore OneLeftScaleWaitScore OneRightScaleDefense TwoLeftSwitchScore
	 * TwoLeftSwitchWaitScore TwoLeftSwitchDefense TwoRightSwitchScore TwoRightSwitchWaitScore
	 * TwoRightSwitchDefense TwoLeftScaleScore TwoLeftScaleWaitScore TwoLeftScaleDefense
	 * TwoRightScaleScore TwoRightScaleWaitScore TwoRightScaleDefense ThreeRightSwitchScore
	 * ThreeRightSwitchWaitScore ThreeLeftSwitchDefense ThreeRightScaleScore
	 * ThreeRightScaleWaitScore ThreeLeftScaleDefense
	 */

	public AutonomousCommand(String autonomousCommandName) {
		switch (autonomousCommandName) {
		case "OneLeftSwitchScore":
			//drive 14 feet forward
			//turn 90 degrees right
			//raise the lifter 2 feet
			//drive 2 feet forward
			//drop cube
			;
			break;
		case "OneLeftSwitchWaitScore":
			//wait 5 seconds
			//drive 14 feet forward
			//turn 90 degrees right
			//raise the lifter 2 feet
			//drive 2 feet forward
			//drop cube
			;
			break;
		case "OneRightSwitchDefend":
			//drive 27 feet forwards
			new Drive(27.0 ,0.7,'f');
			;
			break;
		case "OneLeftScaleScore":
			//drive foward 275ft
			new Drive(27.0,0.7,'f');
			//raise the lifter 5.5 high
			new Lift(5.5,0.7);
			//turn 90 degrees to the right
			new TurnRight(90,0.7);
			//drive foward 1ft
			new Drive(1.2,0.7,'f');
			//drop the cube
			new DropCube();
			;
			break;
		case "OneLeftScaleWaitScore":
			//wait 2.5 seconds
			Timer.delay(5);
			//drive foward 27ft
			new Drive(27.0,0.7,'f');
			//raise the lifter 5.5 high
			new Lift(5.5,0.7);
			//turn 90 degrees to the right
			new TurnRight(90,0.7);
			//drive foward 1ft
			new Drive(1.2,0.7,'f');
			//drop the cube
			new DropCube();
			;
			break;
		case "OneRightScaleDefend":
			//drive 27 feet forwards
			new Drive(27.0 ,0.7,'f');		
			;
			break;
		case "TwoLeftSwitchScore":
			//drive 5ft foward
			 new Drive(5.0,0.7,'f');
			//turn 90 degrees to the left
			 new TurnLeft(-90,0.7);
			//drive 3ft foward
			 new Drive(3.0,0.7,'f');
			//turn 90 degrees to the right
			 new TurnRight(90,0.7);
			 //drive forward 8 feet
			 //turn 90 degrees right
			 //lift cube 3 feet
			 //drive forward 1 foot
			 //drop cube
			;
			break;
		case "TwoLeftSwitchWaitScore":
			//wait 5 seconds
			//drive 5ft foward
			 new Drive(5.0,0.7,'f');
			//turn 90 degrees to the left
			 new TurnLeft(-90,0.7);
			//drive 3ft foward
			 new Drive(3.0,0.7,'f');
			//turn 90 degrees to the right
			 new TurnRight(90,0.7);
			 //drive forward 8 feet
			 //turn 90 degrees right
			 //lift cube 3 feet
			 //drive forward 1 foot
			 //drop cube
			;
			break;
		case "TwoLeftSwitchDefend":
			//drive 5ft foward
			 new Drive(5.0,0.7,'f');
			//turn 90 degrees to the left
			 new TurnLeft(-90,0.7);
			//drive 3ft foward
			 new Drive(3.0,0.7,'f');
			//turn 90 degrees to the right
			 new TurnRight(90,0.7);
			 //drive 17 feet forwards
			;
			break;
		case "TwoRightSwitchScore":
			//drive 5ft foward
			 new Drive(5.0,0.7,'f');
			//turn 90 degrees to the right
			 new TurnRight(-90,0.7);
			//drive 3ft foward
			 new Drive(3.0,0.7,'f');
			//turn 90 degrees to the Left
			 new TurnLeft(90,0.7);
			 //drive forward 8 feet
			 //turn 90 degrees left
			 //lift cube 3 feet
			 //drive forward 1 foot
			 //drop cube
			;
			break;
		case "TwoRightSwitchWaitScore":
			//wait 5 seconds
			//drive 5ft foward
			 new Drive(5.0,0.7,'f');
			//turn 90 degrees to the right
			 new TurnRight(-90,0.7);
			//drive 3ft foward
			 new Drive(3.0,0.7,'f');
			//turn 90 degrees to the Left
			 new TurnLeft(90,0.7);
			 //drive forward 8 feet
			 //turn 90 degrees left
			 //lift cube 3 feet
			 //drive forward 1 foot
			 //drop cube
			;
			break;
		case "TwoRightSwitchDefend":
			//wait 5 seconds
			//drive 5ft foward
			 new Drive(5.0,0.7,'f');
			//turn 90 degrees to the right
			 new TurnRight(-90,0.7);
			//drive 3ft foward
			 new Drive(3.0,0.7,'f');
			//turn 90 degrees to the Left
			 new TurnLeft(90,0.7);
			 //drive 18 feet forward
			;
			break;
		case "TwoLeftScaleScore":
			//drive 5ft foward
			 new Drive(5.0,0.7,'f');
			//turn 90 degrees to the left
			 new TurnLeft(-90,0.7);
			//drive 3ft foward
			 new Drive(3.0,0.7,'f');
			//turn 90 degrees to the right
			 new TurnRight(90,0.7);
			//drive foward 22ft
			 new Drive(22.0,0.7,'f');
			//turn 90 degrees to the right
			 new TurnRight(90,0.7);
			//raise lifter 5.5 ft high
			 new Lift(5.5,0.7);
			//drive foward 1ft
			 new Drive(1.0,0.7,'f');
			//drop cube.
			 new DropCube()
			;
			break;
		case "TwoLeftScaleWaitScore":
			// wait 2.5 seconds
			Timer.delay(5);
			//drive 5ft foward
			new Drive(5.0,0.7,'f');
			//turn 90 degrees to the left
			new TurnLeft(-90.0,0.7);
			//drive 3ft foward
			new Drive(3.0,0.7,'f');
			//turn 90 degrees to the righ
			new TurnRight(90,0.7);
			//drive foward 22ft
			new Drive(22.0,7,'f');
			//turn 90 degrees to the right
			new TurnRight(90,0.7);
			//raise lifter 5.5 ft high
			new Lift(5.5,0.7);
			//drive foward 1ft
			new Drive(1.0,0.7,'f');
			//drop cube
			new DropCube();
			;
			break;
		case "TwoLeftScaleDefend":
			//wait 5 seconds
			//drive 5ft foward
			 new Drive(5.0,0.7,'f');
			//turn 90 degrees to the right
			 new TurnRight(-90,0.7);
			//drive 3ft foward
			 new Drive(3.0,0.7,'f');
			//turn 90 degrees to the Left
			 new TurnLeft(90,0.7);
			 //drive 18 feet forward
			;
			break;
		case "TwoRightScaleScore":
			//drive 5ft foward
			new Drive(5.0,0.7,'f');
			//turn 90 degrees to the right
			new TurnRight(90,0.7);
			//drive 3ft foward
			new Drive(3.0,0.7,'f');
			//turn 90 degrees to the left
			new TurnLeft(-90,0.7);
			//drive foward 22ft
			new Drive(22.0,0.7,'f');
			//turn 90 degrees to the left
			new TurnLeft(-90,0.7);
			//raise lifter 5.5 ft high
			new Lift(5.5,0.7);
			//drive foward 1ft
			new Drive(1.0,0.7,'f');
			//drop cube
			new DropCube();
			;
			break;
		case "TwoRightScaleWaitScore":
			//wait 2.5 seconds
			Timer.delay(5);
			//drive 5ft foward
			new Drive(5.0,0.7,'f');
			//turn 90 degrees to the right
			new TurnRight(90,0.7);
			//drive 3ft foward
			new Drive(3.0,0.7,'f');
			//turn 90 degrees to the left
			new TurnLeft(-90,0.7);
			//drive foward 22ft
			new Drive(22.0,0.7,'f');
			//turn 90 degrees to the left
			new TurnLeft(-90,0.7);
			//raise lifter 5.5 ft high
			new Lift(5.5,0.7);
			//drive foward 1ft
			new Drive(1.0,0.7,'f');
			//drop cube
			new DropCube();
			;
			break;
		case "TwoRightScaleDefend":
			//wait 5 seconds
			//drive 5ft foward
			 new Drive(5.0,0.7,'f');
			//turn 90 degrees to the right
			 new TurnRight(-90,0.7);
			//drive 3ft foward
			 new Drive(3.0,0.7,'f');
			//turn 90 degrees to the Left
			 new TurnLeft(90,0.7);
			 //drive 18 feet forward
			;
			break;
		case "ThreeRightSwitchScore":
			//drive 14 feet forward
			//turn 90 degrees left
			//raise the lifter 3 feet
			//drive 2 feet forward
			//drop cube
			;
			break;
		case "ThreeRightSwitchWaitScore":
			//wait 5 seconds
			//drive 14 feet forward
			//turn 90 degrees left
			//raise the lifter 3 feet
			//drive 2 feet forward
			//drop cube
			;
			break;
		case "ThreeLeftSwitchDefend":
			//drive 27 feet forwards
			new Drive(27.0 ,0.7,'f');
			;
			break;
		case "ThreeRightScaleScore":
			//drive foward 27ft
			new Drive(27.0,0.7,'f');
			//raise the lifter 5.5 high
			new Lift(5.5,0.7);
			//turn 90 degrees to the left
			new TurnLeft(-90,0.7);
			//drive foward 1ft
			new Drive(1.0,0.7,'f');
			//drop the cube
			new DropCube();
			;
			break;
		case "ThreeRightScaleWaitScore":
			Timer.delay(5);
			//drive foward 27ft
			new Drive(27.0,0.7,'f');
			//raise the lifter 5.5 high
			new Lift(5.5,0.7);
			//turn 90 degrees to the left
			new TurnLeft(-90,0.7);
			//drive foward 1ft
			new Drive(1.0,0.7,'f');
			//drop the cube
			new DropCube();
			;
			break;
		case "ThreeLeftScaleDefend":
			//drive 27 feet forwards
			new Drive(27.0 ,0.7,'f');
			;
			break;
		}
	}
}
