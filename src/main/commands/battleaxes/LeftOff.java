package main.commands.battleaxes;

import edu.wpi.first.wpilibj.command.Command;
import main.Robot;

/**
 *
 */
public class LeftOff extends Command {

    public LeftOff() {
    	requires(Robot.la);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.la.off();
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
    }
}
