package main.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import main.Constants;
import main.HardwareAdapter;

/**
 *
 */
public class Shooter extends Subsystem implements Constants {
	private Spark left = HardwareAdapter.leftShooter;
	private Spark right = HardwareAdapter.rightShooter;
	private DoubleSolenoid launcher = HardwareAdapter.launcher;

	public void initDefaultCommand() {
		setDefaultCommand(null);
	}

	public Shooter() {
		left.setInverted(true);
		right.setInverted(false);
	}

	public void set(double speed) {
		left.set(speed);
		right.set(speed);
	}

	public void launch(DoubleSolenoid.Value v) {
		launcher.set(v);
	}

}
