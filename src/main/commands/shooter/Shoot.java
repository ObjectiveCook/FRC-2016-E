package main.commands.shooter;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class Shoot extends CommandGroup {
    
    public  Shoot() {
    	addSequential(new SetShooter(1.0));
    	addSequential(new WaitCommand(0.5));
    	addSequential(new SetLauncher(DoubleSolenoid.Value.kReverse));
    	addSequential(new WaitCommand(0.125));
    	addSequential(new SetLauncher(DoubleSolenoid.Value.kForward));
    	addSequential(new SetShooter(0));
    	addSequential(new WaitCommand(0.125));
    	addSequential(new SetLauncher(DoubleSolenoid.Value.kOff));
    }
}
