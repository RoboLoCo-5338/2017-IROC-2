package org.usfirst.frc.team5338.robot.subsystems;

import org.usfirst.frc.team5338.robot.OI;
import org.usfirst.frc.team5338.robot.commands.TankDriveWithJoysticks;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem {
	private final CANTalon LEFT1 = new CANTalon(1);
	private final CANTalon LEFT2 = new CANTalon(2);
	private final CANTalon RIGHT1 = new CANTalon(3);
	private final CANTalon RIGHT2 = new CANTalon(4);

	public DriveTrain() {
		super();
	}

	public void initDefaultCommand() {
		setDefaultCommand(new TankDriveWithJoysticks());
	}

	public void drive(OI oi) {
		// TODO
	}

	public void drive(double left1, double left2, double right1, double right2) {
		LEFT1.set(left1);
		LEFT2.set(left2);
		RIGHT1.set(right1);
		RIGHT2.set(right2);
	}
}