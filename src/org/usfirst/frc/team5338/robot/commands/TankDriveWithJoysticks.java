package org.usfirst.frc.team5338.robot.commands;

import org.usfirst.frc.team5338.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class TankDriveWithJoysticks extends Command {
	// TankDriveWithJoysticks object constructor requires the drivetrain for the
	// command.
	public TankDriveWithJoysticks() {
		requires(Robot.drivetrain);
	}

	// Calls the drive function the with OI argument repeatedly when the command is
	// active.
	protected void execute() {
		Robot.drivetrain.drive(Robot.oi);
	}

	// Will never return true as the command will never end for the duration of
	// teleop.
	protected boolean isFinished() {
		return false;
	}
}