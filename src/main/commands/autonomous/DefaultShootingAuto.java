package main.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import main.commands.battleaxes.DeployLeft;
import main.commands.battleaxes.DeployRight;
import main.commands.drivetrain.DriveDistance;
import main.commands.drivetrain.RotateToAngle;
import main.commands.shooter.Shoot;
import main.commands.turret.HomeTurret;
import main.commands.turret.SetAngle;

/**
 * Crosses the Low-bar and Porticullis
 */
public class DefaultShootingAuto extends CommandGroup {
    
    public  DefaultShootingAuto() {
    	addSequential(new DeployLeft());
    	addSequential(new DeployRight());
    	addSequential(new HomeTurret());
    	addSequential(new DriveDistance(210, 0.5));
    	addSequential(new RotateToAngle(45, 1.0));
    	addSequential(new SetAngle(60));
    	addSequential(new DriveDistance(30, 0.5));
    	//addSequential(new Shoot());
    }
}
