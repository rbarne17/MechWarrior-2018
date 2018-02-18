package org.usfirst.frc.team4764.robot.commands;

import org.usfirst.frc.team4764.robot.Robot;
import org.usfirst.frc.team4764.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */

public class LiftHome extends Command {
	private double _speed;

	public LiftHome(double speed) {

		requires(Robot.lift);
		_speed = speed;
	}

	// Called just before this Command runs the first time
	protected void initialize() {

	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.lift.liftAdjust(-_speed);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return Robot.lift.liftAtHome();
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.lift.reset();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
