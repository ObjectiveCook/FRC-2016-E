package main.commands.autonomous.crossing;

import edu.wpi.first.wpilibj.command.CommandGroup;
import main.commands.drivetrain.DriveDistance;
import main.commands.turret.HomeTurret;
import main.commands.turret.SetAngle;

/**
 * Crosses the Low-bar and Porticullis
 */
public class RoughTerrainAuto extends CommandGroup {
    
    public  RoughTerrainAuto() {
    	addSequential(new HomeTurret());
    	addSequential(new SetAngle(10));
    	addSequential(new DriveDistance(180, 0.5));
    	addSequential(new HomeTurret());
    }
}
