package main.commands;

import edu.wpi.first.wpilibj.command.Command;
import main.Robot;

/**
 *
 */
public class TimedDrive extends Command {
	private double speed;
    public TimedDrive(double time, double speed) {
    	requires(Robot.dt);
    	this.speed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.dt.arcadeDrive(0.6, 0.0, false);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.dt.arcadeDrive(speed, 0.0, false);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
