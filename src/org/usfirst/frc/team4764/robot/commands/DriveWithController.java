package org.usfirst.frc.team4764.robot.commands;

import org.usfirst.frc.team4764.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveWithController extends Command
{
//	double rightStickYValue = Robot.OperatorInput.getRightStickY();
//	double leftStickXValue = Robot.OperatorInput.getLeftStickX();

//	double leftStickYValue = Robot.OperatorInput.getLeftStickY();

	public DriveWithController() 
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


//		Robot.driveTrain.driveByTank(-Robot.operatorInput.getRightStickY(), Robot.operatorInput.getLeftStickY());

	if(Robot.lift.getEncoderLift()>1500){
		Robot.driveTrain.driveByArcade((-Robot.operatorInput.getJoystickY()/2),(-Robot.operatorInput.getJoystickX()/2));
	}
	else {
		Robot.driveTrain.driveByArcade((-Robot.operatorInput.getJoystickY()),( -Robot.operatorInput.getJoystickX()));
	}
//		Robot.driveTrain.driveByArcade(-Robot.operatorInput.getLeftStickY(), -Robot.operatorInput.getLeftStickX());
		
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