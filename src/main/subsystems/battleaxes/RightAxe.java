package main.subsystems.battleaxes;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import main.Constants;
import main.HardwareAdapter;

/**
 *
 */
public class RightAxe extends Subsystem implements Constants {
	private DoubleSolenoid actuator = HardwareAdapter.rightAxe;
	private boolean actuated = true;

	public void initDefaultCommand() {
		setDefaultCommand(null);
	}

	public void actuate() {
		if (actuated)
			actuator.set(EXT);
		else
			actuator.set(RET);
		actuated = !actuated;
	}

	public void off() {
		actuator.set(OFF);
	}

}
