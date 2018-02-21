/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4764.robot;

import org.usfirst.frc.team4764.robot.commands.AutonomousCommand;
import org.usfirst.frc.team4764.robot.commands.Drive;
import org.usfirst.frc.team4764.robot.commands.DriveByInches;
import org.usfirst.frc.team4764.robot.commands.DriveWithJoy;

import org.usfirst.frc.team4764.robot.subsystems.DriveTrain;
import org.usfirst.frc.team4764.robot.subsystems.Gripper;
import org.usfirst.frc.team4764.robot.subsystems.Lift;
import org.usfirst.frc.team4764.robot.subsystems.FlipityFlop;
import org.usfirst.frc.team4764.robot.OI;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	public static OI oi;

	public static final DriveTrain driveTrain = new DriveTrain();
	public static final Lift lift = new Lift();

	public static final FlipityFlop pinrelease = new FlipityFlop();
	Command m_autonomousCommand;
	SendableChooser<Command> m_chooser = new SendableChooser<>();

	public static final Gripper gripper = new Gripper();
	public static final FlipityFlop flipityFlop = new FlipityFlop();
	public static OI operatorInput;
	public static CommandGroup autonomousCommand;
	SendableChooser<Command> m_commandChooser = new SendableChooser<>();
	SendableChooser<String> m_ScoringMechanismChooser = new SendableChooser<>();
	SendableChooser<String> m_allianceModeChooser = new SendableChooser<>();
	public static String autonomousAllianceMode;
	public static String autonomousScoringMechanism;
	public static String autonomousCommandName;


	/**
	 * This function is run when the robot is first started up and should be used
	 * for any initialization code.
	 */
	@Override
	public void robotInit() {
		operatorInput = new OI();
		m_commandChooser.addDefault("Default Auto", new DriveWithJoy());
		SmartDashboard.putData("Auto mode", m_commandChooser);

		m_ScoringMechanismChooser.addObject("Switch", new String());
		m_ScoringMechanismChooser.addObject("Switch", new String());
		SmartDashboard.putData("Switch or Scale", m_ScoringMechanismChooser);

		m_allianceModeChooser.addDefault("Score", new String());
		m_allianceModeChooser.addObject("WaitScore", new String());
		m_allianceModeChooser.addObject("Defend", new String());
		SmartDashboard.putData("Alliance Mode", m_allianceModeChooser);

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

		autonomousScoringMechanism = m_ScoringMechanismChooser.getSelected();
		autonomousAllianceMode = m_allianceModeChooser.getSelected();

		if ((FieldData.location == 1 && (FieldData.scaleSide == 'R' || FieldData.switchSide == 'R'))
				|| (FieldData.location == 3 && (FieldData.scaleSide == 'L' || FieldData.switchSide == 'L'))) {
			autonomousAllianceMode = "Defend";
		}

		autonomousCommandName = FieldData.locationString + autonomousScoringMechanism + autonomousAllianceMode;

		oi.autonomousCommand = (Command) oi.autoPathChooser.getSelected();
		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
		 * switch(autoSelected) { case "My Auto": autonomousCommand = new
		 * MyAutoCommand(); break; case "Default Auto": default: autonomousCommand = new
		 * ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (oi.autonomousCommand != null) {
			oi.autonomousCommand.start();
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
		if (autonomousCommand != null) {
			autonomousCommand.cancel();
		}
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {

		SmartDashboard.putNumber("Encoder Right", driveTrain.getEncoderRight());
		SmartDashboard.putNumber("Encoder Left", driveTrain.getEncoderLeft());

		SmartDashboard.putNumber("Percent Throttle", operatorInput.JoystickY());
		SmartDashboard.putNumber("Percent Rotation", operatorInput.JoystickX());

		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}