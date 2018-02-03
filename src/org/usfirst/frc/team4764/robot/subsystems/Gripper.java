package org.usfirst.frc.team4764.robot.subsystems;

import org.usfirst.frc.team4764.robot.RobotMap;


import edu.wpi.first.wpilibj.Relay;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Gripper extends Subsystem {
	Relay gripperRelay = new Relay(RobotMap.gripper);
	

	public Gripper() {
		
		gripperRelay.set(Relay.Value.kOff);
		

	}
	


	//Drives the robot using s inputs for the left and right side motors.
	//Inputs are percentages of maxeperateimum motor output.
	public void Gripperopen() {
		gripperRelay.set(Relay.Value.kForward);
	}
		
		
		
	    

	//Controls speed and direction of the robot.
	// -1 = full reverse; 1 = full forward
	public void Gripperclose() {
		gripperRelay.set(Relay.Value.kReverse);
		
		}
	
	public void doNothing () 
	{
		gripperRelay.set(Relay.Value.kOff);

	}
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	
	
}