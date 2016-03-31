package main.commands.autonomous.crossing;

import edu.wpi.first.wpilibj.command.CommandGroup;
import main.commands.autonomous.shooting.ShootingController;
import main.commands.drivetrain.DriveDistance;
import main.commands.drivetrain.ResetGyro;
import main.commands.drivetrain.SetBrakeMode;
import main.commands.drivetrain.TurnToAngle;

/**
 * Crosses the Moat and Rock-wall (hopefully)
 */
public class ReverseAuto extends CommandGroup {
    
    public  ReverseAuto() {
    	addSequential(new SetBrakeMode(true));
    	addSequential(new DriveDistance(-180, 0.5));
    	addSequential(new TurnToAngle(121, 0.8));
    	addSequential(new ResetGyro());
    	addSequential(new ShootingController());
    }
}
