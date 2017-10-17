package org.usfirst.frc.team5338.robot;
 
import org.usfirst.frc.team5338.robot.commands.Autonomous;
import org.usfirst.frc.team5338.robot.subsystems.Climber;
import org.usfirst.frc.team5338.robot.subsystems.DriveTrain;
import org.usfirst.frc.team5338.robot.subsystems.GearHandler;
 
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
  
public class Robot extends IterativeRobot {
	// Creates the OI and DriveTrain objects.
	
	public static final OI oi = new OI();
	public static final DriveTrain drivetrain = new DriveTrain();
	public static final GearHandler gearhandler = new GearHandler();
	public static final Climber climber = new Climber();

	//Initializes the Navx
	public static final AHRS ahrs = new AHRS(SPI.Port.kMXP, (byte) (200));
	//Creates a Command for Autonomous
	public static Command Autonomous;

	// Robot object constructor.
	public void robotInit() {
		//Makes sure that the robot doesn't run any code before the navx is calibrated
		while (ahrs.isCalibrating() || ahrs.isMagnetometerCalibrated()) {
		}
		
		SmartDashboard.putString("TYPE OF DRIVE", "ARCADEX");
	}

	// Called at the start of the autonomous activating the command.
	public void autonomousInit() {
		//Added the line below to make sure that the ahrs is used after calibration
		final Command Autonomous = new Autonomous();
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
