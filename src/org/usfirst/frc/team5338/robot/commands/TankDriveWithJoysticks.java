package org.usfirst.frc.team5338.robot.commands;

import org.usfirst.frc.team5338.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class TankDriveWithJoysticks extends Command {
	public TankDriveWithJoysticks() {
		requires(Robot.drivetrain);
	}

	protected void execute() {
		Robot.drivetrain.drive(Robot.oi);
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Robot.drivetrain.drive(0.0, 0.0, 0.0, 0.0);
	}
}