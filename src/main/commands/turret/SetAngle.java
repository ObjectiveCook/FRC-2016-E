package main.commands.turret;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Command;
import main.Constants;
import main.HardwareAdapter;
import main.Robot;

/**
 *
 */
public class SetAngle extends Command implements Constants{
	private double angle;
	private CANTalon winch = HardwareAdapter.winch;
	
    public SetAngle(double angle) {
    	requires(Robot.tr);
    	this.angle = angle;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.tr.setCtrlMode(POS);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.tr.setAngle(angle);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	double error = winch.getClosedLoopError();
    	
        return (error >= 0 || error <= WINCH_TOLERANCE);
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.tr.setCtrlMode(VBUS);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
