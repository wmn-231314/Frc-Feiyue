package org.usfirst.frc.team3504.robot.subsystems;

import org.usfirst.frc.team3504.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shifter extends Subsystem {
	private DoubleSolenoid shifterLeft;
	private DoubleSolenoid shifterRight;
	private Speed speed;
	
	
	public enum Speed {
		kHigh, kLow
	};
	
	public Shifter(){
		shifterLeft = new DoubleSolenoid(0,RobotMap.SHIFTER_LEFT_A, RobotMap.SHIFTER_LEFT_B);
		shifterRight = new DoubleSolenoid(0,RobotMap.SHIFTER_RIGHT_A, RobotMap.SHIFTER_RIGHT_B);

	}
	
	
	public void shiftGear(Speed speed) {
		this.speed = speed;
		if (speed == Speed.kHigh) {
			shifterLeft.set(DoubleSolenoid.Value.kForward);
			shifterRight.set(DoubleSolenoid.Value.kReverse);
			System.out.println("Shifting left and right side into high gear (rev)");
		} else {
			shifterLeft.set(DoubleSolenoid.Value.kReverse);
			shifterRight.set(DoubleSolenoid.Value.kForward);
			System.out.println("Shifting left and right side into low gear (fwd)");
		}
	}

	public Speed getGearSpeed() {
		return speed;
	}




    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

