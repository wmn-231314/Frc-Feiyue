package org.usfirst.frc.team3504.robot.subsystems;

import org.usfirst.frc.team3504.robot.RobotMap;
import org.usfirst.frc.team3504.robot.commands.DriveByJoystick;
import com.kauailabs.navx.frc.AHRS;

import com.ctre.CANTalon;

//import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.PIDController;
//import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Chassis extends Subsystem /*implements PIDOutput*/ {
	public CANTalon rightmotor;
	private CANTalon rightslavera;
	private CANTalon rightslaverb;
	public CANTalon leftmotor;
	private CANTalon leftslavera;
	private CANTalon leftslaverb;
	public RobotDrive robotDrive;
	
	public PIDController turnController;
	public AHRS ahrs;
	/*private int kToleranceDegrees;
	private double rotatToAngleRate;*/

	
	
	public Chassis(){
		rightmotor = new CANTalon(RobotMap.RIGHTMOTOR);
		rightslavera = new CANTalon(RobotMap.RIGHTSLAVERA);
		rightslaverb = new CANTalon(RobotMap.RIGHTSLAVERB);
		rightslavera.changeControlMode(CANTalon.TalonControlMode.Follower);
		rightslaverb.changeControlMode(CANTalon.TalonControlMode.Follower);
		rightslavera.set(rightmotor.getDeviceID());
		rightslaverb.set(rightmotor.getDeviceID());
		leftmotor = new CANTalon(RobotMap.LEFTMOTOR);
		leftslavera = new CANTalon(RobotMap.LEFTSLAVERA);
		leftslaverb = new CANTalon(RobotMap.LEFTSLAVERB);
		leftslavera.changeControlMode(CANTalon.TalonControlMode.Follower);
		leftslaverb.changeControlMode(CANTalon.TalonControlMode.Follower);
		leftslavera.set(leftmotor.getDeviceID());
		leftslaverb.set(leftmotor.getDeviceID());
		rightmotor.enableBrakeMode(true);
		rightslavera.enableBrakeMode(true);
		rightslaverb.enableBrakeMode(true);	
		leftmotor.enableBrakeMode(true);
		leftslavera.enableBrakeMode(true);
		leftslaverb.enableBrakeMode(true);
		
		
		leftmotor.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
	/*  leftmotor.configEncoderCodesPerRev(2560);
		leftmotor.reverseOutput(false);
		leftmotor.reverseSensor(false);  keep sensor and motor in phase 
		leftmotor.setPosition(0); // Not necessary, but convenient for debugging
		leftmotor.setF(1.0);
		leftmotor.setP(3.25);
		leftmotor.setI(0);
		leftmotor.setD(0);*/
		
		rightmotor.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
	/*  rightmotor.configEncoderCodesPerRev(2560);
		rightmotor.reverseOutput(false);
		rightmotor.reverseSensor(false);  keep sensor and motor in phase 
		rightmotor.setPosition(0); // Not necessary, but convenient for debugging
		rightmotor.setF(1.0);
		rightmotor.setP(3.25);
		rightmotor.setI(0);
		rightmotor.setD(0);*/
		
		//leftmotor.reverseOutput(true);
		
		
		robotDrive = new RobotDrive(leftmotor, rightmotor);
	//	robotDrive.setSafetyEnabled(true);
		robotDrive.setExpiration(0.5);
		robotDrive.setSensitivity(0.1);
		robotDrive.setMaxOutput(1.0);
		
		
		/*try {
			ahrs = new AHRS(SPI.Port.kMXP);
		} catch (RuntimeException ex ) {
			DriverStation.reportError("Error instantiating navX MXP:  " + ex.getMessage(), true);
		}
		turnController = new PIDController(0.03, 0.00, 0.00, 0.00, ahrs, this);
		turnController.setInputRange(	-180.0f,  180.0f);
		turnController.setOutputRange(-1.0, 1.0);
		turnController.setAbsoluteTolerance(kToleranceDegrees);
		turnController.setContinuous(true);
		turnController.enable();
*/

	
		
	}
		
	/*public void pidWrite(double output) {
		rotatToAngleRate = output;
	}

	public double getRotationAngleRate() {
		return rotatToAngleRate;
	}*/
	

	public void driveByJoystick(double xDir, double yDir){
		SmartDashboard.putString("driveByJoystick?", xDir + "," + yDir);
		robotDrive.arcadeDrive(yDir,xDir,true);
	}
	public void stop() {
		leftmotor.set(0.0);
		rightmotor.set(0.0);
		//robotDrive.drive(0, 0);
	}
	
	public void driveforward(){
		robotDrive.arcadeDrive(0.6 , 0.0);
	}
	
	public void drivebackward(){
		robotDrive.arcadeDrive(-0.6 , 0.0);
	}

	public void rotate(){
		robotDrive.arcadeDrive(0.0, 0.2);
	}
	
   /* public void MoveByJoystick(double x ,double y){
    	
		
		
		
	}
*/
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	setDefaultCommand(new DriveByJoystick());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

