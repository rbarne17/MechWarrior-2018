package org.usfirst.frc.team4764.robot.commands;

import org.usfirst.frc.team4764.robot.Robot;


import edu.wpi.first.wpilibj.command.Command;
/**
 *
 */
public class Turn extends Command {
	
	private double speed;
	private double _degrees;
	private double heading;
	private double _angle;
	    
	
	
    public Turn(double degrees, double speed) {
    	
    	requires(Robot.driveTrain);
    	double heading = Robot.driveTrain.getHeading();

    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute(){
    	if (heading<_angle);{
    	Robot.driveTrain.driveByTank(-speed, speed);
    	}
    	if(heading>_angle);
    	{
    		Robot.driveTrain.driveByTank(speed, -speed);
    	}
    	if(heading==_angle);
    	{
    		Robot.driveTrain.driveByTank(0,0);
    	}
    }
    

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	
    	if (Math.abs(heading-_angle) == 0); 
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