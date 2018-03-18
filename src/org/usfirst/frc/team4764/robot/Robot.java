/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4764.robot;

import org.usfirst.frc.team4764.robot.commands.AutonomousCommand;
import org.usfirst.frc.team4764.robot.subsystems.Camera;
import org.usfirst.frc.team4764.robot.subsystems.DriveTrain;
import org.usfirst.frc.team4764.robot.subsystems.Gripper;
import org.usfirst.frc.team4764.robot.subsystems.Lift;
import org.usfirst.frc.team4764.robot.subsystems.FlipityFlop;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;
import org.usfirst.frc.team4764.robot.OI;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;

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
	public static final Camera camera = new Camera();
	public static final Camera camera2 = new Camera();
	public static OI operatorInput;
	public static Dashboard dashboard;
	public static FieldData fieldData;

	public static CommandGroup autonomousCommand;
	public static String autonomousAllianceMode;
	public static String autonomousScoringMechanism;
	public static String autonomousScoringMechanismWithSide;
	public static String autonomousCommandName;
	public final static String controllerMode = "DoubleController";

	/**
	 * This function is run when the robot is first started up and should be used
	 * for any initialization code.
	 */
	@Override
	public void robotInit() {
		operatorInput = new OI();
		dashboard = new Dashboard();
		dashboard.robotInit();

		
			// camera = CameraServer.getInstance().startAutomaticCapture();
			//camera.setFPS(15);
			//camera.setResolution(320,  240);
		
		
			UsbCamera camera2 = CameraServer.getInstance().startAutomaticCapture();
			camera2.setResolution(320, 240);
			camera2.setFPS(15);


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
		fieldData = new FieldData();

		autonomousScoringMechanism = dashboard.m_scoringMechanismChooser.getSelected();
		autonomousAllianceMode = dashboard.m_allianceModeChooser.getSelected();

		if ((Robot.fieldData.location == 1 && (Robot.fieldData.scaleSide == 'R' || fieldData.switchSide == 'R'))
				|| (Robot.fieldData.location == 3
						&& (Robot.fieldData.scaleSide == 'L' || Robot.fieldData.switchSide == 'L'))) {
			autonomousAllianceMode = "Defend";
		}

		dashboard.autonomousInit();
		autonomousCommand = dashboard.m_autonomousCommandChooser.getSelected();

		if (autonomousScoringMechanism == "Scale") {
			autonomousScoringMechanismWithSide = fieldData.scaleSideString + autonomousScoringMechanism;
		} else if (autonomousScoringMechanism == "Switch") {
			autonomousScoringMechanismWithSide = fieldData.switchSideString + autonomousScoringMechanism;
		}
		autonomousCommandName = fieldData.locationString + autonomousScoringMechanismWithSide + autonomousAllianceMode;

		if (autonomousCommand == null) {
			autonomousCommand = new AutonomousCommand(autonomousCommandName);
		}
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
		dashboard.autonomousPeriodic();
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		dashboard.teleopInit();
		if (autonomousCommand != null) {
			autonomousCommand.cancel();
		}

		driveTrain.reset();
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {

		dashboard.teleopPeriodic();
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}