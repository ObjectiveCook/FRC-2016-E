package main;

import lib.XboxController;
import main.commands.battleaxes.DeployLeft;
import main.commands.battleaxes.DeployRight;
import main.commands.shooter.Intake;
import main.commands.shooter.SetShooter;
import main.commands.shooter.Shoot;
import main.commands.vision.TargetGoal;

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
		xbox.select.whenPressed(new TargetGoal());
		
		xbox.leftBumper.whenPressed(new Intake());
		xbox.leftBumper.whenReleased(new SetShooter(0));
		xbox.rightBumper.whenPressed(new Shoot());
		
		xbox.leftTrigger.whenPressed(new DeployLeft());
		xbox.rightTrigger.whenPressed(new DeployRight());
	}
}

