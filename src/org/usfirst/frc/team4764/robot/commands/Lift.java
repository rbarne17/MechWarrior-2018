package org.usfirst.frc.team4764.robot.commands;

import org.usfirst.frc.team4764.robot.Robot;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */

public class Lift extends Command {
	private double _ticksToTravel;
	private double finalticks;
	private double _speed;
    public Lift(double Inches, double speed) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.lift);
    	 int ticksperrev=4096;
    	int radius=4;
    	_ticksToTravel= Inches*(ticksperrev/(2*Math.PI*radius));
    	_speed=speed;
    	
    }
    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	finalticks=Robot.lift.getEncoderLift()+_ticksToTravel;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.lift.liftAdjust(_speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (Math.abs(finalticks - Robot.lift.getEncoderLift()) <= 0) 
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