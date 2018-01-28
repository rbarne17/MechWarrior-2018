package org.usfirst.frc.team4764.robot.subsystems;

import org.usfirst.frc.team4764.robot.commands.DriveWithJoy;
import org.usfirst.frc.team4764.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveTrain extends Subsystem {
	TalonSRX motorLeft1 = new TalonSRX(RobotMap.DriveTrainLeftTalon1);
	TalonSRX motorRight1 = new TalonSRX(RobotMap.DriveTrainRightTalon1);

	public DriveTrain() {
		
		motorLeft1.set(ControlMode.PercentOutput, 0.0);
		
		motorRight1.set(ControlMode.PercentOutput,  0.0);
		

	}
	public int getEncoderLeft()
	{
		return motorLeft1.getSensorCollection().getPulseWidthPosition();
	}

	public int getEncoderRight()
	{
//		Value reversed for clarity
		return -motorRight1.getSensorCollection().getPulseWidthPosition();
	}

	

	public void initDefaultCommand() {
		
		setDefaultCommand(new DriveWithJoy());
	}

	//Drives the robot using s inputs for the left and right side motors.
	//Inputs are percentages of maxeperateimum motor output.
	public void driveByTank (double leftSpeed, double rightSpeed)	
	{
		motorLeft1.set(ControlMode.PercentOutput, leftSpeed);
		
		motorRight1.set(ControlMode.PercentOutput, rightSpeed);
		
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
		
		motorLeft1.set(ControlMode.PercentOutput,-percentThrottle - percentRotationOutput);
		

		motorRight1.set(ControlMode.PercentOutput, percentThrottle - percentRotationOutput);
		
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
		double scalingCutoff = .75;
		
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