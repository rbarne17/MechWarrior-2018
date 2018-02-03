package org.usfirst.frc.team4764.robot.subsystems;

import org.usfirst.frc.team4764.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Lift extends Subsystem {
	public Spark liftMotor = new Spark(RobotMap.LiftMotor);
	private Encoder liftEncoder = new Encoder(RobotMap.liftEncoderChannel1, RobotMap.liftEncoderChannel2, true,
			EncodingType.k4X);
	private double _ticksToTravel;
	private double finalticks;


	public Lift() {
		
		liftMotor.set(0.0);
		

	}
	public int getEncoderLift()
	{
		// Return Encoder Values Need to be fixed
		
		return liftEncoder.get();
	}

	


	//Drives the robot using s inputs for the left and right side motors.
	//Inputs are percentages of maxeperateimum motor output.
	public void LiftHigh(double speed) {
		int ticksperrev=4096;
		int radius=4;
		int Inches=10;
		_ticksToTravel= Inches*(ticksperrev/(2*Math.PI*radius));
		finalticks=liftEncoder.get()+_ticksToTravel;
		if(liftEncoder.get()<finalticks){
			liftMotor.set(speed);
		}
		if(liftEncoder.get()>finalticks){
			liftMotor.set(-speed);
		}
		else{
			liftMotor.set(0);
		}
		
		}
		
		
	    

	//Controls speed and direction of the robot.
	// -1 = full reverse; 1 = full forward
	public void LiftLow(double speed) {
		liftMotor.set(speed);
		
		}
		
	
	public void LiftAdjust(double speed) {
		liftMotor.set(speed);
		
	}
	public void doNothing () 
	{
		LiftAdjust(0.0);

	}
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	
	
}