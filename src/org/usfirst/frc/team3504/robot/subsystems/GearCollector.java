package org.usfirst.frc.team3504.robot.subsystems;

import org.usfirst.frc.team3504.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearCollector extends Subsystem {
	private CANTalon gearcollectorB;
	public CANTalon gearcollectorA;
	DigitalInput limitSwitch = new DigitalInput(RobotMap.COLLECTORMOTORA);
	Counter counter = new Counter(limitSwitch);
	
	public GearCollector(){
		gearcollectorB = new CANTalon(RobotMap.COLLECTIONMOTORB);
		gearcollectorA = new CANTalon(RobotMap.COLLECTORMOTORA);
		gearcollectorB.enableBrakeMode(true);
		gearcollectorA.enableBrakeMode(true);
	}
	
	public boolean isSwitchSet() {
        return counter.get() > 0;
    }

    public void initializeCounter() {
        counter.reset();
    }

    public void armUp() {
        gearcollectorA.set(0.4);
    }

    public void armDown() {
        gearcollectorA.set(-0.1);
    }

    public void armStop() {
        gearcollectorA.set(0.0);
    }
    
    public void gearin(){
    	gearcollectorB.set(1.0);
    }
    
    public void gearout(){
    	gearcollectorB.set(-1.0);
    }
    
    public void gearstop(){
    	gearcollectorB.set(0.0);
    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

