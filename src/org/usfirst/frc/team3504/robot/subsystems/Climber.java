package org.usfirst.frc.team3504.robot.subsystems;

import org.usfirst.frc.team3504.robot.RobotMap;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem {
	public CANTalon climbermotor;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public Climber(){
		climbermotor = new CANTalon(RobotMap.CLIMBERMOTOR);
	}
	
	public void climb(double power){
		climbermotor.set(power);
	}
	
	public void stop(){
		climbermotor.set(0.0);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

