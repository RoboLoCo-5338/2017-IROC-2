package org.usfirst.frc.team5338.robot;

import org.usfirst.frc.team5338.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import org.usfirst.frc.team5338.robot.commands.*;

public class Robot extends IterativeRobot {
	public static final OI oi = new OI();
	public static final DriveTrain drivetrain = new DriveTrain();
	public static final Command autonomous = new autonomous();
	public void robotInit() {
	}

	public void autonomousInit() {
			autonomous.start();
	}

	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	public void teleopInit() {
		try {
			autonomous.cancel();
		} catch (Exception e) { 
		}
	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}
}