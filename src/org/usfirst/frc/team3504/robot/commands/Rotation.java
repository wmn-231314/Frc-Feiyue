package org.usfirst.frc.team3504.robot.commands;

import org.usfirst.frc.team3504.robot.PIDProcessor;
import org.usfirst.frc.team3504.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
import org.usfirst.frc.team3504.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Rotation extends Command {
	private PIDProcessor pidprocessor;
	private double kP = 0.0005;
	private double kI = 0.00;
	private double kD = 0.002;
	private double distance, start;

    public Rotation(double distance) {
    	requires(Robot.chassis);
    	this.distance = distance;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	pidprocessor = new PIDProcessor(kP, kI, kD, distance);
    	start = Robot.chassis.rightmotor.getEncPosition();
    	pidprocessor.setThreshold(200.0, 200.0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double input 	= Robot.chassis.rightmotor.getEncPosition() - start;
    	double output 	= pidprocessor.outputNormal(input);
    	Robot.chassis.robotDrive.arcadeDrive(output, 1);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return pidprocessor.checkDone();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.chassis.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
