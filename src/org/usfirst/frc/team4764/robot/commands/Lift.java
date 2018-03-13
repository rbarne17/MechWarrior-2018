package org.usfirst.frc.team4764.robot.commands;

import org.usfirst.frc.team4764.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */

public class Lift extends Command {
	private double m_ticksToTravel;
	private double m_finalticks;
	private double m_speed;

	public Lift(double feet, double speed) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.lift);

		m_ticksToTravel = feet * (Robot.lift.m_ticksPerFoot);
		m_speed = speed;

	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.lift.reset();

		m_finalticks = Robot.lift.getEncoderLift() + m_ticksToTravel;
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.lift.liftAdjust(m_speed);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return (Math.abs(m_finalticks - Robot.lift.getEncoderLift()) <= 0);
	}

	// Called once after isFinished returns true
	protected void end() {

	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}