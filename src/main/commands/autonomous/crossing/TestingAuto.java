package main.commands.autonomous.crossing;

import edu.wpi.first.wpilibj.command.CommandGroup;
import main.commands.autonomous.shooting.ShootingController;
import main.commands.battleaxes.DeployLeft;
import main.commands.battleaxes.DeployRight;
import main.commands.drivetrain.DriveDistance;
import main.commands.drivetrain.SetBrakeMode;
import main.commands.turret.HomeTurret;

/**
 * Crosses the Low-bar and Porticullis
 */
public class TestingAuto extends CommandGroup {
    
    public  TestingAuto() {
    	addSequential(new SetBrakeMode(true));
    	addSequential(new DeployLeft());
    	addSequential(new DeployRight());
    	addSequential(new DriveDistance(12, 0.5));
    	addSequential(new ShootingController());
    }
}
