package main.commands.vision;

import edu.wpi.first.wpilibj.command.Command;
import main.Robot;

/**
 *
 */
public class Target extends Command {

    public Target() {
    	requires(Robot.vi);
    	setTimeout(2);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(!Robot.vi.createImage())
    		return;
    	
    	Robot.vi.targetGoal();
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
