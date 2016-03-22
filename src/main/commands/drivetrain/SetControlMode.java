package main.commands.drivetrain;

import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Command;
import main.Constants;
import main.Robot;

/**
 *
 */
public class SetControlMode extends Command implements Constants {
	private TalonControlMode mode;

	public SetControlMode(TalonControlMode mode) {
		requires(Robot.dt);
		this.mode=mode;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.dt.setControlMode(mode);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return true;
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
