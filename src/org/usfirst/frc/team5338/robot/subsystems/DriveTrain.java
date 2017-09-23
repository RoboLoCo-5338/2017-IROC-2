package org.usfirst.frc.team5338.robot.subsystems;

import org.usfirst.frc.team5338.robot.OI;
import org.usfirst.frc.team5338.robot.Robot;
import org.usfirst.frc.team5338.robot.commands.TankDriveWithJoysticks;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem {
	// Creates the four CANTalon motor controller objects.
	private final CANTalon LEFT1 = new CANTalon(1);
	private final CANTalon LEFT2 = new CANTalon(2);
	private final CANTalon RIGHT1 = new CANTalon(3);
	private final CANTalon RIGHT2 = new CANTalon(4);
	private final Compressor driveCompressor = new Compressor();
	private final DoubleSolenoid driveSolenoid = new DoubleSolenoid(1,2);

	// DriveTrain object constructor which reverses output of backwards motors.
	public DriveTrain() {
		super();
		LEFT1.setInverted(true);
		LEFT2.setInverted(true);
		driveCompressor.setClosedLoopControl(true);
		driveCompressor.start();
	}

	// Sets the default command to run during teleop to joystick driving.
	public void initDefaultCommand() {
		setDefaultCommand(new TankDriveWithJoysticks());
	}

	// Gets joysticks input and calls the drive function with arguments.
	public void drive(OI oi) {
		//gets the position of both controllers
		double left = Robot.oi.getLeft('Y');
		double right = Robot.oi.getRight('Y');
		driveSolenoid.set(DoubleSolenoid.Value.kForward);
		//robot starts in torque mode
		//if the maximum speed is being reached on the torque setting it switches to speed
		if(left == 1 || right == 1) {
			//talon power is decreased to maintain constant speed
			LEFT1.set(0.72549277121);
			LEFT2.set(0.72549277121);
			RIGHT1.set(0.72549277121);
			RIGHT2.set(0.72549277121);
			//setting is changed
			driveSolenoid.set(DoubleSolenoid.Value.kReverse);
		}
		else {
			//talon power is left as is and the setting remains on speed
			driveSolenoid.set(DoubleSolenoid.Value.kForward);
		}
		
		drive(left, right);
	}

	// Sets output on pairs of CANTalons based on the double arguments.
	public void drive(double left, double right) {
		LEFT1.set(left);
		LEFT2.set(left);
		RIGHT1.set(right);
		RIGHT2.set(right);
	}
	public void 
}