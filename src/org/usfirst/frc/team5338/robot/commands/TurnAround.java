package org.usfirst.frc.team5338.robot.commands;

import org.usfirst.frc.team5338.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TurnAround extends Command {

	float start;
	int angle;
	double target;

    public TurnAround(int input) {
    		requires(Robot.drivetrain);
		start = Robot.ahrs.getYaw();
		angle = input;
		target = ((start - angle)+360)%360;
    }


    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    			Robot.drivetrain.drive(-0.25,0.25);
    		}

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (Robot.ahrs.getYaw()+360)%360 > target;
    }

    // Called once after isFinished returns true
    protected void end() {
    		Robot.drivetrain.drive(0.0, 0.0);
    }
}
