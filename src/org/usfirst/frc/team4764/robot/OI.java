/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4764.robot;

import edu.wpi.first.wpilibj.GenericHID.Hand;

import org.usfirst.frc.team4764.robot.commands.DropCube;
import org.usfirst.frc.team4764.robot.commands.FlipityFlopLevel;
import org.usfirst.frc.team4764.robot.commands.FlipityFlopUp;
import org.usfirst.frc.team4764.robot.commands.PickUpCube;

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
	Joystick joystick = new Joystick(0);

	Button xboxXButton = new JoystickButton(xbox, 1);
	Button xboxYButton = new JoystickButton(xbox, 4);
	Button xboxBButton = new JoystickButton(xbox, 3);
	Button xboxAButton = new JoystickButton(xbox, 2);
	Button xboxRBumper = new JoystickButton(xbox, 6);
	Button xboxLBumper = new JoystickButton(xbox, 5);

	public OI() {
		if (Robot.controllerMode == "SingleController") {

		} else {

			xboxXButton.whenPressed(new PickUpCube());
			xboxYButton.whenPressed(new DropCube());
			xboxBButton.whenPressed(new FlipityFlopUp());
			xboxAButton.whenPressed(new FlipityFlopLevel());
		}

	}

	public double getJoystickY() {
		return -joystick.getY();
	}

	public double getJoystickX() {
		return joystick.getX();
	}

	public double getXboxLeftStickX() {
		return xbox.getX(Hand.kLeft);
	}

	public double getXboxRightStickX() {
		return xbox.getX(Hand.kRight);
	}

	public double getXboxLeftStickY() {
		return xbox.getY(Hand.kLeft);
	}

	public double getXboxRightStickY() {
		return xbox.getY(Hand.kRight);
	}

	public double getXboxLeftTrigger() {
		return xbox.getTriggerAxis(Hand.kLeft);
	}

	public double getXboxRightTrigger() {
		return xbox.getTriggerAxis(Hand.kRight);
	}

	public double getXboxTrigger() {
		return getXboxLeftTrigger() - getXboxRightTrigger();
	}

	public double getControllerDriveTrainThrottleValue() {
		return getJoystickY();
	}

	public double getControllerDriveTrainRotationValue() {
		return getJoystickX();
	}

	public double getControllerGripperValue() {
		if (Robot.controllerMode == "SingleController") {
			return 0.0;

		} else {
			return Robot.operatorInput.getXboxTrigger();
		}
	}

	public double getControllerLiftValue() {
		if (Robot.controllerMode == "SingleController") {
			return 0.0;

		} else {
			return Robot.operatorInput.getXboxLeftStickY();
		}

	}

	public double getControllerFlipityFlopValue() {
		if (Robot.controllerMode == "SingleController") {
			return 0.0;

		} else {
			return Robot.operatorInput.getXboxRightStickY();
		}

	}

}
