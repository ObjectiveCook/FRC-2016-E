package main.commands.shooter;

import edu.wpi.first.wpilibj.command.CommandGroup;
import main.commands.Spaghetti;
import main.commands.turret.HomeTurret;

/**
 *
 */
public class Intake extends CommandGroup {
    
    public  Intake() {
    	addSequential(new HomeTurret());
    	addSequential(new Spaghetti(0.4));
    	addSequential(new SetShooter(-0.6));
    }
}
