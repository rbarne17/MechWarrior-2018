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
	 * possible paths: OneLeftSwitchScore OneLeftSwitchWaitScore
	 * OneRightSwitchDefense OneLeftScaleScore OneLeftScaleWaitScore
	 * OneRightScaleDefense TwoLeftSwitchScore TwoLeftSwitchWaitScore
	 * TwoLeftSwitchDefense TwoRightSwitchScore TwoRightSwitchWaitScore
	 * TwoRightSwitchDefense TwoLeftScaleScore TwoLeftScaleWaitScore
	 * TwoLeftScaleDefense TwoRightScaleScore TwoRightScaleWaitScore
	 * TwoRightScaleDefense ThreeRightSwitchScore ThreeRightSwitchWaitScore
	 * ThreeLeftSwitchDefense ThreeRightScaleScore ThreeRightScaleWaitScore
	 * ThreeLeftScaleDefense
	 */

	public AutonomousCommand(String autonomousCommandName) {
		switch (autonomousCommandName) {
		case "OneLeftSwitchScore":
			addSequential(new FlipityFlopLevel());
			// drive 14 feet forward
			addSequential(new Drive(8.0));
			addSequential(new Drive(6.0));
			// turn 90 degrees right
			addSequential(new TurnRight(90, 0.7));
			// raise the lifter 2 feet
			addSequential(new Lift(3.0, 0.7));
			// drive 2 feet forward
			addSequential(new Drive(4.0));
			// drop cube
			addSequential(new DropCube());
			addSequential(new DoNothing());
			;
			break;
		case "OneLeftSwitchWaitScore":
			addSequential(new FlipityFlopLevel());
			// wait 5 seconds
			addSequential(new TimerRegular());
			// drive 14 feet forward
			addSequential(new Drive(8.0));
			addSequential(new Drive(6.0));
			// turn 90 degrees right
			addSequential(new TurnRight(90, 0.7));
			// raise the lifter 2 feet
			addSequential(new Lift(3.0, 0.7));
			// drive 2 feet forward
			addSequential(new Drive(4.0));
			// drop cube
			addSequential(new DropCube());
			addSequential(new DoNothing());
			;
			break;
		case "OneRightSwitchDefend":
			addSequential(new FlipityFlopLevel());
			// drive 27 feet forwards
			addSequential(new Drive(8.0));
			addSequential(new Drive(6.0));
			addSequential(new DoNothing());
			;
			break;
		case "OneLeftScaleScore":
			addSequential(new FlipityFlopLevel());
			// drive foward 275ft
			addSequential(new Drive(5.0));
			addSequential(new Drive(5.0));
			addSequential(new Drive(5.0));
			addSequential(new Drive(5.0));
			addSequential(new Drive(6.0));
			addSequential(new TurnRight(90, 0.7));
			// raise the lifter 5.5 high
			addSequential(new Lift(5.5, 0.7));
			// drive foward 1ft
			addSequential(new Drive(3.0));
			// drop the cube
			addSequential(new DropCube());
			addSequential(new DoNothing());
			;

			break;
		case "OneLeftScaleWaitScore":
			// wait 2.5 seconds
			addSequential(new TimerRegular());
			addSequential(new FlipityFlopLevel());
			// drive foward 275ft
			addSequential(new Drive(5.0));
			addSequential(new Drive(5.0));
			addSequential(new Drive(5.0));
			addSequential(new Drive(5.0));
			addSequential(new Drive(6.0));
			addSequential(new TurnRight(90, 0.7));
			addSequential(new Lift(5.5, 0.7));
			addSequential(new Drive(3.0));
			// drop the cube
			addSequential(new DropCube());
			addSequential(new DoNothing());
			;
			break;
		case "OneRightScaleDefend":
			addSequential(new FlipityFlopLevel());
			// drive 27 feet forwards
			addSequential(new Drive(5.0));
			addSequential(new Drive(5.0));
			addSequential(new Drive(5.0));
			addSequential(new Drive(5.0));
			addSequential(new Drive(6.0));
			addSequential(new DoNothing());
		case "OneLeftSwitchDefend":
			addSequential(new FlipityFlopLevel());
			// drive 27 feet forwards
			addSequential(new Drive(8.0));
			addSequential(new Drive(6.0));
			addSequential(new DoNothing());
		case "OneLeftScaleDefend":
			addSequential(new FlipityFlopLevel());
			// drive 27 feet forwards
			addSequential(new Drive(5.0));
			addSequential(new Drive(5.0));
			addSequential(new Drive(5.0));
			addSequential(new Drive(5.0));
			addSequential(new Drive(6.0));
			addSequential(new DoNothing());
			break;
		case "TwoLeftSwitchScore":
			addSequential(new FlipityFlopLevel());
			// drive 5ft foward
			addSequential(new Drive(6.0));
			// turn 90 degrees to the left
			addSequential(new TurnLeft(90, 0.7));
			// drive 3ft foward
			addSequential(new Drive(5.0));
			// turn 90 degrees to the right
			addSequential(new TurnRight(90, 0.7));
			addSequential(new Lift(3.0, 0.7));
			addSequential(new Drive(6.0));
			// drop cube
			addSequential(new DropCube());
			addSequential(new DoNothing());
			break;
		case "TwoLeftSwitchWaitScore":
			addSequential(new FlipityFlopLevel());
			// drive 5ft foward
			addSequential(new TimerRegular());
			addSequential(new Drive(6.0));
			// turn 90 degrees to the left
			addSequential(new TurnLeft(90, 0.7));
			// drive 3ft foward
			addSequential(new Drive(5.0));
			// turn 90 degrees to the right
			addSequential(new TurnRight(90, 0.7));
			addSequential(new Lift(3.0, 0.7));
			// drive forward 1 foot
			addSequential(new Drive(6.0));
			// drop cube
			addSequential(new DropCube());
			addSequential(new DoNothing());
			break;
		case "TwoLeftSwitchDefend":
			addSequential(new FlipityFlopLevel());
			// drive 5ft foward
			addSequential(new TimerRegular());
			addSequential(new Drive(6.0));
			// turn 90 degrees to the left
			addSequential(new TurnLeft(90, 0.7));
			// drive 3ft foward
			addSequential(new Drive(5.0));
			// turn 90 degrees to the right
			addSequential(new TurnRight(90, 0.7));
			// drive forward 1 foot
			addSequential(new Drive(4.0));
			addSequential(new DoNothing());
			addSequential(new DoNothing());
			;
			break;
		case "TwoRightSwitchScore":
			addSequential(new FlipityFlopLevel());
			// drive 5ft foward
			addSequential(new Drive(6.0));
			// turn 90 degrees to the left
			addSequential(new TurnRight(90, 0.7));
			// drive 3ft foward
			addSequential(new Drive(5.0));
			// turn 90 degrees to the right
			addSequential(new TurnLeft(90, 0.7));
			addSequential(new Lift(3.0, 0.7));
			addSequential(new Drive(6.0));
			// drop cube
			addSequential(new DropCube());
			addSequential(new DoNothing());
			;
			break;
		case "TwoRightSwitchWaitScore":
			addSequential(new FlipityFlopLevel());
			// drive 5ft foward
			addSequential(new TimerRegular());
			addSequential(new Drive(6.0));
			// turn 90 degrees to the left
			addSequential(new TurnLeft(90, 0.7));
			// drive 3ft foward
			addSequential(new Drive(5.0));
			// turn 90 degrees to the right
			addSequential(new TurnRight(90, 0.7));
			addSequential(new Lift(3.0, 0.7));
			// drive forward 1 foot
			addSequential(new Drive(6.0));
			// drop cube
			addSequential(new DropCube());
			addSequential(new DoNothing());
			;
			break;
		case "TwoRightSwitchDefend":
			addSequential(new FlipityFlopLevel());
			// drive 5ft foward
			addSequential(new TimerRegular());
			addSequential(new Drive(6.0));
			// turn 90 degrees to the left
			addSequential(new TurnRight(90, 0.7));
			// drive 3ft foward
			addSequential(new Drive(5.0));
			// turn 90 degrees to the right
			addSequential(new TurnLeft(90, 0.7));
			// drive forward 1 foot
			addSequential(new Drive(4.0));
			addSequential(new DoNothing());
	
			;
			break;
		case "TwoLeftScaleScore":
	
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
		case "ThreeRightSwitchScore":
			addSequential(new FlipityFlopLevel());
			// drive 14 feet forward
			addSequential(new Drive(8.0));
			addSequential(new Drive(6.0));
			// turn 90 degrees right
			addSequential(new TurnLeft(90, 0.7));
			// raise the lifter 2 feet
			addSequential(new Lift(3.0, 0.7));
			// drive 2 feet forward
			addSequential(new Drive(4.0));
			// drop cube
			addSequential(new DropCube());
			addSequential(new DoNothing());
			
			;
			break;
		case "ThreeRightSwitchWaitScore":
			addSequential(new FlipityFlopLevel());
			// wait 5 seconds
			addSequential(new TimerRegular());
			// drive 14 feet forward
			addSequential(new Drive(8.0));
			addSequential(new Drive(6.0));
			// turn 90 degrees right
			addSequential(new TurnLeft(90, 0.7));
			// raise the lifter 2 feet
			addSequential(new Lift(3.0, 0.7));
			// drive 2 feet forward
			addSequential(new Drive(4.0));
			// drop cube
			addSequential(new DropCube());
			addSequential(new DoNothing());
			
			;
			break;
		case "ThreeLeftSwitchDefend":
			addSequential(new FlipityFlopLevel());
			// drive 27 feet forwards
			addSequential(new Drive(8.0));
			addSequential(new Drive(6.0));
		case "ThreeRightSwitchDefend":
			addSequential(new FlipityFlopLevel());
			// drive 27 feet forwards
			addSequential(new Drive(8.0));
			addSequential(new Drive(6.0));
			addSequential(new DoNothing());
			;
		case "ThreeRightScaleDefend":
			addSequential(new FlipityFlopLevel());
			// drive 27 feet forwards
			addSequential(new Drive(5.0));
			addSequential(new Drive(5.0));
			addSequential(new Drive(5.0));
			addSequential(new Drive(5.0));
			addSequential(new Drive(6.0));
			addSequential(new DoNothing());
			;
			break;
		case "ThreeRightScaleScore":
			addSequential(new FlipityFlopLevel());
			// drive foward 275ft
			addSequential(new Drive(5.0));
			addSequential(new Drive(5.0));
			addSequential(new Drive(5.0));
			addSequential(new Drive(5.0));
			addSequential(new Drive(6.0));
			addSequential(new TurnLeft(90, 0.7));
			// raise the lifter 5.5 high
			addSequential(new Lift(5.5, 0.7));
			// drive foward 1ft
			addSequential(new Drive(3.0));
			// drop the cube
			addSequential(new DropCube());
			addSequential(new DoNothing());
			;
			break;
		case "ThreeRightScaleWaitScore":
			addSequential(new FlipityFlopLevel());
			addSequential(new TimerRegular());
			addSequential(new Drive(5.0));
			addSequential(new Drive(5.0));
			addSequential(new Drive(5.0));
			addSequential(new Drive(5.0));
			addSequential(new Drive(6.0));
			addSequential(new TurnLeft(90, 0.7));
			// raise the lifter 5.5 high
			addSequential(new Lift(5.5, 0.7));
			// drive foward 1ft
			addSequential(new Drive(3.0));
			// drop the cube
			addSequential(new DropCube());
			addSequential(new DoNothing());
			;
			break;
		case "ThreeLeftScaleDefend":
			addSequential(new FlipityFlopLevel());
			// drive 27 feet forwards
			addSequential(new Drive(5.0));
			addSequential(new Drive(5.0));
			addSequential(new Drive(5.0));
			addSequential(new Drive(5.0));
			addSequential(new Drive(6.0));
			addSequential(new DoNothing());
			;
			break;
		}
	}
}
