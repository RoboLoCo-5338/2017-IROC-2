package org.usfirst.frc.team5338.robot.commands;

import org.usfirst.frc.team5338.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TurnAround extends Command {
	int seconds;
	float start;

    public TurnAround(int input) {
    		requires(Robot.drivetrain);
    		seconds = input;
		setTimeout(Math.abs(seconds));
		start = Robot.ahrs.getYaw();
    }


    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    		if(start < 0) {
    			while(Robot.ahrs.getYaw() != (180+start)) {
    				Robot.drivetrain.drive(0.5,-0.5);
    			}
    		}
    		else if(start > 0) {
    			while(Robot.ahrs.getYaw() != (-180+start)) {
    				Robot.drivetrain.drive(0.5,-0.5);
    			}
    		}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    		Robot.drivetrain.drive(0.0, 0.0);
    }

}
