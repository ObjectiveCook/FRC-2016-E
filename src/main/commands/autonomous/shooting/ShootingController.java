package main.commands.autonomous.shooting;

import edu.wpi.first.wpilibj.command.CommandGroup;
import main.Robot;
import main.commands.drivetrain.DriveDistance;
import main.commands.drivetrain.RotateToAngle;
import main.commands.drivetrain.SetBrakeMode;
import main.commands.drivetrain.TurnToAngle;
import main.commands.vision.AutoTarget;

/**
 *
 */
public class ShootingController extends CommandGroup {
	public static int position;
	public ShootingController() {
		position = Robot.position;
		if (position == 0) {
			addSequential(new DriveDistance(40, 0.5));
			addSequential(new TurnToAngle(180, 1.0));;
	    	addSequential(new SetBrakeMode(false));
		} else if (position == 1) {
			addSequential(new DriveDistance(40, 0.5));
	    	addSequential(new RotateToAngle(53, 0.7));
	    	addSequential(new DriveDistance(74, 0.5));
	    	addSequential(new SetBrakeMode(false));
			addSequential(new AutoTarget());
		} else if (position == 2) {
			addSequential(new RotateToAngle(-40, 1.0));
			addSequential(new DriveDistance(72, 0.5));
			addSequential(new TurnToAngle(0, 1.0));
			addSequential(new DriveDistance(40, 0.5));
	    	addSequential(new RotateToAngle(53, 1.0));
	    	addSequential(new DriveDistance(74, 0.5));
	    	addSequential(new SetBrakeMode(false));
			addSequential(new AutoTarget());
		} else if (position == 3) {
			addSequential(new RotateToAngle(62, 1.0));
			addSequential(new DriveDistance(64, 0.5));
			addSequential(new TurnToAngle(0, 1.0));
			addSequential(new DriveDistance(20, 0.5));
			addSequential(new SetBrakeMode(false));
			addSequential(new AutoTarget());
		} else if (position == 4) {
			addSequential(new RotateToAngle(-12, 1.0));
			addSequential(new DriveDistance(54, 0.5));
			addSequential(new TurnToAngle(0, 1.0));
			addSequential(new DriveDistance(20, 0.5));
			addSequential(new SetBrakeMode(false));
			addSequential(new AutoTarget());
		} else if (position == 5) {
			addSequential(new RotateToAngle(-47, 0.7));
			addSequential(new DriveDistance(80, 0.5));
			addSequential(new TurnToAngle(0, 0.7));
			addSequential(new DriveDistance(18, 0.5));
			addSequential(new SetBrakeMode(false));
			addSequential(new AutoTarget());
		}
	}
}
