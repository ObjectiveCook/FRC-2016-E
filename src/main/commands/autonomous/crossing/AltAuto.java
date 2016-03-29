package main.commands.autonomous.crossing;

import edu.wpi.first.wpilibj.command.CommandGroup;
import main.commands.autonomous.shooting.Shooting;
import main.commands.drivetrain.DriveDistance;
import main.commands.drivetrain.SetBrakeMode;
import main.commands.turret.HomeTurretUp;

/**
 * Crosses the Ramparts and Rough-terrain
 */
public class AltAuto extends CommandGroup {
    
    public  AltAuto() {
    	addSequential(new SetBrakeMode(true));
    	addSequential(new HomeTurretUp());
    	addSequential(new DriveDistance(180, 0.5));
    	addSequential(new Shooting());
    }
}
