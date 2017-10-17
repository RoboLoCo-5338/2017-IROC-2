package org.usfirst.frc.team5338.robot.commands;

import org.usfirst.frc.team5338.robot.Robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Move extends Command {
	int seconds;

	public Move(int input) {
		super();
		Robot.drivetrain.shiftMode(DoubleSolenoid.Value.kReverse);
		seconds = input;
		requires(Robot.drivetrain);
		setTimeout(Math.abs(seconds));
	}

	/*protected void initialize() {
		
		
		//Robot.gearhandler.setGears(DoubleSolenoid.Value.kReverse);
		//Robot.gearhandler.wheelMover.set(-0.3);
	}*/

	protected void execute() {
		SmartDashboard.putNumber("moveSeconds", seconds);
		
		if (seconds > 0) {
			Robot.drivetrain.driveTrain.tankDrive(-0.25, -0.25);
		} else {
			Robot.drivetrain.driveTrain.tankDrive(0.25, 0.25);
		}
		
		

	}

	protected boolean isFinished() {
		return isTimedOut();
	}

	protected void end() {
		Robot.drivetrain.driveTrain.tankDrive(0.0, 0.0);
	}
}
