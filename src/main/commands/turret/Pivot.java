package main.commands.turret;

import edu.wpi.first.wpilibj.command.Command;
import lib.XboxController;
import main.Constants;
import main.HardwareAdapter;
import main.Robot;

/**
 *
 */
public class Pivot extends Command implements Constants {
	private XboxController xbox = HardwareAdapter.xbox;

	public Pivot() {
		requires(Robot.tr);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		//Robot.tr.setCtrlMode(VBUS);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.tr.pivot(xbox.getAltY());
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
