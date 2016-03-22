package main;

import lib.XboxController;
import main.commands.drivetrain.DriveDistance;
import main.commands.drivetrain.RotateToAngle;

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
		xbox.a.whenPressed(new RotateToAngle(45, 0.5));
		xbox.b.whenPressed(new RotateToAngle(0, 0.7));
		xbox.x.whenPressed(new DriveDistance(1, 0.5));
		xbox.y.whenPressed(new DriveDistance(2, 0.3));
	}
}

