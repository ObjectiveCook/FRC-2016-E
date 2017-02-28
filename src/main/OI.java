package main;

import lib.XboxController;
import main.commands.Spaghetti;
import main.commands.battleaxes.DeployLeft;
import main.commands.battleaxes.DeployRight;
import main.commands.shooter.SetShooter;
import main.commands.shooter.Shoot;
import main.commands.shooter.Intake;

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
		//xbox.a.whenPressed(new RotateToAngle(90));
		xbox.leftBumper.whenPressed(new Intake());
		xbox.leftBumper.whenReleased(new SetShooter(0));
		xbox.leftBumper.whenReleased(new Spaghetti(0));
		xbox.rightBumper.whenPressed(new Shoot());
		
		xbox.a.whenPressed(new Spaghetti(0.4));
		xbox.a.whenReleased(new Spaghetti(0));
		//xbox.a.whenPressed(new Spaghetti(0.45));
		//xbox.a.whenReleased(new Spaghetti(0));
		
		xbox.leftTrigger.whenPressed(new DeployLeft());
		xbox.rightTrigger.whenPressed(new DeployRight());
	}
}

