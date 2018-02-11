package org.usfirst.frc.team4764.robot.subsystems;

import org.usfirst.frc.team4764.robot.RobotMap;


import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class FlipityFlop extends Subsystem {
	Relay gripperRelay = new Relay(RobotMap.gripper);
	Solenoid level= new Solenoid(RobotMap.solenoidlevel);
	Solenoid down = new Solenoid(RobotMap.solenoiddown);
	

	public FlipityFlop() {
		
		level.set(true);
		down.set(true);
		

	}
	


	//Drives the robot using s inputs for the left and right side motors.
	//Inputs are percentages of maxeperateimum motor output.
	public void Gripperlevel() {
		level.set(false);
	}
		
		
		
	    

	//Controls speed and direction of the robot.
	// -1 = full reverse; 1 = full forward
	public void Gripperdown() {
		down.set(false);
		
		}
	
	public void doNothing () 
	{
		level.set(true);
		down.set(true);

	}
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	
	
}