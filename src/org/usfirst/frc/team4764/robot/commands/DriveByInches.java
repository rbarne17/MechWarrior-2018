package org.usfirst.frc.team4764.robot.commands;

import org.usfirst.frc.team4764.robot.Robot;
import org.usfirst.frc.team4764.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.interfaces.Gyro;

/**
 *
 */
public class DriveByInches extends Command {
	
	private double _ticksToTravel;
	private double _speed;
	
	private double _finalTickTargetLeft;
	private double _finalTickTargetRight;
	private  Gyro gyro;
	private double speed;

	    double Kp = 0.03;
	
	
    public DriveByInches(double inchesToTravel, double speed) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	
//    	4096 is the number of ticks per revolution
//    	217.2995489 is our ticks per inch
    	int radius = 6;
    	_ticksToTravel = inchesToTravel * (4096/(2*Math.PI*radius));
    	if (inchesToTravel < 0)
    	{
    		_speed = -speed;
    	}
    	else
    	{
    		_speed = speed;
    	}
    	requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	_finalTickTargetLeft = _ticksToTravel + Robot.driveTrain.getEncoderLeft();
    	_finalTickTargetRight = _ticksToTravel + Robot.driveTrain.getEncoderRight();
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	 double angle = gyro.getAngle();
    	 Robot.driveTrain.driveByArcade(speed, -angle*Kp);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (Math.abs(_finalTickTargetLeft - Robot.driveTrain.getEncoderLeft()) <= 0 &&
    			Math.abs(_finalTickTargetRight - Robot.driveTrain.getEncoderRight()) <= 0)
    	{
    		return true;
    	}
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}