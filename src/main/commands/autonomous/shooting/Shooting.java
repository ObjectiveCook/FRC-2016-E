package main.commands.autonomous.shooting;

import edu.wpi.first.wpilibj.command.CommandGroup;
import main.Robot;
import main.commands.drivetrain.RotateToAngle;
import main.commands.drivetrain.SetBrakeMode;
import main.commands.drivetrain.TurnToAngle;

/**
 *
 */
public class Shooting extends CommandGroup {
	private Integer position = (Integer) Robot.positionChooser.getSelected();

	public Shooting() {
		if (position == 0) {
			addSequential(new TurnToAngle(90));
			/*addSequential(new TurnToAngle(180));
	    	addSequential(new SetBrakeMode(false));*/
		} else if (position == 1) {
			addSequential(new RotateToAngle(30, 1.0));
			/*addSequential(new DriveDistance(40, 0.5));
	    	addSequential(new RotateToAngle(53, 1.0));
	    	addSequential(new DriveDistance(74, 0.5));
	    	addSequential(new SetBrakeMode(false));
			addSequential(new AutoTarget());*/
		} else if (position == 2) {
			addSequential(new RotateToAngle(-30, 1.0));
			/*addSequential(new RotateToAngle(-40, 1.0));
			addSequential(new DriveDistance(77, 0.5));
			addSequential(new TurnToAngle(0, 1.0));
			addSequential(new DriveDistance(40, 0.5));
	    	addSequential(new RotateToAngle(53, 1.0));
	    	addSequential(new DriveDistance(74, 0.5));
	    	addSequential(new SetBrakeMode(false));
			addSequential(new AutoTarget());*/
		} else if (position == 3) {
			/*addSequential(new RotateToAngle(62, 1.0));
			addSequential(new DriveDistance(70, 0.5));
			addSequential(new TurnToAngle(0, 1.0));
			addSequential(new DriveDistance(50, 0.5));
			addSequential(new SetBrakeMode(false));
			addSequential(new AutoTarget());*/
			addSequential(new RotateToAngle(60, 1.0));
		} else if (position == 4) {
			addSequential(new RotateToAngle(-60, 1.0));
			/*addSequential(new RotateToAngle(-12, 1.0));
			addSequential(new DriveDistance(60, 0.5));
			addSequential(new TurnToAngle(0, 1.0));
			addSequential(new DriveDistance(50, 0.5));
			addSequential(new SetBrakeMode(false));
			addSequential(new AutoTarget());*/
		} else if (position == 5) {
			addSequential(new TurnToAngle(180, 1.0));
			/*addSequential(new RotateToAngle(-47, 1.0));
			addSequential(new DriveDistance(86, 0.5));
			addSequential(new TurnToAngle(0, 1.0));
			addSequential(new DriveDistance(50, 0.5));
			addSequential(new SetBrakeMode(false));
			addSequential(new AutoTarget());*/
		}
	}
}
