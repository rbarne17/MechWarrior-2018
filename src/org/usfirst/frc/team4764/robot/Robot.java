/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4764.robot;

import org.usfirst.frc.team4764.robot.commands.Drive;
import org.usfirst.frc.team4764.robot.commands.DriveByInches;
import org.usfirst.frc.team4764.robot.commands.DriveWithJoy;

import org.usfirst.frc.team4764.robot.subsystems.DriveTrain;
import org.usfirst.frc.team4764.robot.subsystems.Gripper;
import org.usfirst.frc.team4764.robot.subsystems.Lift;
import org.usfirst.frc.team4764.robot.subsystems.FlipityFlop;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {

	public static final DriveTrain DriveTrain = new DriveTrain();
	public static final Lift Lift = new Lift();
	public static final Gripper Gripper = new Gripper();
	public static final FlipityFlop FlipityFlop = new FlipityFlop();
	public static OI OperatorInput;
	public static Command AutonomousCommand;
	SendableChooser<Command> m_commandChooser = new SendableChooser<>();
	public static String AutonomousPathName;

	/**
	 * This function is run when the robot is first started up and should be used
	 * for any initialization code.
	 */
	@Override
	public void robotInit() {
		OperatorInput = new OI();
		m_commandChooser.addDefault("Default Auto", new DriveWithJoy());
		SmartDashboard.putData("Auto mode", m_commandChooser);
	}

	/**
	 * This function is called once each time the robot enters Disabled mode. You
	 * can use it to reset any subsystem information you want to clear when the
	 * robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable chooser
	 * code works with the Java SmartDashboard. If you prefer the LabVIEW Dashboard,
	 * remove all of the chooser code and uncomment the getString code to get the
	 * auto name from the text box below the Gyro
	 *
	 * <p>
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons to
	 * the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		switch (Integer.toString(FieldData.Location) + FieldData.AllianceOrder) {
		case "1LLL":
			AutonomousPathName = "1LLL";
			break;
		default:
			AutonomousPathName = "";
			break;

		}

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
		 * switch(autoSelected) { case "My Auto": autonomousCommand = new
		 * MyAutoCommand(); break; case "Default Auto": default: autonomousCommand = new
		 * ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (AutonomousCommand != null) {
			AutonomousCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (AutonomousCommand != null) {
			AutonomousCommand.cancel();
		}
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {

		SmartDashboard.putNumber("Encoder Right", DriveTrain.getEncoderRight());
		SmartDashboard.putNumber("Encoder Left", DriveTrain.getEncoderLeft());

		SmartDashboard.putNumber("Percent Throttle", OperatorInput.getRightStickY());
		SmartDashboard.putNumber("Percent Rotation", OperatorInput.getLeftStickX());

		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}