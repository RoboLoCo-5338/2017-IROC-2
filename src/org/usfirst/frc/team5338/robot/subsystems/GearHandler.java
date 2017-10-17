package org.usfirst.frc.team5338.robot.subsystems;

import org.usfirst.frc.team5338.robot.OI;
import org.usfirst.frc.team5338.robot.Robot;
import org.usfirst.frc.team5338.robot.commands.HandleGears;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearHandler extends Subsystem {

	private final DoubleSolenoid gearSolenoid = new DoubleSolenoid(5, 6);
    public Victor wheelMover = new Victor(0);

	public GearHandler() {
		super();
		gearSolenoid.set(DoubleSolenoid.Value.kForward);
	}

	public void initDefaultCommand() {
		setDefaultCommand(new HandleGears());
	}

	public void handleGears(OI oi) {

		if (Robot.oi.get(OI.Button.GEAROUTPUT)) {
			gearSolenoid.set(DoubleSolenoid.Value.kForward);
			wheelMover.set(0.9);
		} else if (Robot.oi.get(OI.Button.GEARINTAKE)) {
			gearSolenoid.set(DoubleSolenoid.Value.kForward);
			wheelMover.set(-0.9);
		} else {
			gearSolenoid.set(DoubleSolenoid.Value.kReverse);
			wheelMover.set(-0.3);
		}

	}

	public void setGears(DoubleSolenoid.Value setting) {
		gearSolenoid.set(setting);
	}
}
