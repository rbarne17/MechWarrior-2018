package org.usfirst.frc.team4764.robot.subsystems;

import org.usfirst.frc.team4764.robot.RobotMap;
import org.usfirst.frc.team4764.robot.commands.FlopWithJoy;
import org.usfirst.frc.team4764.robot.commands.GripperWithJoy;

import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Gripper extends Subsystem {
	Spark gripperMotor = new Spark(RobotMap.gripperMotor);
	//public DigitalOutput gripperLimitSwitchOpen = new DigitalOutput(RobotMap.gripperLimitSwitchOpen);
	//public DigitalOutput gripperLimitSwitchClose = new DigitalOutput(RobotMap.gripperLimitSwitchClose);

	public Gripper() {
		gripperMotor.set(0.0);

	}

	public void openGripper() {
		gripperMotor.set(-1);
		
	}

	public void closeGripper() {
		gripperMotor.set(1);

	}
	public void gripperAdjust(double speed){
		gripperMotor.set(speed);
	}

	public void reset() {
		gripperMotor.set(0.0);

	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand(new GripperWithJoy());
	}

}
