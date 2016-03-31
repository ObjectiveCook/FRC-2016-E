package main.commands.autonomous.crossing;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import main.commands.battleaxes.DeployLeft;
import main.commands.battleaxes.DeployRight;
import main.commands.drivetrain.DriveDistance;
import main.commands.drivetrain.SetBrakeMode;
import main.commands.turret.HomeTurret;

/**
 * Crosses the cheval...maybe
 */
public class ChevalAuto extends CommandGroup {
    
    public  ChevalAuto() {
    	addSequential(new SetBrakeMode(true));
    	addSequential(new DriveDistance(45, 0.5)); // Drive upto Cheval
    	addSequential(new DeployLeft());
    	addSequential(new DeployRight());
    	addSequential(new WaitCommand(0.5)); // Wait as to not drive onto it while the axes move it down
    	addSequential(new DriveDistance(63, 0.5)); // Cross cheval
    }
}
