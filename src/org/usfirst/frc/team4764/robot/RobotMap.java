/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4764.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public final class RobotMap {

	// speed controllers
	public static final int driveTrainMotorLeft = 0;
	public static final int driveTrainMotorRight = 1; //pin might be fried
	public static final int liftMotor = 2;
	public static final int flipityFlopMotor = 3; 
	public static final int gripperMotor=4;
	public static final int flyWheelMotor=5; //not currently used


	// limit switches
	public static final int liftLimitSwitchHome = 8;
	public static final int gripperLimitSwitchClose=9;
	public static final int gripperLimitSwitchOpen=10;
	public static final int flipityFlopLimitSwitchUp=7;
	public static final int flipityFlopLimitSwitchLevel=6;
	

	// encoders                                      //sig   power/ground 
	public static final int leftEncoderChannel1 = 0; //blue, orange
	public static final int leftEncoderChannel2 = 1; //yellow, black
	public static final int rightEncoderChannel1 = 2; //blue orange
	public static final int rightEncoderChannel2 = 3; //yellow, black

	public static final int liftEncoderChannel1 = 4; //??
	public static final int liftEncoderChannel2 = 5; //??
	



}