package org.usfirst.frc.team4764.robot.commands;

import org.usfirst.frc.team4764.robot.Robot;
import org.usfirst.frc.team4764.robot.subsystems.Drive;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.interfaces.Gyro;

/**
 *
 */
public class GYROTURN extends Command {
	
	private  Gyro gyro;
	private double speed;
	private double degrees;

	    
	
	
    public GYROTURN(double speed, double degrees) {
    	
    	requires(Robot.drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (degrees<0);{
    	Robot.drive.driveByTank(-speed, speed);
    	}
    	if(degrees>0);
    	{
    		Robot.drive.driveByTank(speed, -speed);
    	}
    	 
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	double angle = gyro.getAngle();
    	if (Math.abs(angle - degrees) == 0); 
    	{
    		return true;
    	}
      
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}