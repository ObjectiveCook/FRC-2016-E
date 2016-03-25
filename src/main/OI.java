package main;

import lib.XboxController;
import main.commands.autonomous.DefaultShootingAuto;
import main.commands.battleaxes.DeployLeft;
import main.commands.battleaxes.DeployRight;
import main.commands.drivetrain.RotateToAngle;
import main.commands.shooter.Intake;
import main.commands.shooter.SetShooter;
import main.commands.shooter.Shoot;
import main.commands.turret.HomeTurretUp;
import main.commands.turret.SetAngle;

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
		xbox.select.whenPressed(new RotateToAngle(-45, 1.0));
		xbox.b.whenPressed(new DefaultShootingAuto());
		xbox.x.whenPressed(new HomeTurretUp());
		xbox.y.whenPressed(new SetAngle(10));
		
		xbox.leftBumper.whenPressed(new Intake());
		xbox.leftBumper.whenReleased(new SetShooter(0));
		xbox.rightBumper.whenPressed(new Shoot());
		
		xbox.leftTrigger.whenPressed(new DeployLeft());
		xbox.rightTrigger.whenPressed(new DeployRight());
	}
}

