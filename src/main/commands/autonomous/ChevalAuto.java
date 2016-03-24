package main.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import main.commands.drivetrain.DriveDistance;
import main.commands.turret.HomeTurret;

/**
 * Crosses the Low-bar and Porticullis
 */
public class ChevalAuto extends CommandGroup {
    
    public  ChevalAuto() {
    	addSequential(new HomeTurret());
    	addSequential(new DriveDistance(24, 0.5));
    }
}
