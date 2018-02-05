package org.usfirst.frc.team3504.robot.commands;

import org.usfirst.frc.team3504.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class HangGears extends Command {

    public HangGears() {
    	requires(Robot.gearcollector);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.gearcollector.initializeCounter();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.gearcollector.armDown();
    	Robot.gearcollector.gearout();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.gearcollector.gearcollectorA.isRevLimitSwitchClosed();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.gearcollector.armStop();
    	Robot.gearcollector.gearstop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
