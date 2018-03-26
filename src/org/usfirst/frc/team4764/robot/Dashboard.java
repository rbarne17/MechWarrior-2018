package org.usfirst.frc.team4764.robot;

import org.usfirst.frc.team4764.robot.commands.AutonomousCommand;
import org.usfirst.frc.team4764.robot.commands.Drive;
import org.usfirst.frc.team4764.robot.commands.DropCube;
import org.usfirst.frc.team4764.robot.commands.FlipityFlopLevel;
import org.usfirst.frc.team4764.robot.commands.FlipityFlopUp;
import org.usfirst.frc.team4764.robot.commands.Lift;
import org.usfirst.frc.team4764.robot.commands.LiftHome;
import org.usfirst.frc.team4764.robot.commands.PickUpCube;
import org.usfirst.frc.team4764.robot.commands.TimerRegular;
import org.usfirst.frc.team4764.robot.commands.TurnLeft;
import org.usfirst.frc.team4764.robot.commands.TurnRight;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Dashboard {

	SendableChooser<String> m_robotPositionChooser;
	SendableChooser<CommandGroup> m_autonomousCommandChooser;
	SendableChooser<String> m_scoringMechanismChooser;
	SendableChooser<String> m_allianceModeChooser;
	

	public void robotInit() {

		//create choosers
		m_robotPositionChooser = new SendableChooser<>();
		m_autonomousCommandChooser = new SendableChooser<>();
		m_scoringMechanismChooser = new SendableChooser<>();
		m_allianceModeChooser = new SendableChooser<>();

		// subsystems display
		SmartDashboard.putData(Robot.driveTrain);
		SmartDashboard.putData(Robot.lift);
		SmartDashboard.putData(Robot.flipityFlop);
		SmartDashboard.putData(Robot.gripper);

		// choosers
		m_autonomousCommandChooser = new SendableChooser<CommandGroup>();
		m_scoringMechanismChooser = new SendableChooser<String>();
		m_allianceModeChooser = new SendableChooser<String>();

		//various commands
		SmartDashboard.putData("Drive 1 Foot", new Drive(1.0));
		SmartDashboard.putData("Drive 4 Feet", new Drive(4.0));
		SmartDashboard.putData("Drop Cube", new DropCube());
		SmartDashboard.putData("Pick Up Cube", new PickUpCube());
		SmartDashboard.putData("Turn Left 45 Degrees", new TurnLeft(-45.0, .5));
		SmartDashboard.putData("Turn Right 45 Degrees", new TurnRight(45.0, .5));
		SmartDashboard.putData("Turn Left 90 Degrees", new TurnLeft(-90.0, .5));
		SmartDashboard.putData("Turn Right 90 Degrees", new TurnRight(90.0, .5));
		SmartDashboard.putData("Turn Left 180 Degrees", new TurnLeft(-180.0, .5));
		SmartDashboard.putData("Turn Right 360 Degrees", new TurnRight(360.0, .5));
		SmartDashboard.putData("Pick Up Cube", new PickUpCube());
		SmartDashboard.putData("Lift To Home", new LiftHome(.5));
		SmartDashboard.putData("Lift 12 Inches", new Lift(1, .5));
		SmartDashboard.putData("FlipityFlop Up", new FlipityFlopUp());
		SmartDashboard.putData("FlipityFlop Level", new FlipityFlopLevel());
		SmartDashboard.putData("Timer", new TimerRegular());
		
		//commands from autonomous commands
		SmartDashboard.putData("Drive 1.0",new Drive(1.0));
		SmartDashboard.putData("Drive 1.2",new Drive(1.2));
		SmartDashboard.putData("Drive 2.0",new Drive(2.0));
		SmartDashboard.putData("Drive 3.0",new Drive(3.0));
		SmartDashboard.putData("Drive 5.0",new Drive(5.0));
		SmartDashboard.putData("Drive 8.0",new Drive(8.0));
		SmartDashboard.putData("Drive 14.0",new Drive(14.0));
		SmartDashboard.putData("Drive 18.0",new Drive(18.0));
		SmartDashboard.putData("Drive 22.0",new Drive(22.0));
		SmartDashboard.putData("Drive 27.0",new Drive(27.0));
		SmartDashboard.putData("Drop Cube",new DropCube());
		SmartDashboard.putData("Lift 24 ",new Lift(2,0.7));
		SmartDashboard.putData("Lift 36",new Lift(3.0,0.7));
		SmartDashboard.putData("Lift 66",new Lift(5.5,0.7));
		SmartDashboard.putData("Turn Left 90",new TurnLeft(-90,0.7));
		SmartDashboard.putData("Turn Right 90",new TurnRight(90,0.7));

		//add autonomous commands to m_autonomousCommandChooser
		m_autonomousCommandChooser.addObject("OneLeftSwitchScore",new AutonomousCommand("OneLeftSwitchScore"));
		m_autonomousCommandChooser.addObject("OneLeftSwitchWaitScore",new AutonomousCommand("OneLeftSwitchWaitScore"));
		m_autonomousCommandChooser.addObject("OneRightSwitchDefend",new AutonomousCommand("OneRightSwitchDefend"));
		m_autonomousCommandChooser.addObject("OneLeftScaleScore",new AutonomousCommand("OneLeftScaleScore"));
		m_autonomousCommandChooser.addObject("OneLeftScaleWaitScore",new AutonomousCommand("OneLeftScaleWaitScore"));
		m_autonomousCommandChooser.addObject("OneRightScaleDefend",new AutonomousCommand("OneRightScaleDefend"));
		m_autonomousCommandChooser.addObject("TwoLeftSwitchScore",new AutonomousCommand("TwoLeftSwitchScore"));
		m_autonomousCommandChooser.addObject("TwoLeftSwitchWaitScore",new AutonomousCommand("TwoLeftSwitchWaitScore"));
		m_autonomousCommandChooser.addObject("TwoLeftSwitchDefend",new AutonomousCommand("TwoLeftSwitchDefend"));
		m_autonomousCommandChooser.addObject("TwoRightSwitchScore",new AutonomousCommand("TwoRightSwitchScore"));
		m_autonomousCommandChooser.addObject("TwoRightSwitchWaitScore",new AutonomousCommand("TwoRightSwitchWaitScore"));
		m_autonomousCommandChooser.addObject("TwoRightSwitchDefend",new AutonomousCommand("TwoRightSwitchDefend"));
		m_autonomousCommandChooser.addObject("TwoLeftScaleScore",new AutonomousCommand("TwoLeftScaleScore"));
		m_autonomousCommandChooser.addObject("TwoLeftScaleWaitScore",new AutonomousCommand("TwoLeftScaleWaitScore"));
		m_autonomousCommandChooser.addObject("TwoLeftScaleDefend",new AutonomousCommand("TwoLeftScaleDefend"));
		m_autonomousCommandChooser.addObject("TwoRightScaleScore",new AutonomousCommand("TwoRightScaleScore"));
		m_autonomousCommandChooser.addObject("TwoRightScaleWaitScore",new AutonomousCommand("TwoRightScaleWaitScore"));
		m_autonomousCommandChooser.addObject("TwoRightScaleDefend",new AutonomousCommand("TwoRightScaleDefend"));
		m_autonomousCommandChooser.addObject("ThreeRightSwitchScore",new AutonomousCommand("ThreeRightSwitchScore"));
		m_autonomousCommandChooser.addObject("ThreeRightSwitchWaitScore",new AutonomousCommand("ThreeRightSwitchWaitScore"));
		m_autonomousCommandChooser.addObject("ThreeLeftSwitchDefend",new AutonomousCommand("ThreeLeftSwitchDefend"));
		m_autonomousCommandChooser.addObject("ThreeRightScaleScore",new AutonomousCommand("ThreeRightScaleScore"));
		m_autonomousCommandChooser.addObject("ThreeRightScaleWaitScore",new AutonomousCommand("ThreeRightScaleWaitScore"));
		m_autonomousCommandChooser.addObject("ThreeLeftScaleDefend",new AutonomousCommand("ThreeLeftScaleDefend"));

		//add positions to m_robotPositionChooser
		m_robotPositionChooser.addDefault("One","One");
		m_robotPositionChooser.addObject("Two","Two");
		m_robotPositionChooser.addObject("Three","Three");
		
		// add scoring mechanism to m_scoringMechanismChooser
		m_scoringMechanismChooser.addDefault("Switch", "Switch");
		m_scoringMechanismChooser.addObject("Scale", "Scale");

		// add alliance mode to m_allianceModeChooser
		m_allianceModeChooser.addDefault("Score", "Score");
		m_allianceModeChooser.addObject("WaitScore", "WaitScore");
		m_allianceModeChooser.addObject("Defend", "Defend");

		// populate the SmartDashboard with the choosers
		SmartDashboard.putData("Robot Position", m_robotPositionChooser);
		SmartDashboard.putData("Switch or Scale", m_scoringMechanismChooser);
		SmartDashboard.putData("Alliance Mode", m_allianceModeChooser);
		SmartDashboard.putData("Commands", m_autonomousCommandChooser);
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
		SmartDashboard.putNumber("Percent Throttle", Robot.operatorInput.getControllerDriveTrainThrottleValue());
		SmartDashboard.putNumber("Percent Rotation", Robot.operatorInput.getControllerDriveTrainRotationValue());
		SmartDashboard.putNumber("GyroHeading", Robot.driveTrain.getHeading());
		SmartDashboard.putNumber("ACTUAL Percent Throttle",
				Robot.driveTrain.scalingSpeed(Robot.operatorInput.getControllerDriveTrainThrottleValue()));
		SmartDashboard.putNumber("ACTUAL Percent Rotation",
				Robot.driveTrain.scalingSpeed(Robot.operatorInput.getControllerDriveTrainRotationValue()));

		// Lift
		SmartDashboard.putNumber("Lift Encoder", Robot.lift.getEncoderLift());
		SmartDashboard.putBoolean("LiftAtHome", Robot.lift.liftAtHome());
		SmartDashboard.putNumber("LiftControllerValue", Robot.operatorInput.getControllerLiftValue());

		// Gripper
		SmartDashboard.putBoolean("GripperClosed", Robot.gripper.gripperClosed());
		SmartDashboard.putBoolean("GripperOpen", Robot.gripper.gripperOpen());
		SmartDashboard.putNumber("GripperControllerValue", Robot.operatorInput.getControllerGripperValue());
		
		//FlipityFlop
		SmartDashboard.putBoolean("FlipityFlopUp", Robot.flipityFlop.flipityFlopUp());
		SmartDashboard.putBoolean("FlipityFlopLevel", Robot.flipityFlop.flipityFlopLevel());
		SmartDashboard.putNumber("FlipityFlopControllerValue", Robot.operatorInput.getControllerFlipityFlopValue());
	}

	public void autonomousPeriodic() {
		// DriveTrain
		SmartDashboard.putNumber("DriveTrain Encoder Right", Robot.driveTrain.getEncoderRight());
		SmartDashboard.putNumber("DriveTrain Encoder Left", Robot.driveTrain.getEncoderLeft());
		SmartDashboard.putNumber("Percent Throttle", Robot.operatorInput.getControllerDriveTrainThrottleValue());
		SmartDashboard.putNumber("Percent Rotation", Robot.operatorInput.getControllerDriveTrainRotationValue());
		SmartDashboard.putNumber("GyroHeading", Robot.driveTrain.getHeading());
		SmartDashboard.putNumber("ACTUAL Percent Throttle",
				Robot.driveTrain.scalingSpeed(Robot.operatorInput.getControllerDriveTrainThrottleValue()));
		SmartDashboard.putNumber("ACTUAL Percent Rotation",
				Robot.driveTrain.scalingSpeed(Robot.operatorInput.getControllerDriveTrainRotationValue()));

		// Lift
		SmartDashboard.putNumber("Lift Encoder", Robot.lift.getEncoderLift());
		SmartDashboard.putBoolean("LiftAtHome", Robot.lift.liftAtHome());
		SmartDashboard.putNumber("LiftControllerValue", Robot.operatorInput.getControllerLiftValue());

		// Gripper
		//SmartDashboard.putBoolean("GripperClosed", Robot.gripper.gripperClosed());
		//SmartDashboard.putBoolean("GripperOpen", Robot.gripper.gripperOpen());
		SmartDashboard.putNumber("GripperControllerValue", Robot.operatorInput.getControllerGripperValue());
		
		//FlipityFlop
		SmartDashboard.putBoolean("FlipityFlopUp", Robot.flipityFlop.flipityFlopUp());
		SmartDashboard.putBoolean("FlipityFlopLevel", Robot.flipityFlop.flipityFlopLevel());
		SmartDashboard.putNumber("FlipityFlopControllerValue", Robot.operatorInput.getControllerFlipityFlopValue());

	}
}
