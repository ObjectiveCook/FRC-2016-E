package main.commands.vision;

import edu.wpi.first.wpilibj.command.CommandGroup;
import main.Robot;
import main.commands.drivetrain.RotateToAngle;
import main.commands.shooter.Shoot;
import main.commands.turret.SetAngle;

/**
 *
 */
public class TargetGoal extends CommandGroup {
    
    public  TargetGoal() {
    	addSequential(new SetAngle(45));
    	addSequential(new TargetGoal());
    	addSequential(new SetAngle(Robot.vi.angleY));
    	addSequential(new RotateToAngle(Robot.vi.angleX));
    	addSequential(new Shoot());
    }
}
