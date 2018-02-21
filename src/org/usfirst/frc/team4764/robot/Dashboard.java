package org.usfirst.frc.team4764.robot;

import org.usfirst.frc.team4764.robot.commands.DriveWithJoy;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Dashboard {

	SendableChooser<Command> m_commandChooser = new SendableChooser<>();
	SendableChooser<String> m_ScoringMechanismChooser = new SendableChooser<>();
	SendableChooser<String> m_allianceModeChooser = new SendableChooser<>();
	SendableChooser<Command> m_chooser = new SendableChooser<>();

	public void robotInit() {
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
		SmartDashboard.putNumber("Encoder Right", Robot.driveTrain.getEncoderRight());
		SmartDashboard.putNumber("Encoder Left", Robot.driveTrain.getEncoderLeft());

		SmartDashboard.putNumber("Percent Throttle", Robot.operatorInput.getRightStickY());
		SmartDashboard.putNumber("Percent Rotation", Robot.operatorInput.getLeftStickX());

	}

	public void autonomousPeriodic() {

	}
}
