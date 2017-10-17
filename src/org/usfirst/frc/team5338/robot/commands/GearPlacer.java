package org.usfirst.frc.team5338.robot.commands;
  
import org.usfirst.frc.team5338.robot.Robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
  
/**
 *
 */
public class GearPlacer extends Command {
	

    public GearPlacer() {
    		requires(Robot.drivetrain);
    		requires(Robot.gearhandler);
        setTimeout(2);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    		Robot.gearhandler.setGears(DoubleSolenoid.Value.kForward);
    		Robot.gearhandler.wheelMover.set(0.9);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    		Robot.drivetrain.driveTrain.tankDrive(0.0, 0.0);
    		Robot.gearhandler.setGears(DoubleSolenoid.Value.kReverse);
    }

    
}
