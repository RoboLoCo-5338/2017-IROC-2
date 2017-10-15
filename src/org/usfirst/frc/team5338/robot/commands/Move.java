package org.usfirst.frc.team5338.robot.commands;

import org.usfirst.frc.team5338.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Move extends Command {
	int seconds;
	public Move(int input) {
		requires(Robot.drivetrain);
		setTimeout(Math.abs(seconds));
		seconds = input;
	}

	protected void execute() {
		if(seconds > 0) {
			Robot.drivetrain.driveTrain.tankDrive(0.25,0.25);
		}
		else {
			Robot.drivetrain.driveTrain.tankDrive(0,0);
		}
		
	}

	protected boolean isFinished() {
		return isTimedOut();
	}

	protected void end() {
		Robot.drivetrain.driveTrain.tankDrive(0.0, 0.0);
	}
}
