package main.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import main.Constants;
import main.HardwareAdapter;

/**
 *
 */
public class Intake extends Subsystem implements Constants {
	private Spark left = HardwareAdapter.leftIntake;
	private Spark right = HardwareAdapter.rightIntake;

	public void initDefaultCommand() {
		setDefaultCommand(null);
	}

	public void set(double speed) {
		left.set(speed);
		right.set(-speed);
	}

}
