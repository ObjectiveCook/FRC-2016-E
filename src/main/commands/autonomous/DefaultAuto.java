package main.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import main.commands.battleaxes.DeployLeft;
import main.commands.battleaxes.DeployRight;
import main.commands.drivetrain.DriveDistance;
import main.commands.turret.HomeTurret;

/**
 * Crosses the Low-bar and Porticullis
 */
public class DefaultAuto extends CommandGroup {
    
    public  DefaultAuto() {
    	addSequential(new DeployLeft());
    	addSequential(new DeployRight());
    	addSequential(new HomeTurret());
    	addSequential(new DriveDistance(24, 0.5));
    }
}
