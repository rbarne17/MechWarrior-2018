package org.usfirst.frc.team4764.robot;

import org.usfirst.frc.team4764.robot.commands.Drive;
import org.usfirst.frc.team4764.robot.commands.DropCube;
import org.usfirst.frc.team4764.robot.commands.FlipityFlopLevel;
import org.usfirst.frc.team4764.robot.commands.FlipityFlopUp;
import org.usfirst.frc.team4764.robot.commands.Lift;
import org.usfirst.frc.team4764.robot.commands.LiftHome;
import org.usfirst.frc.team4764.robot.commands.PickUpCube;
import org.usfirst.frc.team4764.robot.commands.Turn;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Dashboard {

	SendableChooser<String> m_ScoringMechanismChooser = new SendableChooser<>();
	SendableChooser<String> m_allianceModeChooser = new SendableChooser<>();

	public void robotInit() {

		// subsystems display
		SmartDashboard.putData(Robot.driveTrain);
		SmartDashboard.putData(Robot.lift);
		SmartDashboard.putData(Robot.flipityFlop);
		SmartDashboard.putData(Robot.gripper);

		// commands
		SmartDashboard.putData("DriveFeet", new Drive(5, 0.5));
		SmartDashboard.putData("Drop Cube", new DropCube());
		SmartDashboard.putData("Turn 45 Degrees", new Turn(45.0, .5));
		SmartDashboard.putData("Turn 90 Degrees", new Turn(90.0, .5));
		SmartDashboard.putData("Turn 180 Degrees", new Turn(180.0, .5));
		SmartDashboard.putData("Turn 360 Degrees", new Turn(360.0, .5));

		SmartDashboard.putData("Pick Up Cube", new PickUpCube());
		SmartDashboard.putData("Lift To Home", new LiftHome(.5));
		SmartDashboard.putData("Lift 12 Inches", new Lift(12, .5));
		SmartDashboard.putData("FlipityFlop Up", new FlipityFlopUp());
		SmartDashboard.putData("FlipityFlop Level", new FlipityFlopLevel());

		// choosers
		m_ScoringMechanismChooser = new SendableChooser<>();
		m_allianceModeChooser = new SendableChooser<>();

		m_ScoringMechanismChooser.addDefault("Switch", new String());
		m_ScoringMechanismChooser.addObject("Scale", new String());

		m_allianceModeChooser.addDefault("Score", new String());
		m_allianceModeChooser.addObject("WaitScore", new String());
		m_allianceModeChooser.addObject("Defend", new String());
		
		SmartDashboard.putData("Switch or Scale", m_ScoringMechanismChooser);
		SmartDashboard.putData("Alliance Mode", m_allianceModeChooser);

	}

	public void teleopInit() {

	}

	public void autonomousInit() {

	}

	public void teleopPeriodic()

	{
		SmartDashboard.putNumber("DriveTrain Encoder Right", Robot.driveTrain.getEncoderRight());
		SmartDashboard.putNumber("DriveTrain Encoder Left", Robot.driveTrain.getEncoderLeft());
		SmartDashboard.putNumber("Lift Encoder", Robot.lift.getEncoderLift());

		SmartDashboard.putNumber("Percent Throttle", Robot.operatorInput.getJoystickY());
		SmartDashboard.putNumber("Percent Rotation", Robot.operatorInput.getJoystickX());
		SmartDashboard.putNumber("GyroHeading", Robot.driveTrain.getHeading());

		SmartDashboard.putNumber("TEST:ACTUAL Percent Throttle",
				Robot.driveTrain.scalingSpeed(Robot.operatorInput.getJoystickY()));
		SmartDashboard.putNumber("TEST:ACTUAL Percent Rotation",
				Robot.driveTrain.scalingSpeed(Robot.operatorInput.getJoystickX()));

	}

	public void autonomousPeriodic() {

	}
}
