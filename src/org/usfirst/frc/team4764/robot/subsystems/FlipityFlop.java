package org.usfirst.frc.team4764.robot.subsystems;

import org.usfirst.frc.team4764.robot.RobotMap;
import org.usfirst.frc.team4764.robot.commands.FlipityFlopUp;
import org.usfirst.frc.team4764.robot.commands.FlopWithJoy;
import org.usfirst.frc.team4764.robot.commands.LiftWithJoy;

import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */

import edu.wpi.first.wpilibj.command.Subsystem;

public class FlipityFlop extends Subsystem {
	Spark flopMotor = new Spark(RobotMap.gripperMotor);
	public DigitalOutput flopUp = new DigitalOutput(RobotMap.flopUp);
	public DigitalOutput flopLevel = new DigitalOutput(RobotMap.flopLevel);

	public FlipityFlop() {
		flopMotor.set(0.0);

	}

	public void setLevel() {
		flopMotor.set(1);
	}

	public void setUp() {
		flopMotor.set(-1);
	}

	public void FlopAdjust(double speed){
		flopMotor.set(speed);
	}


	public void reset() {
		flopMotor.set(0.0);
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand(new FlopWithJoy());
	}

}
