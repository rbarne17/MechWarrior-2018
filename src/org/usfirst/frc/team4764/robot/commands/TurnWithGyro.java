package org.usfirst.frc.team4764.robot.commands;

import org.usfirst.frc.team4764.robot.Robot;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.command.Command;
/**
 *
 */
public class TurnWithGyro extends Command {
	
	private double speed;
	private double _degrees;
	private double heading;
	private double _angle;
	    
	
	
    public TurnWithGyro(double speed, double degrees) {
    	
    	requires(Robot.drive);
    	ADXRS450_Gyro gyro = new ADXRS450_Gyro();  
    	double angle = gyro.getAngle();
    	_angle=angle;
    	heading= angle+degrees;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute(){
    	if (heading<0);{
    	Robot.drive.driveByTank(-speed, speed);
    	}
    	if(heading>0);
    	{
    		Robot.drive.driveByTank(speed, -speed);
    	}
    	if(heading==0);
    	{
    		Robot.drive.driveByTank(0,0);
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