package org.usfirst.frc.team4764.robot.subsystems;

import org.usfirst.frc.team4764.robot.RobotMap;
import org.usfirst.frc.team4764.robot.commands.DriveWithController;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveTrain extends Subsystem {

	// competition robot: ticksPerFoot = 166
	// test robot: ticksPerFoot=135
	public final int ticksPerFoot = 166;

	public Spark leftMotor = new Spark(RobotMap.driveTrainMotorLeft);
	public Spark rightMotor = new Spark(RobotMap.driveTrainMotorRight);
	public ADXRS450_Gyro gyro = new ADXRS450_Gyro();

	public Encoder leftEncoder = new Encoder(RobotMap.leftEncoderChannel1, RobotMap.leftEncoderChannel2, true,
			EncodingType.k4X);
	public Encoder rightEncoder = new Encoder(RobotMap.rightEncoderChannel1, RobotMap.rightEncoderChannel2, true,
			EncodingType.k4X);

	public DriveTrain() {

		if (gyro != null) {
			gyro.calibrate();
		}

		leftMotor.set(0.0);

		rightMotor.set(0.0);

	}

	public int getEncoderLeft() {
		return leftEncoder.get();
	}

	public int getEncoderRight() {
		return -rightEncoder.get();
	}

	public void initDefaultCommand() {

		setDefaultCommand(new DriveWithController());
	}

	// Drives the robot using s inputs for the left and right side motors.
	// Inputs are percentages of maxeperateimum motor output.
	public void driveByTank(double LeftpercentThrottle, double RightpercentThrottle) {
		leftMotor.set(LeftpercentThrottle);
		rightMotor.set(RightpercentThrottle);

	}

	// Controls speed and direction of the robot.
	// -1 = full reverse; 1 = full forward
	public void driveByArcade(double percentThrottle, double percentRotationOutput) {

		percentThrottle = valueAfterDeadzone(percentThrottle);
		percentRotationOutput = valueAfterDeadzone(percentRotationOutput);

		percentThrottle = scalingSpeed(percentThrottle);
		percentRotationOutput = scalingSpeed(percentRotationOutput);

		leftMotor.set(-percentThrottle - percentRotationOutput);

		rightMotor.set(percentThrottle - percentRotationOutput);

	}

	public double scalingSpeed(double joystickValue) {
		// TODO: Find better scaling system
		// Here's a simple algorithm to add sensitivity adjustment to the joystick:
		//
		// x' = a * x^3 + (1-a) * x
		//
		// x is a joystick output ranging from -1 to +1
		//
		// x' is the sensitivity-adjusted output (also will be -1 to +1)
		//
		// "a" is a variable ranging from 0 to +1
		//
		// When a=0, you get x' = x
		//
		// When a=1, you get x' = x^3 which gives very fine control of small outputs
		//
		// When a is between 0 and 1, you get something in between.

		// joystickValue is "x"

		// below is "a"
		double scalingCutoff = .8;

		// below is "x^3"

		double joystickValueToTheThird = Math.pow(joystickValue, 3);

		// x' = a x^3 + (1-a) x
		return scalingCutoff * joystickValueToTheThird + ((1 - scalingCutoff) * joystickValue);
	}

	public void reset() {
		driveByTank(0.0, 0.0);
		encoderReset();
		if (gyro != null) {
			gyro.reset();
		}
		else {
			System.out.println("WARNING: No gyro present.");
		}

	}

	public void encoderReset() {
		leftEncoder.reset();
		rightEncoder.reset();

	}

	public double getHeading() {
		if (gyro != null) {
			return gyro.getAngle();
		}		else {
			System.out.println("WARNING: No gyro present.");
			return 0.00;
		}

	}

	private double valueAfterDeadzone(double currentValue) {
		// This is the deadzone. Adjust to change how sensitive the robot is.
		double deadzone = 0.2;
		if (Math.abs(currentValue) < deadzone) {
			return 0;
		} else {
			return currentValue;
		}
	}

}
