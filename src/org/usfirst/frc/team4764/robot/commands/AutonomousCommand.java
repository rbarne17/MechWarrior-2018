package org.usfirst.frc.team4764.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousCommand extends CommandGroup {

    public AutonomousCommand() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
    
    //possible paths
    //OneLeftSwitch OneLeftSwitchWait OneRightSwitchDefense OneLeftScale OneLeftScaleWait OneRightScaleDefense TwoLeftSwitch TwoLeftSwitchWait TwoLeftSwitchDefense TwoRightSwitch TwoRightSwitchWait TwoRightSwitchDefense TwoLeftScale TwoLeftScaleWait TwoLeftScaleDefense TwoRightScale TwoRightScaleWait TwoRightScaleDefense ThreeRightSwitch ThreeRightSwitchWait ThreeLeftSwitchDefense ThreeRightScale ThreeRightScaleWait ThreeLeftScaleDefense

public AutonomousCommand(String AutonomousCommandName) {
	switch(AutonomousCommandName) {
	case "OneLeftSwitch": ; break;
	case "OneLeftSwitchWait": ; break;
	case "OneRightSwitchDefense": ; break;
	case "OneLeftScale": ; break;
	case "OneLeftScaleWait": ; break;
	case "OneRightScaleDefense": ; break;
	case "TwoLeftSwitch": ; break;
	case "TwoLeftSwitchWait": ; break;
	case "TwoLeftSwitchDefense": ; break;
	case "TwoRightSwitch": ; break;
	case "TwoRightSwitchWait": ; break;
	case "TwoRightSwitchDefense": ; break;
	case "TwoLeftScale": ; break;
	case "TwoLeftScaleWait": ; break;
	case "TwoLeftScaleDefense": ; break;
	case "TwoRightScale": ; break;
	case "TwoRightScaleWait": ; break;
	case "TwoRightScaleDefense": ; break;
	case "ThreeRightSwitch": ; break;
	case "ThreeRightSwitchWait": ; break;
	case "ThreeLeftSwitchDefense": ; break;
	case "ThreeRightScale": ; break;
	case "ThreeRightScaleWait": ; break;
	case "ThreeLeftScaleDefense": ; break;
	default: ; break;
	}
	}
}
