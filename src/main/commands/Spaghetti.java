package main.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.WaitCommand;
import main.Robot;
import edu.wpi.first.wpilibj.command.CommandGroup;//Alex

/**
 *
 */
public class Spaghetti extends CommandGroup {//Alex (used to be extends CommandGroup)

	private double speed;
	
    public Spaghetti(double speed) {
    	requires(Robot.in);
    	if(speed != 0){
    		this.speed = speed;
    		this.setSpeed(this.speed);
    		this.setSpeed(this.speed);
    	}
    	else
    	  this.speed = 0;
    }
    public void setSpeed(double speed){
    	addSequential(new WaitCommand(200));
    	if (this.speed <= 0.8) 
    		this.speed += 0.2;
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.in.set(speed);
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
