/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4764.robot;

import org.usfirst.frc.team4764.robot.commands.DriveByInches;
import org.usfirst.frc.team4764.robot.commands.GYROTURN;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	XboxController xbox = new XboxController(0);
	
	Button xButton = new JoystickButton(xbox, 1);
	Button yButton = new JoystickButton(xbox, 4);

	public OI() {
		xButton.whenPressed(new DriveByInches(20, 0.5));
		yButton.whenPressed(new GYROTURN(.5, 90));
	}
	
	
	
	public double getLeftStickY ()
	{
		return xbox.getY(Hand.kLeft);
	}
	public double getRightStickY()
	{
		return xbox.getY(Hand.kRight);
	}

	public double getLeftStickX()
	{
		return xbox.getX(Hand.kLeft);
	}
	public double getRightStickX()
	{
		return xbox.getX(Hand.kRight);
	}
}