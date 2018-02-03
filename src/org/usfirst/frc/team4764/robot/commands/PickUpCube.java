package org.usfirst.frc.team4764.robot.commands;

import org.usfirst.frc.team4764.robot.Robot;
import org.usfirst.frc.team4764.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PickUpCube extends Command {

    public PickUpCube() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.gripper);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.gripper.doNothing();;
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.gripper.Gripperclose();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	DigitalInput gripperclose= new DigitalInput(RobotMap.gripperclose);
    	if (gripperclose.get()){
    		
        return true;
       }
    	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drive.doNothing();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.drive.doNothing();
    }
}