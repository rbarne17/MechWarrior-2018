package org.usfirst.frc.team4764.robot.subsystems;

import org.usfirst.frc.team4764.robot.RobotMap;
import org.usfirst.frc.team4764.robot.commands.FlipityFlopWithController;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */

import edu.wpi.first.wpilibj.command.Subsystem;

public class FlipityFlop extends Subsystem {
	Spark flopMotor = new Spark(RobotMap.flipityFlopMotor);
	DigitalInput flipityFlopLimitSwitchUp = new DigitalInput(RobotMap.flipityFlopLimitSwitchUp);
	DigitalInput flipityFlopLimitSwitchLevel = new DigitalInput(RobotMap.flipityFlopLimitSwitchLevel);

	public FlipityFlop() {
		flopMotor.set(0.0);

	}

	public void setLevel() {
		flopMotor.set(1);
	}

	public void setUp() {
		flopMotor.set(-1);
	}

	public void flopAdjust(double speed) {
		flopMotor.set(speed);
	}

	public boolean flipityFlopUp() {
		// limit switches return false when triggered
		return !flipityFlopLimitSwitchUp.get();
	}

	public boolean flipityFlopLevel() {
		// limit switches return false when triggered
		return !flipityFlopLimitSwitchLevel.get();
	}

	public void reset() {
		flopMotor.set(0.0);
	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new FlipityFlopWithController());
	}

}
