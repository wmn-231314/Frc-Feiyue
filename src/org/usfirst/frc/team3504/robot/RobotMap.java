package org.usfirst.frc.team3504.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static final int JOYSTICK_PORT = 0;
	public static final int JOYSTICK_PORTB = 1;
	
	public static final int RIGHTMOTOR = 7;
	public static final int RIGHTSLAVERA = 6;
	public static final int RIGHTSLAVERB = 5;
	
	public static final int LEFTMOTOR = 8;
	public static final int LEFTSLAVERA = 9;
	public static final int LEFTSLAVERB = 10;
	
	public static final int COLLECTORMOTORA = 3;
	public static final int COLLECTIONMOTORB = 2;
	
	public static final int CLIMBERMOTOR = 11;
	
	public static final int SHOTTERA = 10;
	public static final int SHOOTERB = 11;
	
	public static final int TRANSFER = 12;
	
	public static final int SHIFTER_LEFT_A = 0;
	public static final int SHIFTER_RIGHT_A = 3;
	public static final int SHIFTER_LEFT_B = 1;
	public static final int SHIFTER_RIGHT_B = 2;
	
	public static final int SOLENOID_FWD_CHANNEL = 5;
	public static final int SOLENOID_BWD_CHANNEL = 4;
	
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
