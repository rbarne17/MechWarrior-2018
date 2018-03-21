package org.usfirst.frc.team4764.robot.subsystems;

import org.usfirst.frc.team4764.robot.RobotMap;
import org.usfirst.frc.team4764.robot.commands.FlipityFlopWithController;
import org.usfirst.frc.team4764.robot.commands.GrabCube;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */

import edu.wpi.first.wpilibj.command.Subsystem;

public class FlyWheel extends Subsystem {
	Spark flyWheelMotorRight = new Spark(RobotMap.flyWheelMotorRight);
	Spark flyWheelMotorLeft = new Spark(RobotMap.flyWheelMotorLeft);

	public FlyWheel() {
		flyWheelMotorRight.set(0.0);
		flyWheelMotorLeft.set(0.0);

	}

	public void flyWheelAdjust(double speed) {
		flyWheelMotorRight.set(speed);
		flyWheelMotorLeft.set(-speed);
	}

	public void reset() {
		flyWheelMotorRight.set(0.0);
		flyWheelMotorLeft.set(0.0);
	}

	@Override
	protected void initDefaultCommand() {
		new GrabCube();
	}

}
