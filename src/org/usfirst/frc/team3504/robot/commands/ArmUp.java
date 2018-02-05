package org.usfirst.frc.team3504.robot.commands;

import org.usfirst.frc.team3504.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ArmUp extends Command {

    public ArmUp() {
    	requires(Robot.gearcollector);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.gearcollector.initializeCounter();
    	SmartDashboard.putString("Arm", "UP");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	System.out.println("Running");
        Robot.gearcollector.armUp();
        Robot.gearcollector.gearstop();
        }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	System.out.println("Done");
    	return false;
    	//        Robot.gearcollector.isSwitchSet();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.gearcollector.armStop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
