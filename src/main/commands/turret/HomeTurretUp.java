package main.commands.turret;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Command;
import main.Constants;
import main.HardwareAdapter;
import main.Robot;

/**
 *
 */
public class HomeTurretUp extends Command implements Constants {
	private DigitalInput upper = HardwareAdapter.upperLimit;

	public HomeTurretUp() {
		requires(Robot.tr);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.tr.setCtrlMode(VBUS);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.tr.homeUp();
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return (!upper.get());
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.tr.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
