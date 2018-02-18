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
	public static final int driveTrainMotorRight = 1;
	public static final int LiftMotor = 2;
	public static final int gripperMotor=1;


	// limit switches
	public static final int liftLimitSwitch = 1;
	public static final int gripperLimitSwitchClose=1;
	public static final int gripperLimitSwitchOpen=1;

	// encoders
	public static final int leftEncoderChannel1 = 0;
	public static final int leftEncoderChannel2 = 1;
	public static final int rightEncoderChannel1 = 3;
	public static final int rightEncoderChannel2 = 2;

	public static final int liftEncoderChannel1 = 4;
	public static final int liftEncoderChannel2 = 5;



}