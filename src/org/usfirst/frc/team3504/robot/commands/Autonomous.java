package org.usfirst.frc.team3504.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Autonomous extends CommandGroup {

    public Autonomous() {
    	//addSequential(new DriveForward(5000));
    	addSequential(new DriveByDistance(124800));
    	//addParallel(new ArmUp());
    	//addSequential(new Rotation(3000));
    	//addParallel(new ArmDown());
    	//addSequential(new DriveBackward(2000));
    	//addSequential(new Climb());
    	//System.out.println("climb");

    }
}
