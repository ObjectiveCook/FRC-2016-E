package main.commands.vision;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import main.commands.shooter.Shoot;
import main.commands.turret.HomeTurretUp;

/**
 *
 */
public class AutoTarget extends CommandGroup {

	public AutoTarget() {
		addSequential(new HomeTurretUp());
		addSequential(new TargetGoal());
		addSequential(new VisionRotate(0.9, 0.5));
		//addSequential(new WaitCommand(0.25));
		addSequential(new TargetGoal());
		addSequential(new VisionRotate(0.9, 0.5));
		//addSequential(new WaitCommand(0.25));
		addSequential(new TargetGoal());
		addSequential(new VisionRotate(0.9, 0.5));
		//addSequential(new WaitCommand(0.25));
		addSequential(new TargetGoal());
		addSequential(new VisionRotate(0.9, 0.5));
		addSequential(new TargetGoal());
		addSequential(new VisionRotate(0.9, 0.5));
		addSequential(new WaitCommand(0.25));
		addSequential(new Shoot());
	}
}
