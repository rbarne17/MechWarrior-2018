/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4764.robot;

import edu.wpi.first.wpilibj.GenericHID.Hand;

import org.usfirst.frc.team4764.robot.commands.Drive;
import org.usfirst.frc.team4764.robot.commands.DropCube;
import org.usfirst.frc.team4764.robot.commands.Lift;
import org.usfirst.frc.team4764.robot.commands.LiftHome;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	XboxController xbox = new XboxController(1);
	Joystick stick1 = new Joystick(0);

	Button xboxXButton = new JoystickButton(xbox, 1);
	Button xboxYButton = new JoystickButton(xbox, 4);
	Button xboxBButton = new JoystickButton(xbox, 3);
	Button xboxAButton = new JoystickButton(xbox, 2);
	Button xboxRBumper = new JoystickButton(xbox, 6);
	Button xboxLBumper = new JoystickButton(xbox, 5);

	public OI() {
		xboxXButton.whenPressed(new Drive(5, 0.5));
		xboxYButton.whenPressed(new Lift(10, 0.5));
		xboxBButton.whenPressed(new Lift(5, 0.5));
		xboxAButton.whenPressed(new LiftHome(0.5));
		xboxRBumper.whenPressed(new DropCube());

	}

	public double JoystickY() {
		return -stick1.getY();
	}

	public double JoystickX() {
		return stick1.getX();
	}

	public double getRightStickX2() {
		return xbox.getX(Hand.kRight);
	}

	public double getLeftStickY2() {
		return xbox.getY(Hand.kLeft);
	}

	public double getRightStickY2() {
		return xbox.getY(Hand.kRight);
	}

	public double getLeftStickX2() {
		return xbox.getX(Hand.kLeft);
	}
}