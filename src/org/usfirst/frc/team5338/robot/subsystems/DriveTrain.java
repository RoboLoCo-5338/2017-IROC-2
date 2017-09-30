package org.usfirst.frc.team5338.robot.subsystems;

import org.usfirst.frc.team5338.robot.OI;
import org.usfirst.frc.team5338.robot.Robot;
import org.usfirst.frc.team5338.robot.commands.TankDriveWithJoysticks;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.RobotDrive;
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
	RobotDrive driveTrain = new RobotDrive(LEFT1,LEFT2,RIGHT1,RIGHT2);

	// DriveTrain object constructor which reverses output of backwards motors.
	public DriveTrain() {
		super();
		//LEFT1.setInverted(true);
		//LEFT2.setInverted(true);
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
		double turn = -Robot.oi.getLeft('X');
		double speed = -Robot.oi.getLeft('Y');
		
		driveTrain.arcadeDrive(speed,turn);
		
		if(Robot.oi.get(OI.Button.SHIFTUP)) {
			driveSolenoid.set(DoubleSolenoid.Value.kReverse);
		}
		if(Robot.oi.get(OI.Button.SHIFTDOWN)){
			driveSolenoid.set(DoubleSolenoid.Value.kForward);
		}
		
	}

	// Sets output on pairs of CANTalons based on the double arguments.
	

}