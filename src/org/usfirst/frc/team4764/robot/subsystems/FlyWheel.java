package org.usfirst.frc.team4764.robot.subsystems;

import org.usfirst.frc.team4764.robot.RobotMap;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */

public class FlyWheel extends Subsystem {
	Spark flyWheelMotor = new Spark(RobotMap.flyWheelMotor);

	public FlyWheel() {
		flyWheelMotor.set(0.0);

	}

	public void flyWheelPull(double speed) {
		flyWheelMotor.set(speed);
	}

	public void flyWheelPush(double speed) {
		flyWheelMotor.set(-speed);
	}

	public void reset() {
		flyWheelMotor.set(0.0);
	}

	@Override
	protected void initDefaultCommand() {
	}

}
