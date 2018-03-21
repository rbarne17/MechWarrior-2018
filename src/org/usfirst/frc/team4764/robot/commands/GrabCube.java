package org.usfirst.frc.team4764.robot.commands;

import org.usfirst.frc.team4764.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GrabCube extends Command {

    public GrabCube() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.flyWheel.reset();
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.flyWheel.flyWheelAdjust(.5);
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
    	Robot.flyWheel.reset();
    }
}
