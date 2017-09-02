package org.usfirst.frc.team5338.robot;

import org.usfirst.frc.team5338.robot.commands.Autonomous;
import org.usfirst.frc.team5338.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

public class Robot extends IterativeRobot {
	// Creates the OI and DriveTrain objects.
	public static final OI oi = new OI();
	public static final DriveTrain drivetrain = new DriveTrain();

	// Creates the Command object for the autonomous.
	public static final Command Autonomous = new Autonomous();

	// Robot object constructor.
	public void robotInit() {
	}

	// Called at the start of the autonomous activating the command.
	public void autonomousInit() {
		Autonomous.start();
	}

	// Periodically called to run the autonomous command.
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	// Called at the start of the teleop ending the autonomous command.
	public void teleopInit() {
		try {
			Autonomous.cancel();
		} catch (Exception e) {
		}
	}

	// Periodically called to run default commands in teleop.
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}
}
