package main.commands.autonomous.shooting;

import edu.wpi.first.wpilibj.command.CommandGroup;
import main.commands.battleaxes.DeployLeft;
import main.commands.battleaxes.DeployRight;
import main.commands.drivetrain.DriveDistance;
import main.commands.drivetrain.RotateToAngle;
import main.commands.shooter.Shoot;
import main.commands.turret.HomeTurretUp;

/**
 * Crosses the Porticullis (POSITION #3) and shoots
 */
public class PorticullisMiddleShooting extends CommandGroup {
    
    public  PorticullisMiddleShooting() {
    	addSequential(new DeployLeft());
    	addSequential(new DeployRight());
    	addSequential(new DriveDistance(Math.pow(15, 2), 0.5)); // TODO (Ryan) Re-measure this.
    	addSequential(new HomeTurretUp());
    	addSequential(new Shoot());
    }
}
