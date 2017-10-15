package org.usfirst.frc.team5338.robot.subsystems;

import org.usfirst.frc.team5338.robot.OI;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearHandler extends Subsystem {
   
	private final DoubleSolenoid gearSolenoid = new DoubleSolenoid(5,6);
	private final Victor wheelMover = new Victor(5);
	
	public GearHandler() {
		super();
	}

    public void initDefaultCommand() {
        
    }
    
    public void handleGears(OI oi) {
    		if(oi.get(OI.Button.GEAROUTPUT)) {
    			wheelMover.set(0.9);
    			gearSolenoid.set(DoubleSolenoid.Value.kForward);
    		}
    		else if(oi.get(OI.Button.GEARINTAKE)) {
    			gearSolenoid.set(DoubleSolenoid.Value.kForward);
    			wheelMover.set(-0.9);
    		}
    		else {
    			gearSolenoid.set(DoubleSolenoid.Value.kReverse);
    			wheelMover.set(-0.3);
    		}
    }
    
    public void setGears(DoubleSolenoid.Value setting) {
    		gearSolenoid.set(setting);
    }
}

