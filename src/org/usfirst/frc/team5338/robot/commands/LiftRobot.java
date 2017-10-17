package org.usfirst.frc.team5338.robot.commands;

import org.usfirst.frc.team5338.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class LiftRobot extends Command {
	public LiftRobot() {
		requires(Robot.climber);
	}

	@Override
	protected void execute() {
		Robot.climber.liftRobot(Robot.oi);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		Robot.climber.stopLift();
	}
}