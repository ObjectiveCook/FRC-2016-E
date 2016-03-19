package main;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import main.commands.turret.SetAngle;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	private Joystick joy = HardwareAdapter.driveStick;
	private JoystickButton one = new JoystickButton(joy, 1);
	private JoystickButton two = new JoystickButton(joy, 2);
	private JoystickButton three = new JoystickButton(joy, 3);
	
	public OI() {
		check();
	}
	
	public void check() {
		one.whenPressed(new SetAngle(0));
		two.whenPressed(new SetAngle(15));
		three.whenPressed(new SetAngle(30));
	}
}

