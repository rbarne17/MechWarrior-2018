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

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
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

	public static final DriveTrain driveTrain = new DriveTrain();
	public static final Lift lift = new Lift();
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
		m_allianceModeChooser.addObject("Wait/Score", new String());
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

		switch (FieldData.Location) {
		case 1:
			if (FieldData.SwitchSide == 'L' && autonomousScoringMechanism == "Switch"
					&& autonomousAllianceMode == "Score") {
				autonomousCommandName = "OneLeftSwitch";
			}
			if (FieldData.SwitchSide == 'L' && autonomousScoringMechanism == "Switch"
					&& autonomousAllianceMode == "Wait/Score") {
				autonomousCommandName = "OneLeftSwitchWait";
			}
			if (FieldData.SwitchSide == 'L' && autonomousScoringMechanism == "Switch"
					&& autonomousAllianceMode == "Defend") {
				autonomousCommandName = "OneLeftSwitchDefend";
			}
			if (FieldData.SwitchSide == 'R' && autonomousScoringMechanism == "Switch") {
				autonomousCommandName = "OneRightSwitchDefend";
			}
			if (FieldData.SwitchSide == 'L' && autonomousScoringMechanism == "Scale"
					&& autonomousAllianceMode == "Score") {
				autonomousCommandName = "OneLeftScale";
			}
			if (FieldData.SwitchSide == 'L' && autonomousScoringMechanism == "Scale"
					&& autonomousAllianceMode == "Wait/Score") {
				autonomousCommandName = "OneLeftScaleWait";
			}
			if (FieldData.SwitchSide == 'L' && autonomousScoringMechanism == "Scale"
					&& autonomousAllianceMode == "Defend") {
				autonomousCommandName = "OneLeftScaleDefend";
			}
			if (FieldData.SwitchSide == 'R' && autonomousScoringMechanism == "Scale") {
				autonomousCommandName = "OneRightScaleDefend";
			}

			;
			break;
		case 2:
			if (FieldData.SwitchSide == 'L' && autonomousScoringMechanism == "Switch"
					&& autonomousAllianceMode == "Score") {
				autonomousCommandName = "TwoLeftSwitch";
			}
			if (FieldData.SwitchSide == 'L' && autonomousScoringMechanism == "Switch"
					&& autonomousAllianceMode == "Wait/Score") {
				autonomousCommandName = "TwoLeftSwitchWait";
			}
			if (FieldData.SwitchSide == 'L' && autonomousScoringMechanism == "Switch"
					&& autonomousAllianceMode == "Defend") {
				autonomousCommandName = "TwoLeftSwitchDefend";
			}
			if (FieldData.SwitchSide == 'R' && autonomousScoringMechanism == "Switch"
					&& autonomousAllianceMode == "Score") {
				autonomousCommandName = "TwoRightSwitch";
			}
			if (FieldData.SwitchSide == 'R' && autonomousScoringMechanism == "Switch"
					&& autonomousAllianceMode == "Wait/Score") {
				autonomousCommandName = "TwoRightSwitchWait";
			}
			if (FieldData.SwitchSide == 'R' && autonomousScoringMechanism == "Switch"
					&& autonomousAllianceMode == "Defend") {
				autonomousCommandName = "TwoRightSwitchDefend";
			}
			if (FieldData.SwitchSide == 'L' && autonomousScoringMechanism == "Scale"
					&& autonomousAllianceMode == "Score") {
				autonomousCommandName = "TwoLeftScale";
			}
			if (FieldData.SwitchSide == 'L' && autonomousScoringMechanism == "Scale"
					&& autonomousAllianceMode == "Wait/Score") {
				autonomousCommandName = "TwoLeftScaleWait";
			}
			if (FieldData.SwitchSide == 'L' && autonomousScoringMechanism == "Scale"
					&& autonomousAllianceMode == "Defend") {
				autonomousCommandName = "TwoLeftScaleDefend";
			}
			if (FieldData.SwitchSide == 'R' && autonomousScoringMechanism == "Scale"
					&& autonomousAllianceMode == "Score") {
				autonomousCommandName = "TwoRightScale";
			}
			if (FieldData.SwitchSide == 'R' && autonomousScoringMechanism == "Scale"
					&& autonomousAllianceMode == "Wait/Score") {
				autonomousCommandName = "TwoRightScaleWait";
			}
			if (FieldData.SwitchSide == 'R' && autonomousScoringMechanism == "Scale"
					&& autonomousAllianceMode == "Defend") {
				autonomousCommandName = "TwoRightScaleDefend";
			}
			;
			break;
		case 3:
			if (FieldData.SwitchSide == 'R' && autonomousScoringMechanism == "Switch"
					&& autonomousAllianceMode == "Score") {
				autonomousCommandName = "ThreeRightSwitch";
			}
			if (FieldData.SwitchSide == 'R' && autonomousScoringMechanism == "Switch"
					&& autonomousAllianceMode == "Wait/Score") {
				autonomousCommandName = "ThreeRightSwitchWait";
			}
			if (FieldData.SwitchSide == 'R' && autonomousScoringMechanism == "Switch"
					&& autonomousAllianceMode == "Defend") {
				autonomousCommandName = "ThreeRightSwitchDefend";
			}
			if (FieldData.SwitchSide == 'L' && autonomousScoringMechanism == "Switch") {
				autonomousCommandName = "ThreeLeftSwitchDefend";
			}
			if (FieldData.SwitchSide == 'R' && autonomousScoringMechanism == "Scale"
					&& autonomousAllianceMode == "Score") {
				autonomousCommandName = "ThreeRightScale";
			}
			if (FieldData.SwitchSide == 'R' && autonomousScoringMechanism == "Scale"
					&& autonomousAllianceMode == "Wait/Score") {
				autonomousCommandName = "ThreeRightScaleWait";
			}
			if (FieldData.SwitchSide == 'R' && autonomousScoringMechanism == "Scale"
					&& autonomousAllianceMode == "Defend") {
				autonomousCommandName = "ThreeRightScaleDefend";
			}
			if (FieldData.SwitchSide == 'L' && autonomousScoringMechanism == "Scale") {
				autonomousCommandName = "ThreeLeftScaleDefend";
			}

			;
			break;
		}
		
		autonomousCommand = new AutonomousCommand(autonomousCommandName);
		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
		 * switch(autoSelected) { case "My Auto": autonomousCommand = new
		 * MyAutoCommand(); break; case "Default Auto": default: autonomousCommand = new
		 * ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (autonomousCommand != null) {
			autonomousCommand.start();
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

		SmartDashboard.putNumber("Percent Throttle", operatorInput.getRightStickY());
		SmartDashboard.putNumber("Percent Rotation", operatorInput.getLeftStickX());

		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}