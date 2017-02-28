package main.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import main.commands.battleaxes.DeployLeft;
import main.commands.battleaxes.DeployRight;

/**
 *
 */
public class LowBar extends CommandGroup {
    
    public  LowBar() {
    	addSequential(new DeployLeft());
    	addSequential(new DeployRight());
    	addSequential(new TimedDrive(2.0, -0.5));
    	addSequential(new WaitCommand(25.0));
    	addSequential(new TimedDrive(2.0, 0.0));//addSequential(new HomeTurret());
    	//addSequential(new TimedDrive(0.35, 2.0));
    }
}
