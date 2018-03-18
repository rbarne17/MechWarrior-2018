package org.usfirst.frc.team4764.robot.commands;

import org.usfirst.frc.team4764.robot.Robot;
import org.usfirst.frc.team4764.robot.subsystems.FlipityFlop;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.Timer;

/**
 *
 */
public class TimerRegular extends Command {
	Timer timer=new Timer();

	public TimerRegular() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		timer.reset();

	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		timer.start();
	} 

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		if (timer.get()>5){
			return true;
		}
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		timer.reset();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		timer.reset();
	}
}