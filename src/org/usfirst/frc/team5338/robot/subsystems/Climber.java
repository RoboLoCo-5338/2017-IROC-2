package org.usfirst.frc.team5338.robot.subsystems;

import org.usfirst.frc.team5338.robot.OI;
import org.usfirst.frc.team5338.robot.Robot;
import org.usfirst.frc.team5338.robot.commands.LiftRobot;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Climber extends Subsystem {
	
	private final Victor lift = new Victor(2);

	public Climber() {
		super();
	}

	public void initDefaultCommand() {
		setDefaultCommand(new LiftRobot());
	}

	public void liftRobot(OI oi) {
		if (Robot.oi.get(OI.Button.CLIMBER) && Robot.oi.get(OI.Button.CLIMBERSLOW)) {
			lift.set(-0.25);
		} else if (oi.get(OI.Button.CLIMBER)) {
			lift.set(-0.99);
		} else {
			stopLift();
		}
	}

	public void stopLift() {
		lift.set(0.0);
	}
}