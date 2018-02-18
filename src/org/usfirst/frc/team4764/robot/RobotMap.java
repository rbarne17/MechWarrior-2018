/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4764.robot;

import edu.wpi.first.wpilibj.Encoder;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public final class RobotMap {
	
	public static final int DriveTrainLeftTalon1 = 0;
	public static final int DriveTrainRightTalon1 = 1;
	public static final int leftEncoderChannel1 = 0;
	public static final int leftEncoderChannel2 = 1;
	public static final int rightEncoderChannel1 = 2;
	public static final int rightEncoderChannel2 = 3;
	public static final int rangefinder = 6;
	public static final int LiftMotor = 2;
	public static final int liftEncoderChannel1 = 4;
	public static final int liftEncoderChannel2 = 5;
	public static final int limitswitch = 1;
	public static final int gripper=1;
	public static final int gripperclose=1;
	public static final int gripperopen=1;
//	public static final int solenoidlevel=6;
//	public static final int solenoiddown=7;


	
//	public static Encoder driveTrainLeftEncoder = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
//	public static Encoder driveTrainRightEncoder = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
	
	
}