package org.usfirst.frc.team4764.robot.subsystems;

import org.usfirst.frc.team4764.robot.commands.DriveWithJoy;
import org.usfirst.frc.team4764.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Drive extends Subsystem {
	Spark m_Left = new Spark(RobotMap.DriveTrainLeftTalon1);
	Spark m_Right = new Spark(RobotMap.DriveTrainRightTalon1);
	Encoder LeftEncoder= (RobotMap.driveTrainLeftEncoder);
	Encoder RightEncoder= (RobotMap.driveTrainRightEncoder);

	public Drive() {
		
		m_Left.set( 0.0);
		
		m_Right.set(0.0);
		

	}
	public int getEncoderLeft()
	{
		// Return Encoder Values Need to be fixed
		
		return LeftEncoder.get();
	}

	public int getEncoderRight()
	{
//		Value reversed for clarity
		// Return Encoder Values Need to be fixed
		
		return RightEncoder.get();
	}

	

	public void initDefaultCommand() {
		
		setDefaultCommand(new DriveWithJoy());
	}

	//Drives the robot using s inputs for the left and right side motors.
	//Inputs are percentages of maxeperateimum motor output.
	public void driveByTank (double leftSpeed, double rightSpeed)	
	{
		m_Left.set(leftSpeed);
		
		m_Right.set(rightSpeed);
		
	}    

	//Controls speed and direction of the robot.
	// -1 = full reverse; 1 = full forward
	public void driveByArcade (double percentThrottle, double percentRotationOutput)
	{
		
		percentThrottle = valueAfterDeadzoned(percentThrottle);
		percentRotationOutput = valueAfterDeadzoned(percentRotationOutput);
	
		percentThrottle = scalingSpeed(percentThrottle);
		percentRotationOutput = scalingSpeed(percentRotationOutput);
		
		SmartDashboard.putNumber("ACTUAL Percent Throttle", percentThrottle);
		SmartDashboard.putNumber("ACTUAL Percent Rotation", percentRotationOutput);
		
		m_Left.set(-percentThrottle - percentRotationOutput);
		

		m_Right.set(percentThrottle - percentRotationOutput);
		
	}
	public double scalingSpeed (double joystickValue) {
//		TODO: Find better scaling system
//		Here's a simple algorithm to add sensitivity adjustment to the joystick:
//
//		x' = a * x^3 + (1-a) * x
//
//		x is a joystick output ranging from -1 to +1
//
//		x' is the sensitivity-adjusted output (also will be -1 to +1)
//
//		"a" is a variable ranging from 0 to +1
//
//		When a=0, you get x' = x
//
//		When a=1, you get x' = x^3 which gives very fine control of small outputs
//
//		When a is between 0 and 1, you get something in between.
		
//		joystickValue is "x"
		
//		below is "a"
		double scalingCutoff =0;
		
//		below is "x^3"
		double joystickValueToTheThird = Math.pow(joystickValue, 3);
		
//		x'   = a               x^3                     +  (1-a)               x
		return scalingCutoff * joystickValueToTheThird + ((1-scalingCutoff) * joystickValue);
	}

	public void doNothing () 
	{
		driveByTank(0.0, 0.0);

	}
	
	private double valueAfterDeadzoned (double currentValue) {
//		This is the deadzone. Change to change how sensitive the robot is.
		double deadzone = 0.2;
		if (Math.abs(currentValue) < deadzone)
		{
			return 0;
		}
		else
		{
			return currentValue;
		}
	}
}