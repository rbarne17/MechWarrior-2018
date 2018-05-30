package org.usfirst.frc.team4764.robot.commands;

import org.usfirst.frc.team4764.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Drive extends Command {

	private double m_ticksToTravel;
	private double m_speed;

	private double m_finalTickTargetLeft;
	private double m_finalTickTargetRight;
	private double m_driveAngle;
	private double m_integral;

	public Drive(double distanceToTravel, double speed) {
		// distance to travel in feet
		this(distanceToTravel, speed, 'f');
	}

	public Drive(double distanceToTravel) {
		this(distanceToTravel, .7, 'f');
	}

	public Drive(double distanceToTravel, double speed, char unitOfTravel) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);

		// distanceToTravel in inches
		if (unitOfTravel == 'i') {
			m_ticksToTravel = distanceToTravel * Robot.driveTrain.ticksPerFoot / 12;
		}
		// distanceToTravel in feet
		else {
			m_ticksToTravel = distanceToTravel * Robot.driveTrain.ticksPerFoot;
		}

		if (distanceToTravel < 0) {
			m_speed = speed;
		} else {
			m_speed = -speed;
		}
		requires(Robot.driveTrain);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.driveTrain.leftEncoder.reset();
		Robot.driveTrain.rightEncoder.reset();
		Robot.driveTrain.gyro.reset();
		m_finalTickTargetLeft = m_ticksToTravel - Robot.driveTrain.getEncoderLeft();
		m_finalTickTargetRight = m_ticksToTravel - Robot.driveTrain.getEncoderRight();

	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		double angle = Robot.driveTrain.getHeading();
		double error = angle;
		double Kp = 0.3;
		this.m_integral += (error * .02);
		double Ki = 0;
		m_driveAngle = (Kp * error) + (Ki * this.m_integral);
		Robot.driveTrain.driveByArcade(m_speed, m_driveAngle);
	}

	// Make this return true when this Command no longer needs to run execu te()
	protected boolean isFinished() {
		return (m_finalTickTargetLeft - Robot.driveTrain.getEncoderLeft() <= 0
				&& m_finalTickTargetRight - Robot.driveTrain.getEncoderRight() <= 0);
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}