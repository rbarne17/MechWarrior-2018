package org.usfirst.frc.team4764.robot.commands;

import org.usfirst.frc.team4764.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class FlopWithJoy extends Command {

    public FlopWithJoy() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.flipityFlop);
    }
    	

    // Called just before this Command runs the first time
    protected void initialize() {
    }
    	
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {

    	Robot.flipityFlop.FlopAdjust(Robot.operatorInput.getXboxLeftStickY());

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
