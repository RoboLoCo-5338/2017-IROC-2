package org.usfirst.frc.team5338.robot.subsystems;

import org.usfirst.frc.team5338.robot.OI;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class gearHandler extends Subsystem {
   
	private final DoubleSolenoid gearSolenoid = new DoubleSolenoid(5,6);
	
	public gearHandler() {
		super();
	}

    public void initDefaultCommand() {
        
    }
    
    public void handleGears(OI oi) {
    		if(oi.get(OI.Button.GEARUP)) {
    			gearSolenoid.set(DoubleSolenoid.Value.kForward);
    		}
    		if(oi.get(OI.Button.GEARDOWN)) {
    			gearSolenoid.set(DoubleSolenoid.Value.kReverse);
    		}
    }
    
    public void setGears(DoubleSolenoid.Value setting) {
    		gearSolenoid.set(setting);
    }
}

