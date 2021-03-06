package org.usfirst.frc.team3504.robot.commands;

import org.usfirst.frc.team3504.robot.Robot;
import org.usfirst.frc.team3504.robot.subsystems.Shifter.Speed;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Shiftdown extends Command {

    public Shiftdown() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.shifter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	System.out.println("Shiftdown init");
    	Robot.shifter.shiftGear(Speed.kLow);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.shifter.shiftGear(Speed.kLow);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
