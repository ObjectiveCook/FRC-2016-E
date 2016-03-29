package main.commands.autonomous.shooting;

import edu.wpi.first.wpilibj.command.CommandGroup;
import main.Robot;
import main.commands.drivetrain.RotateToAngle;
import main.commands.drivetrain.TurnToAngle;

/**
 *
 */
public class Shooting extends CommandGroup {
    private Integer position = Robot.position;
    
    public  Shooting() {
    	if(position == 1) {
        	addSequential(new RotateToAngle(30, 1.0));
    	}else if (position == 2) {
    		addSequential(new RotateToAngle(-30, 1.0));
    	}else if (position == 3) {
    	    addSequential(new RotateToAngle(60, 1.0));
    	}else if (position == 4) {
    	    addSequential(new RotateToAngle(-60, 1.0));
    	}else if (position == 5) {
    	    addSequential(new TurnToAngle(180, 1.0));
    	}
    }
}
