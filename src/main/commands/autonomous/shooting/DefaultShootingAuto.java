package main.commands.autonomous.shooting;

import edu.wpi.first.wpilibj.command.CommandGroup;
import main.commands.battleaxes.DeployLeft;
import main.commands.battleaxes.DeployRight;
import main.commands.drivetrain.DriveDistance;
import main.commands.drivetrain.RotateToAngle;
import main.commands.shooter.Shoot;
import main.commands.turret.HomeTurretUp;

/**
 * Crosses the Low-bar, turns and shoots
 */
public class DefaultShootingAuto extends CommandGroup {
    
    public  DefaultShootingAuto() {
    	addSequential(new DeployLeft());
    	addSequential(new DeployRight());
    	addSequential(new DriveDistance(Math.pow(15, 2), 0.5));
    	addSequential(new RotateToAngle(53, 1.0));
    	addSequential(new DriveDistance(74, 0.5));
    	addSequential(new HomeTurretUp());
    	addSequential(new Shoot());
    }
}
