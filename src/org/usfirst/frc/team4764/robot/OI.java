/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4764.robot;

import edu.wpi.first.wpilibj.GenericHID.Hand;

import org.usfirst.frc.team4764.robot.commands.DriveByInches;
import org.usfirst.frc.team4764.robot.commands.DropCube;
import org.usfirst.frc.team4764.robot.commands.TurnWithGyro;
import org.usfirst.frc.team4764.robot.commands.Lift;
import org.usfirst.frc.team4764.robot.commands.LiftHome;
import org.usfirst.frc.team4764.robot.commands.PickUpCube;

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
	
	
	Button xButton2 = new JoystickButton(xbox2, 1);
	Button yButton2 = new JoystickButton(xbox2, 4);
	Button bButton2 = new JoystickButton(xbox2, 3);
	Button aButton2 = new JoystickButton(xbox2, 2);
	Button rbumper2= new JoystickButton(xbox2,6);
	Button lbumper2= new JoystickButton(xbox2, 5);

	public OI() {
		xButton2.whenPressed(new DriveByInches(20, 0.5));
		yButton2.whenPressed(new Lift(10,0.5));
		bButton2.whenPressed(new Lift(5,0.5));
		aButton2.whenPressed(new LiftHome(0.5));
		rbumper2.whenPressed(new DropCube());
		lbumper2.whenPressed(new PickUpCube());
		
		
		
	}
	
	
	public double JoystickY()
	{
		return stick1.getY();
	}
	public double JoystickX()
	{
		return stick1.getX();
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