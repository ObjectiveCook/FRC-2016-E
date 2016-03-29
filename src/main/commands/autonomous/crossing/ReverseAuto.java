package main.commands.autonomous.crossing;

import edu.wpi.first.wpilibj.command.CommandGroup;
import main.commands.drivetrain.DriveDistance;
import main.commands.drivetrain.ResetGyro;
import main.commands.drivetrain.TurnToAngle;
import main.commands.turret.HomeTurret;

/**
 * Crosses the Moat, Ramparts, and Rock-wall (hopefully)
 */
public class ReverseAuto extends CommandGroup {
    
    public  ReverseAuto() {
    	addSequential(new DriveDistance(-180, 0.5));
    	addSequential(new TurnToAngle(180, 0.8));
    	addSequential(new ResetGyro());
    }
}
