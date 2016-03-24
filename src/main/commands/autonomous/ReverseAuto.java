package main.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import main.commands.drivetrain.DriveDistance;
import main.commands.drivetrain.ResetGyro;
import main.commands.drivetrain.RotateToAngle;
import main.commands.turret.HomeTurret;

/**
 * Crosses the Moat, Ramparts, and Rock-wall (hopefully)
 */
public class ReverseAuto extends CommandGroup {
    
    public  ReverseAuto() {
    	addSequential(new HomeTurret());
    	addSequential(new DriveDistance(-24, 0.5));
    	addSequential(new RotateToAngle(180, 0.8));
    	addSequential(new ResetGyro());
    }
}
