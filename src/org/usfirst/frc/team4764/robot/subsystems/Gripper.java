package org.usfirst.frc.team4764.robot.subsystems;

import org.usfirst.frc.team4764.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Gripper extends Subsystem {
	Spark gripperMotor = new Spark(RobotMap.gripperMotor);
	DigitalOutput gripperLimitSwitchOpen = new DigitalOutput(RobotMap.gripperLimitSwitchOpen);
	DigitalOutput gripperLimitSwitchClose = new DigitalOutput(RobotMap.gripperLimitSwitchClose);

	public Gripper() {

	}

	// Drives the robot using s inputs for the left and right side motors.
	// Inputs are percentages of maxeperateimum motor output.
	public void openGripper() {
	}

	// Controls speed and direction of the robot.
	// -1 = full reverse; 1 = full forward
	public void closeGripper() {

	}

	public void reset() {

	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}

}
