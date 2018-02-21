package org.usfirst.frc.team4764.robot;

import org.usfirst.frc.team4764.robot.commands.Drive;
import org.usfirst.frc.team4764.robot.commands.DriveWithJoy;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Dashboard {

	final String DriveFeet = "DriveFeet";
	SendableChooser<Command> m_commandChooser = new SendableChooser<>();
	SendableChooser<String> m_ScoringMechanismChooser = new SendableChooser<>();
	SendableChooser<String> m_allianceModeChooser = new SendableChooser<>();
	SendableChooser<Command> m_chooser = new SendableChooser<>();
	SendableChooser<Command> m_autoPathChooser = new SendableChooser<>();

	public void robotInit() {
		m_commandChooser = new SendableChooser<>();
		m_ScoringMechanismChooser = new SendableChooser<>();
		m_allianceModeChooser = new SendableChooser<>();
		m_chooser = new SendableChooser<>();
		m_autoPathChooser = new SendableChooser<>();

		m_autoPathChooser.addObject(DriveFeet, new Drive(5, 0.5));
		SmartDashboard.putData(Robot.driveTrain);
		SmartDashboard.putData("Auto choices", m_autoPathChooser);
		SmartDashboard.putData("DriveFeet", new Drive(5, 0.5));

		m_commandChooser.addDefault("Default Auto", new DriveWithJoy());

		m_ScoringMechanismChooser.addObject("Switch", new String());
		m_ScoringMechanismChooser.addObject("Scale", new String());

		m_allianceModeChooser.addDefault("Score", new String());
		m_allianceModeChooser.addObject("WaitScore", new String());
		m_allianceModeChooser.addObject("Defend", new String());

		SmartDashboard.putData("Auto mode", m_commandChooser);
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
		
		

		SmartDashboard.putNumber("Percent Throttle", Robot.operatorInput.getRightStickY());
		SmartDashboard.putNumber("Percent Rotation", Robot.operatorInput.getLeftStickX());

	}

	public void autonomousPeriodic() {

	}
}
