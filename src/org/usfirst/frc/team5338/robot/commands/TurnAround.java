package org.usfirst.frc.team5338.robot.commands;

import org.usfirst.frc.team5338.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.PIDCommand;

/**
 *
 */
public class TurnAround extends PIDCommand {

	float start;
	int angle;
	double target;

    public TurnAround(int input) {
    		super(0.5, 0.5, 0.5, 0.005);
    		requires(Robot.drivetrain);
    		getPIDController().setOutputRange(-0.425, 0.425);
    		getPIDController().setInputRange(-180.0, 180.0);
    		getPIDController().setContinuous();
    		//Initializes the drivetrain in the command
    		requires(Robot.drivetrain);
    		//Gets the current angle (or direction) that the robot is facing
		start = Robot.ahrs.getYaw();
		angle = input;
		//Using modulus and addition to determine the target angle (like a clock)
		target = (start - angle);
		if(target > 180) {
			setSetpoint(-180 + target % 180);
		}
		else {
			setSetpoint(target);
		}
		setTimeout(20);
    }


    // Called repeatedly when this Command is scheduled to run
   /* protected void execute() {
    			//continuously turns the robot
    			Robot.drivetrain.drive(-0.25,0.25);
    		}*/

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    		//asks the execute to stop when the robot has turned to the target angle
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    		Robot.drivetrain.drive(0.0, 0.0);
    }
    protected double returnPIDInput() {
    		return Robot.ahrs.getYaw();
    }
    protected void usePIDOutput(double output) {
    		Robot.drivetrain.drive(-output, output);
    }
}
