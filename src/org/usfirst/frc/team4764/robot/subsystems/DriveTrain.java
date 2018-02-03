package org.usfirst.frc.team4764.robot.subsystems;

import org.usfirst.frc.team4764.robot.RobotMap;
import org.usfirst.frc.team4764.robot.commands.DriveWithJoy;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveTrain extends Subsystem {
	private Spark leftMotor = new Spark(RobotMap.DriveTrainLeftTalon1);
	private Spark rightMotor = new Spark(RobotMap.DriveTrainRightTalon1);
	private Gyro gyro;
	private Encoder leftEncoder = new Encoder(RobotMap.leftEncoderChannel1, RobotMap.leftEncoderChannel2, true,
			EncodingType.k4X);
	private Encoder rightEncoder = new Encoder(RobotMap.rightEncoderChannel1, RobotMap.rightEncoderChannel2, true,
			EncodingType.k4X);
	private AnalogInput rangefinder = new AnalogInput(RobotMap.rangefinder);


	public DriveTrain() {
		
		leftMotor.set( 0.0);
		
		rightMotor.set(0.0);
		

	}
	public int getEncoderLeft()
	{
		// Return Encoder Values Need to be fixed
		
		return leftEncoder.get();
	}

	public int getEncoderRight()
	{
//		Value reversed for clarity
		// Return Encoder Values Need to be fixed
		
		return rightEncoder.get();

	}

	

	public void initDefaultCommand() {
		
		setDefaultCommand(new DriveWithJoy());
	}

	//Drives the robot using s inputs for the left and right side motors.
	//Inputs are percentages of maxeperateimum motor output.
	public void driveByTank (double leftSpeed, double rightSpeed)	
	{
		leftMotor.set(leftSpeed);
		
		rightMotor.set(rightSpeed);
		
	}    

	//Controls speed and direction of the robot.
	// -1 = full reverse; 1 = full forward
	public void driveByArcade (double percentThrottle, double percentRotationOutput)
	{
		
		percentThrottle = valueAfterDeadzone(percentThrottle);
		percentRotationOutput = valueAfterDeadzone(percentRotationOutput);
	
		percentThrottle = scalingSpeed(percentThrottle);
		percentRotationOutput = scalingSpeed(percentRotationOutput);
		
		SmartDashboard.putNumber("ACTUAL Percent Throttle", percentThrottle);
		SmartDashboard.putNumber("ACTUAL Percent Rotation", percentRotationOutput);
		
		leftMotor.set(-percentThrottle - percentRotationOutput);
		

		rightMotor.set(percentThrottle - percentRotationOutput);
		
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
	
	private double valueAfterDeadzone (double currentValue) {
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
