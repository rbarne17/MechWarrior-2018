package org.usfirst.frc.team4764.robot.commands;

import org.usfirst.frc.team4764.robot.Robot;


import edu.wpi.first.wpilibj.command.Command;
/**
 *
 */
public class TurnLeft extends Command {
	
	private double _speed;
	private double _angle;
	private double _heading;
	
	    
	
	
    public TurnLeft(double degrees, double speed) {
    	
    	requires(Robot.driveTrain);
    	_angle=degrees;
    	_speed=speed;
    	

    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveTrain.gyro.reset();
    	
    	
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute(){
    	double heading=Robot.driveTrain.getHeading();
    	System.out.println(_angle-heading);
    		Robot.driveTrain.leftMotor.set(_speed);
    		Robot.driveTrain.rightMotor.set(_speed);
    	

    }
    

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	double heading=Robot.driveTrain.getHeading();
    	return ((_angle-heading)>=0);
    	}
    	

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}