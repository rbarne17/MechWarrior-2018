/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4764.robot;

import org.usfirst.frc.team4764.robot.commands.DriveByInches;
import org.usfirst.frc.team4764.robot.commands.TurnWithGyro;
import org.usfirst.frc.team4764.robot.commands.Lift;
import org.usfirst.frc.team4764.robot.commands.LiftHome;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	XboxController xbox = new XboxController(2);
	XboxController xbox2= new XboxController(1);
	Joystick stick1 = new Joystick(0);
	
	
	Button xButton = new JoystickButton(xbox2, 1);
	Button yButton = new JoystickButton(xbox2, 4);
	Button bButton = new JoystickButton(xbox2, 3);
	Button aButton = new JoystickButton(xbox2, 2);

	public OI() {
		xButton.whenPressed(new DriveByInches(20, 0.5));
		yButton.whenPressed(new Lift(10,0.5));
		bButton.whenPressed(new Lift(5,0.5));
		aButton.whenPressed(new LiftHome(0.5));
		
	}
	
	
	public double JoystickY()
	{
		return stick1.getY(Hand.kLeft);
	}
	public double JoystickX()
	{
		return stick1.getX(Hand.kLeft);
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
	public double getRightStickX2(){
		return xbox2.getX(Hand.kRight);
	}
	public double getLeftStickY2()
	{
		return xbox2.getY(Hand.kLeft);
	}
	public double getRightStickY2()
	{
		return xbox2.getY(Hand.kRight);
	}

	public double getLeftStickX2()
	{
		return xbox2.getX(Hand.kLeft);
	}
}