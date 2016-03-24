package main.commands.battleaxes;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class DeployRight extends CommandGroup {
    
    public  DeployRight() {
    	addSequential(new ActuateRight());
    	addSequential(new WaitCommand(0.125));
    	addSequential(new RightOff());
    }
}
