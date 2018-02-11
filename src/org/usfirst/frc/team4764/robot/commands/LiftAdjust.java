package org.usfirst.frc.team4764.robot.commands;

import org.usfirst.frc.team4764.robot.Robot;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LiftAdjust extends Command {

    public LiftAdjust(double speed) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.lift);
    }
    	

    // Called just before this Command runs the first time
    protected void initialize() {
    }
    	
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {

    	Robot.lift.LiftAdjust(Robot.operatorInput.getLeftStickX2());

    	Robot.lift.LiftAdjust(Robot.operatorInput.getRightStickX2());

    }
    
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
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
