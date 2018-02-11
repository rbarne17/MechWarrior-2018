package org.usfirst.frc.team4764.robot.commands;

import org.usfirst.frc.team4764.robot.OI;
import org.usfirst.frc.team4764.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveWithJoy extends Command
{
//	double rightStickYValue = Robot.OperatorInput.getRightStickY();
//	double leftStickXValue = Robot.OperatorInput.getLeftStickX();

//	double leftStickYValue = Robot.OperatorInput.getLeftStickY();

	public DriveWithJoy() 
	{
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.driveTrain);

	}

	// Called just before this Command runs the first time
	protected void initialize()
	{

	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{

//		leftStickXValue = Robot.OperatorInput.getLeftStickX();
//		rightStickYValue = Robot.OperatorInput.getRightStickY();


//		Robot.driveTrain.driveByTank(Robot.OperatorInput.getLeftStickY(), Robot.OperatorInput.getRightStickY());
//		Robot.DriveTrain.driveByArcade(Robot.OperatorInput.getLeftStickY(), -Robot.OperatorInput.getLeftStickX());	
		Robot.driveTrain.driveByArcade(Robot.operatorInput.JoystickY(), -Robot.operatorInput.JoystickX());


	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() 
	{
		return false;
	}

	// Called once after isFinished returns true
	protected void end()
	{
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted()
	{
	}


}