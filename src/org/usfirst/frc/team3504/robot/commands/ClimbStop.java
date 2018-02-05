package org.usfirst.frc.team3504.robot.commands;

import org.usfirst.frc.team3504.robot.PIDProcessor;
import org.usfirst.frc.team3504.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ClimbStop extends Command {
	PIDProcessor pidprocessor;
	private double kP = 0.0003;
	private double kI = 0.00;
	private double kD = 0.00;	
    public ClimbStop() {
    	pidprocessor = new PIDProcessor(kP, kI, kD, 0);
    	requires(Robot.climber);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.climber.climbermotor.setEncPosition(0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double input 	= - Robot.climber.climbermotor.getEncPosition();
    	double output 	= pidprocessor.outputNormal(input);
    	Robot.climber.climb(output);
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.climber.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
