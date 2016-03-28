package main.commands.autonomous.shooting;

import edu.wpi.first.wpilibj.command.CommandGroup;
import main.Robot;
import main.commands.drivetrain.DriveDistance;
import main.commands.drivetrain.RotateToAngle;
import main.commands.shooter.Shoot;
import main.commands.vision.AutoTarget;

/**
 *
 */
public class Shooting extends CommandGroup {
    private Integer position = Robot.position;
    
    public  Shooting() {
    	if(position == 1) {
        	addSequential(new DriveDistance(45, 0.5));
        	addSequential(new RotateToAngle(53, 1.0));
        	addSequential(new DriveDistance(74, 0.5));
        	addSequential(new AutoTarget());
        	addSequential(new Shoot());
    	}else if (position == 2) {
    		
    	}else if (position == 3) {
    		
    	}else if (position == 4) {
    	
    	}else if (position == 5) {
        	addSequential(new DriveDistance(45, 0.5));
        	addSequential(new RotateToAngle(-53, 1.0));
        	addSequential(new DriveDistance(74, 0.5));
        	addSequential(new AutoTarget());
        	addSequential(new Shoot());
    	}
    }
}
