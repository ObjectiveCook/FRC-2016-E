package main.commands.autonomous.shooting;

import edu.wpi.first.wpilibj.command.CommandGroup;
import main.commands.battleaxes.DeployLeft;
import main.commands.battleaxes.DeployRight;
import main.commands.drivetrain.DriveDistance;
import main.commands.drivetrain.RotateToAngle;
import main.commands.drivetrain.SetBrakeMode;
import main.commands.vision.AutoTarget;

/**
 * Crosses the Low-bar, turns and shoots
 */
public class DefaultShootingAuto extends CommandGroup {
    
    public  DefaultShootingAuto() {
    	addSequential(new DeployLeft());
    	addSequential(new DeployRight());
    	addSequential(new DriveDistance(180, 0.5));
    	addSequential(new RotateToAngle(53, 1.0));
    	addSequential(new DriveDistance(74, 0.5));
    	addSequential(new SetBrakeMode(false));
    	addSequential(new AutoTarget());
    }
}
