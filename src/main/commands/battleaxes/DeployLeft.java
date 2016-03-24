package main.commands.battleaxes;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class DeployLeft extends CommandGroup {
    
    public  DeployLeft() {
    	addSequential(new ActuateLeft());
    	addSequential(new WaitCommand(0.125));
    	addSequential(new LeftOff());
    }
}
