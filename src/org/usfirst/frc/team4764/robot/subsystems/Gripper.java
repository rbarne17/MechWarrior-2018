package org.usfirst.frc.team4764.robot.subsystems;

import org.usfirst.frc.team4764.robot.RobotMap;
import org.usfirst.frc.team4764.robot.commands.GripperWithController;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Gripper extends Subsystem {
	Spark gripperMotor = new Spark(RobotMap.gripperMotor);
	DigitalInput gripperLimitSwitchOpen = new DigitalInput(RobotMap.gripperLimitSwitchOpen);
	DigitalInput gripperLimitSwitchClose = new DigitalInput(RobotMap.gripperLimitSwitchClose);

	public Gripper() {
		gripperMotor.set(0.0);

	}

	public void openGripper() {
		gripperMotor.set(-1);

	}

	public void closeGripper() {
		gripperMotor.set(1);

	}

	public void gripperAdjustClose(double speed) {
		gripperMotor.set(speed);
	}

	public void gripperAdjustOpen(double speed) {
		gripperMotor.set(-speed);
	}

	public void gripperAdjust(double speed) {
		gripperMotor.set(speed);
	}

	public boolean gripperClosed() {
		return gripperLimitSwitchClose.get();
	}

	public boolean gripperOpen() {
		return gripperLimitSwitchOpen.get();
	}

	public void reset() {
		gripperMotor.set(0.0);

	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand(new GripperWithController());
	}

}
