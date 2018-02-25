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

	public Drive(double feetToTravel, double speed) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);

		m_ticksToTravel = feetToTravel * Robot.driveTrain.ticksPerFoot;
		if (feetToTravel < 0) {
			m_speed = -speed;
		} else {
			m_speed = speed;
		}
		requires(Robot.driveTrain);
	}

	public Drive(int inchesToTravel, double speed) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);

		m_ticksToTravel = inchesToTravel * Robot.driveTrain.ticksPerFoot/12;
		if (inchesToTravel < 0) {
			m_speed = -speed;
		} else {
			m_speed = speed;
		}
		requires(Robot.driveTrain);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.driveTrain.leftEncoder.reset();
		Robot.driveTrain.rightEncoder.reset();
		m_finalTickTargetLeft = m_ticksToTravel + Robot.driveTrain.getEncoderLeft();
		m_finalTickTargetRight = m_ticksToTravel + Robot.driveTrain.getEncoderRight();

	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
   	 double angle = Robot.driveTrain.getHeading();
   	 double heading= 0;
   	 double error=heading-angle;
   	 double Kp = 0.03;
   	 this.integral += (error*.02);
   	 double Ki=0;
   	 drive_angle = (Kp*error)+(Ki*this.integral);*/
   	 drive_angle=0;
		m_driveAngle = 0;
		Robot.driveTrain.driveByArcade(m_speed, m_driveAngle);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return (Math.abs(m_finalTickTargetLeft - Robot.driveTrain.getEncoderLeft()) <= 0
				&& Math.abs(m_finalTickTargetRight - Robot.driveTrain.getEncoderRight()) <= 0);
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}