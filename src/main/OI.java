package main;

import lib.XboxController;
import main.commands.autonomous.crossing.AltAuto;
import main.commands.autonomous.crossing.ChevalAuto;
import main.commands.autonomous.crossing.DefaultAuto;
import main.commands.autonomous.crossing.ReverseAuto;
import main.commands.battleaxes.DeployLeft;
import main.commands.battleaxes.DeployRight;
import main.commands.drivetrain.DriveDistance;
import main.commands.shooter.Intake;
import main.commands.shooter.SetShooter;
import main.commands.shooter.Shoot;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	private XboxController xbox = HardwareAdapter.xbox;
	
	public OI() {
		check();
	}
	
	private void check() {
		xbox.a.whenPressed(new DriveDistance(12, 0.5));
		xbox.b.whenPressed(new DefaultAuto());
		xbox.x.whenPressed(new AltAuto());
		xbox.y.whenPressed(new ReverseAuto());
		xbox.select.whenPressed(new ChevalAuto());
		
		xbox.leftBumper.whenPressed(new Intake());
		xbox.leftBumper.whenReleased(new SetShooter(0));
		xbox.rightBumper.whenPressed(new Shoot());
		
		xbox.leftTrigger.whenPressed(new DeployLeft());
		xbox.rightTrigger.whenPressed(new DeployRight());
	}
}

