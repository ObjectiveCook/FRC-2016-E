package main.commands.autonomous.crossing;

import edu.wpi.first.wpilibj.command.CommandGroup;
import main.commands.autonomous.shooting.Shooting;
import main.commands.battleaxes.DeployLeft;
import main.commands.battleaxes.DeployRight;
import main.commands.drivetrain.DriveDistance;
import main.commands.turret.HomeTurret;

/**
 * Crosses the Ramparts and Rough-terrain
 */
public class AltAuto extends CommandGroup {
    
    public  AltAuto() {
    	addSequential(new DriveDistance(180, 0.5));
    	addSequential(new Shooting());
    }
}
