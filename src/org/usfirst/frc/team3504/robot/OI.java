package org.usfirst.frc.team3504.robot;

import org.usfirst.frc.team3504.robot.commands.ArmDown;
import org.usfirst.frc.team3504.robot.commands.ArmUp;
import org.usfirst.frc.team3504.robot.commands.Climb;
import org.usfirst.frc.team3504.robot.commands.ClimbDown;
import org.usfirst.frc.team3504.robot.commands.ClimbStop;
import org.usfirst.frc.team3504.robot.commands.HangGears;
import org.usfirst.frc.team3504.robot.commands.Shiftdown;
import org.usfirst.frc.team3504.robot.commands.Shiftup;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	Joystick joystick1 = new Joystick(RobotMap.JOYSTICK_PORT);
	Joystick joystick2 = new Joystick(RobotMap.JOYSTICK_PORTB);
	Button buttonA1 = new JoystickButton(joystick1,1);
	Button buttonA2 = new JoystickButton(joystick1,2);
	Button buttonA3 = new JoystickButton(joystick1,3);
	Button button1 = new JoystickButton(joystick2,1);
	Button button2 = new JoystickButton(joystick2,2);
	Button button3 = new JoystickButton(joystick2,3);
	Button button4 = new JoystickButton(joystick2,4);
	Button button5 = new JoystickButton(joystick2,5);
	Button button6 = new JoystickButton(joystick2,6);
	Button button7 = new JoystickButton(joystick2,7);
	Button button8 = new JoystickButton(joystick2,8);
	
	
	public OI(){
		buttonA1.whenPressed(new Shiftdown());
		buttonA2.whenPressed(new Shiftup());
		button1.whenPressed(new ArmDown());
		button2.whenPressed(new ArmUp());
		//button7.whenPressed(new DriveByDistance(2.0));
		button3.whenPressed(new HangGears());
		button5.whenPressed(new Climb());
		button5.whenReleased(new ClimbStop());
		button6.whenPressed(new ClimbDown());
		button6.whenReleased(new ClimbStop());
	}	
	
	public double getX(){
		return joystick1.getX();
	}
	public double getY(){
		return joystick1.getY();
	}
	
 	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
}
