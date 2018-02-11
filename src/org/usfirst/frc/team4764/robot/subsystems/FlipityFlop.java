package org.usfirst.frc.team4764.robot.subsystems;

import org.usfirst.frc.team4764.robot.RobotMap;


import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class FlipityFlop extends Subsystem {
	
	Solenoid level= new Solenoid(RobotMap.solenoidlevel);
	Solenoid down = new Solenoid(RobotMap.solenoiddown);
	

	public FlipityFlop() {
		
		level.set(true);
		down.set(true);
		

	}
	



	public void Gripperlevel() {
		level.set(false);
	}
		
		
		
	    

	
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