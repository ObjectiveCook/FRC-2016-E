
package main;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import lib.DriveCamera;
import main.commands.autonomous.crossing.AltAuto;
import main.commands.autonomous.crossing.ChevalAuto;
import main.commands.autonomous.crossing.DefaultAuto;
import main.commands.autonomous.crossing.ReverseAuto;
import main.commands.autonomous.crossing.TestingAuto;
import main.commands.autonomous.shooting.DefaultShootingAuto;
import main.subsystems.Drivetrain;
import main.subsystems.Shooter;
import main.subsystems.Turret;
import main.subsystems.Vision;
import main.subsystems.battleaxes.LeftAxe;
import main.subsystems.battleaxes.RightAxe;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	public static int position;
	public static OI oi;
	public static Drivetrain dt;
	public static LeftAxe la;
	public static RightAxe ra;
	public static Turret tr;
	public static Shooter sh;
	public static Vision vi;

	public static DriveCamera camera;
	public static SendableChooser commandChooser, positionChooser;
	Command autonomousCommand;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		dt = new Drivetrain();
		la = new LeftAxe();
		ra = new RightAxe();
		tr = new Turret();
		sh = new Shooter();
		vi = new Vision();
		oi = new OI();

		camera = new DriveCamera("cam1", 50);
		camera.start();

		positionChooser = new SendableChooser();
		positionChooser.addDefault("1", 1);
		positionChooser.addObject("2", 2);
		positionChooser.addObject("3", 3);
		positionChooser.addObject("4", 4);
		positionChooser.addObject("5", 5);
		positionChooser.addObject("No Shooting", 0);
		SmartDashboard.putData("Auto position", positionChooser);
		position = (Integer) positionChooser.getSelected();

		commandChooser = new SendableChooser();
		commandChooser.addDefault("Low-bar", new DefaultAuto());
		commandChooser.addObject("Porticullis", new TestingAuto());
		commandChooser.addObject("Cheval de Frise", new ChevalAuto());
		commandChooser.addObject("Moat", new ReverseAuto());
		commandChooser.addObject("Ramparts", new AltAuto());
		commandChooser.addObject("Rough-terrain", new AltAuto());
		commandChooser.addObject("Rock wall", new ReverseAuto());
		commandChooser.addObject("Emergency Auto", new DefaultShootingAuto());
		SmartDashboard.putData("Auto mode", commandChooser);

	}
	

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	public void disabledInit() {

	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}
	
	public static void getPosition() {
		position = (Integer) positionChooser.getSelected();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	public void autonomousInit() {
		autonomousCommand = (Command) commandChooser.getSelected();
		// schedule the autonomous command (example)
		if (autonomousCommand != null) {
			position = (Integer) positionChooser.getSelected();
			autonomousCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		//position = (Integer) positionChooser.getSelected();
	}

	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		//position = (Integer) positionChooser.getSelected();
	}
	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run();
	}
}
