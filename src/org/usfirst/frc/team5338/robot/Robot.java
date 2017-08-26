  import org.usfirst.frc.team5338.robot.commands.Autonomus;
import org.usfirst.frc.team5338.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
  
  public class Robot extends IterativeRobot {
  	public static final OI oi = new OI();
  	public static final DriveTrain drivetrain = new DriveTrain();
 
 	public static final Command Autonomous = new Autonomus();
  	public void robotInit() {
  	}
  
  	public void autonomousInit() {
 			Autonomous.start();
  	}
  
  	public void autonomousPeriodic() {
  		Scheduler.getInstance().run();
  	}
  
  	public void teleopInit() {
 		try {
 			Autonomous.cancel();
 		} catch (Exception e) { 
 		}
  	}
  }
