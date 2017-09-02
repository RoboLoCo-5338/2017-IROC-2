package org.usfirst.frc.team5338.robot.subsystems;

import org.usfirst.frc.team5338.robot.OI;
import org.usfirst.frc.team5338.robot.Robot;
import org.usfirst.frc.team5338.robot.commands.TankDriveWithJoysticks;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem {
	// Creates the four CANTalon motor controller objects.
	private final CANTalon LEFT1 = new CANTalon(1);
	private final CANTalon LEFT2 = new CANTalon(2);
	private final CANTalon RIGHT1 = new CANTalon(3);
	private final CANTalon RIGHT2 = new CANTalon(4);

	// DriveTrain object constructor which reverses output of backwards motors.
	public DriveTrain() {
		super();
		LEFT1.setInverted(true);
		LEFT2.setInverted(true);
	}

	// Sets the default command to run during teleop to joystick driving.
	public void initDefaultCommand() {
		setDefaultCommand(new TankDriveWithJoysticks());
	}

	// Gets joysticks input and calls the drive function with arguments.
	public void drive(OI oi) {
		double left = Robot.oi.getLeft('Y');
		double right = Robot.oi.getRight('Y');
		drive(left, right);
	}

	// Sets output on pairs of CANTalons based on the double arguments.
	public void drive(double left, double right) {
		LEFT1.set(left);
		LEFT2.set(left);
		RIGHT1.set(right);
		RIGHT2.set(right);
	}
}