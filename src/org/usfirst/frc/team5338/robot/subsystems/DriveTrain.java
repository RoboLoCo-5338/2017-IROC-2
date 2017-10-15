package org.usfirst.frc.team5338.robot.subsystems;

import org.usfirst.frc.team5338.robot.OI;
import org.usfirst.frc.team5338.robot.Robot;
import org.usfirst.frc.team5338.robot.commands.TankDriveWithJoysticks;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveTrain extends Subsystem {
	// Creates the four CANTalon motor controller objects.
	private final CANTalon LEFT1 = new CANTalon(1);
	private final CANTalon LEFT2 = new CANTalon(2);
	private final CANTalon RIGHT1 = new CANTalon(3);
	private final CANTalon RIGHT2 = new CANTalon(4);
	private final Compressor driveCompressor = new Compressor();
	private final DoubleSolenoid driveSolenoid = new DoubleSolenoid(1,2);
	public RobotDrive driveTrain = new RobotDrive(LEFT1,LEFT2,RIGHT1,RIGHT2);
	private boolean shift;
	private double turn, speed, left, right;
	
	// DriveTrain object constructor which reverses output of backwards motors.
	public DriveTrain() {
		super();
		//LEFT1.setInverted(true);
		//LEFT2.setInverted(true);
		driveCompressor.setClosedLoopControl(true);
		driveCompressor.start();
		driveSolenoid.set(DoubleSolenoid.Value.kReverse);
		shift = false;
		
	}

	// Sets the default command to run during teleop to joystick driving.
	public void initDefaultCommand() {
		setDefaultCommand(new TankDriveWithJoysticks());
	}

	// Gets joysticks input and calls the drive function with arguments.
	public void drive(OI oi) {
		//gets the position of both controllers
		switch(SmartDashboard.getString("TYPE OF DRIVE", "")) {
			case "TANK":
				left = Robot.oi.getLeft('Y')*Math.abs(Robot.oi.getLeft('Y'));
				right = Robot.oi.getRight('Y')*Math.abs(Robot.oi.getRight('Y'));
						
				driveTrain.tankDrive(-left, -right);
				
				if(shift) turn*=.7;
				break;
				
			case "ARCADEX":
				 turn = -Robot.oi.getLeft('X')*Math.abs(Robot.oi.getLeft('X'));
				 speed = -Robot.oi.getLeft('Y')*Math.abs(Robot.oi.getLeft('Y'));
				
				if(shift) turn *= .7;
						
				driveTrain.arcadeDrive(speed,turn);
				break;
			case "ARCADEZ":
				 turn = -Robot.oi.getLeft('Z')*Math.abs(Robot.oi.getLeft('Z'));
				 speed = -Robot.oi.getLeft('Y')*Math.abs(Robot.oi.getLeft('Y'));
				
				if(shift) turn *= .7;
						
				driveTrain.arcadeDrive(speed,turn);
				break;
			default:
				driveTrain.tankDrive(0, 0);
				break;
		}
		
		if(Robot.oi.get(OI.Button.SHIFTUP)) {
			driveSolenoid.set(DoubleSolenoid.Value.kForward);
			shift = true;
		}
		if(Robot.oi.get(OI.Button.SHIFTDOWN)){
			driveSolenoid.set(DoubleSolenoid.Value.kReverse);
			shift = false;
		}
		
		
	}
	

}