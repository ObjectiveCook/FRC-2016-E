package main.commands.autonomous.crossing;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import main.commands.battleaxes.DeployLeft;
import main.commands.battleaxes.DeployRight;
import main.commands.drivetrain.DriveDistance;

/**
 * Crosses the Cheval...maybe
 */
public class ChevalAuto extends CommandGroup {
    
    public  ChevalAuto() {
    	addSequential(new DriveDistance(24, 0.5)); // Drive upto Cheval
    	addSequential(new DeployLeft());
    	addSequential(new DeployRight());
    	addSequential(new WaitCommand(0.5)); // Wait as to not drive onto it while the axes move it down
    	addSequential(new DriveDistance(46.5, 0.5)); // Cross cheval
    }
}
