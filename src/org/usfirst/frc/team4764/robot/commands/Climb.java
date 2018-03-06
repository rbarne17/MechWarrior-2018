package org.usfirst.frc.team4764.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Climb extends CommandGroup {

	public Climb() {
		new FlipityFlopUp();
		new Lift(40.0, .5);
		new LiftHome(.5);
	}
}
