package org.usfirst.frc.team3504.robot.commands;

import org.usfirst.frc.team3504.robot.PIDProcessor;
import org.usfirst.frc.team3504.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveByDistance extends Command {
	/*PIDProcessor pidprocessor;
	private double kP = 0.0003;
	private double kI = 0.00;
	private double kD = 0.00;
	private static double p = (10*Math.PI)/1024;
	private double distance, start;
//	public double start;
	
    public DriveByDistance(double distance) {
    	requires(Robot.chassis);
    	this.distance = distance * p;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	pidprocessor = new PIDProcessor(kP, kI, kD, distance);
    	System.out.println("initialize");
    	start = Robot.chassis.rightmotor.getEncPosition();
    	pidprocessor.setThreshold(200.0, 200.0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double input 	= Robot.chassis.rightmotor.getEncPosition() - start;
    	double output 	=  - pidprocessor.outputNormal(input);
    	Robot.chassis.robotDrive.arcadeDrive(output, 0.0);
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
//    	System.out.println("not");
        return pidprocessor.checkDone();
    }

    // Called once after isFinished returns true
    protected void end() {
    	System.out.println("finished");
    	Robot.chassis.robotDrive.stopMotor();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }*/
    
    private PIDProcessor pidprocessor;
	private double kP = 0.0005;
	private double kI = 0.00;
	private double kD = 0.002;
	//private static double p = (10*Math.PI)/1024;
	private double distance, start;
//	public double start;
	
    public DriveByDistance(double distance) {
    	requires(Robot.chassis);
    	this.distance = distance;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	pidprocessor = new PIDProcessor(kP, kI, kD, distance);
    	System.out.println("initialize");
    	start = Robot.chassis.rightmotor.getEncPosition();
    	pidprocessor.setThreshold(200.0, 200.0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double input 	= Robot.chassis.rightmotor.getEncPosition() - start;
    	double output 	=  - pidprocessor.outputNormal(input);
    	Robot.chassis.robotDrive.arcadeDrive(output, 0.0);
    	/*Robot.chassis.leftmotor.set(output);
    	Robot.chassis.rightmotor.set(output);*/
    	//System.out.println(input);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
//    	System.out.println("not");
        return pidprocessor.checkDone();
    }

    // Called once after isFinished returns true
    protected void end() {
    	System.out.println("finished");
    	Robot.chassis.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
