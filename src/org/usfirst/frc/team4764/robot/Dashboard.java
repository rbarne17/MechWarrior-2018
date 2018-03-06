package org.usfirst.frc.team4764.robot;

import org.usfirst.frc.team4764.robot.commands.Drive;
import org.usfirst.frc.team4764.robot.commands.DropCube;
import org.usfirst.frc.team4764.robot.commands.FlipityFlopLevel;
import org.usfirst.frc.team4764.robot.commands.FlipityFlopUp;
import org.usfirst.frc.team4764.robot.commands.Lift;
import org.usfirst.frc.team4764.robot.commands.LiftHome;
import org.usfirst.frc.team4764.robot.commands.PickUpCube;
import org.usfirst.frc.team4764.robot.commands.TurnLeft;
import org.usfirst.frc.team4764.robot.commands.TurnRight;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Dashboard {

	SendableChooser<Command> m_commandChooser;
	SendableChooser<String> m_scoringMechanismChooser;
	SendableChooser<String> m_allianceModeChooser;

	public void robotInit() {

		// subsystems display
		SmartDashboard.putData(Robot.driveTrain);
		SmartDashboard.putData(Robot.lift);
		SmartDashboard.putData(Robot.flipityFlop);
		SmartDashboard.putData(Robot.gripper);

		// choosers
		m_commandChooser = new SendableChooser<>();
		m_scoringMechanismChooser = new SendableChooser<>();
		m_allianceModeChooser = new SendableChooser<>();

		// add commands to m_commandChooser
		m_commandChooser.addObject("Drive 4 Feet", new Drive(4.0, 0.7, 'f'));
		m_commandChooser.addObject("Drop Cube", new DropCube());
		m_commandChooser.addObject("Pick Up Cube", new PickUpCube());
		m_commandChooser.addObject("Turn Left 45 Degrees", new TurnLeft(45.0, .5));
		m_commandChooser.addObject("Turn Right 45 Degrees", new TurnRight(45.0, .5));
		m_commandChooser.addObject("Turn Left 90 Degrees", new TurnLeft(90.0, .5));
		m_commandChooser.addObject("Turn Right 90 Degrees", new TurnRight(90.0, .5));
		m_commandChooser.addObject("Turn Left 180 Degrees", new TurnLeft(180.0, .5));
		m_commandChooser.addObject("Turn Right 360 Degrees", new TurnRight(360.0, .5));
		m_commandChooser.addObject("Pick Up Cube", new PickUpCube());
		m_commandChooser.addObject("Lift To Home", new LiftHome(.5));
		m_commandChooser.addObject("Lift 12 Inches", new Lift(12, .5));
		m_commandChooser.addObject("FlipityFlop Up", new FlipityFlopUp());
		m_commandChooser.addObject("FlipityFlop Level", new FlipityFlopLevel());

		// add scoring mechanism to m_scoringMechanismChooser
		m_scoringMechanismChooser.addDefault("Switch", new String());
		m_scoringMechanismChooser.addObject("Scale", new String());

		// add alliance mode to m_allianceModeChooser
		m_allianceModeChooser.addDefault("Score", new String());
		m_allianceModeChooser.addObject("WaitScore", new String());
		m_allianceModeChooser.addObject("Defend", new String());

		// populate the SmartDashboard with the choosers
		SmartDashboard.putData("Switch or Scale", m_scoringMechanismChooser);
		SmartDashboard.putData("Alliance Mode", m_allianceModeChooser);
		SmartDashboard.putData("Commands", m_commandChooser);
	}

	public void teleopInit() {

	}

	public void autonomousInit() {

	}

	public void teleopPeriodic()

	{
		// DriveTrain
		SmartDashboard.putNumber("DriveTrain Encoder Right", Robot.driveTrain.getEncoderRight());
		SmartDashboard.putNumber("DriveTrain Encoder Left", Robot.driveTrain.getEncoderLeft());
		SmartDashboard.putNumber("Percent Throttle", Robot.operatorInput.getJoystickY());
		SmartDashboard.putNumber("Percent Rotation", Robot.operatorInput.getJoystickX());
		SmartDashboard.putNumber("GyroHeading", Robot.driveTrain.getHeading());
		SmartDashboard.putNumber("ACTUAL Percent Throttle",
				Robot.driveTrain.scalingSpeed(Robot.operatorInput.getJoystickY()));
		SmartDashboard.putNumber("ACTUAL Percent Rotation",
				Robot.driveTrain.scalingSpeed(Robot.operatorInput.getJoystickX()));

		// Lift
		SmartDashboard.putNumber("Lift Encoder", Robot.lift.getEncoderLift());
		SmartDashboard.putBoolean("LiftAtHome", Robot.lift.liftAtHome());

		// Gripper
		SmartDashboard.putBoolean("GripperClosed", Robot.gripper.gripperClosed());
		SmartDashboard.putBoolean("GripperOpen", Robot.gripper.gripperOpen());
		
		//FlipityFlop
		SmartDashboard.putBoolean("FlipityFlopUp", Robot.flipityFlop.flipityFlopUp());
		SmartDashboard.putBoolean("FlipityFlopLevel", Robot.flipityFlop.flipityFlopLevel());

		
		
	}

	public void autonomousPeriodic() {

	}
}
