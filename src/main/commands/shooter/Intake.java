package main.commands.shooter;

import edu.wpi.first.wpilibj.command.CommandGroup;
import main.commands.turret.HomeTurret;

/**
 *
 */
public class Intake extends CommandGroup {
    
    public  Intake() {
    	addSequential(new HomeTurret());
    	addSequential(new SetShooter(-1.0));
    }
}
