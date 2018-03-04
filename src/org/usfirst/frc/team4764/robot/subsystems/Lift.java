package org.usfirst.frc.team4764.robot.subsystems;

import org.usfirst.frc.team4764.robot.RobotMap;
import org.usfirst.frc.team4764.robot.commands.LiftWithJoy;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Lift extends Subsystem {
	public final int m_ticksPerFoot = 166;
	public final int m_ticksPerInch = 14;

	private Spark liftMotor = new Spark(RobotMap.liftMotor);
	private DigitalInput limitSwitch = new DigitalInput(RobotMap.liftLimitSwitchHome);
	private Encoder liftEncoder = new Encoder(RobotMap.liftEncoderChannel1, RobotMap.liftEncoderChannel2, true,
			EncodingType.k4X);
	private double m_ticksToTravel;
	private double m_finalTicks;

	public Lift() {

		liftMotor.set(0.0);

	}

	public int getEncoderLift() {
		// Return Encoder Values Need to be fixed
		return liftEncoder.get();
	}

	// Controls speed and direction of the robot.
	// -1 = full reverse; 1 = full forward
	public void LiftLow(double speed) {
		liftMotor.set(speed);

	}

	public void liftAdjust(double speed) {
		liftMotor.set(speed);

	}

	public boolean liftAtHome() {
		return limitSwitch.get();
	}

	public void reset() {
		liftAdjust(0.0);
		encoderReset();

	}

	private void encoderReset() {
		liftEncoder.reset();
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand(new LiftWithJoy());

	}

}
