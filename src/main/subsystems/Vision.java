package main.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import main.commands.drivetrain.RotateToAngle;

/**
 *
 */
public class Vision extends Subsystem {
	private NetworkTable grip;

	private final double FOVx_px = 160;
	private final double FOVx_deg = 47;
	private final double targetWidth = 1.667; // Feet
	private final double targetHeight = 6.667; // Feet
	private double[] defaultValue = new double[0];
	private double centerX, centerY, width, height;
	public double angleX, distance;

	public void initDefaultCommand() {
		setDefaultCommand(null);
	}

	public Vision() {
		grip = NetworkTable.getTable("GRIP/vision");
	}

	public boolean createImage() {
		double[] centerx = grip.getNumberArray("centerX", defaultValue);
		double[] centery = grip.getNumberArray("centerY", defaultValue);
		double[] Width = grip.getNumberArray("width", defaultValue);
		double[] Height = grip.getNumberArray("height", defaultValue);

		if (centerx.length == 1) {
			centerX = centerx[0];
			centerY = centery[0];
			width = Width[0];
			height = Height[0];
			System.out.println("DONE");
			return true;
		} else {
			return false;
		}
	}
	
	public boolean targetGoal() {
		angleX = (((centerX - FOVx_px)/FOVx_px) * FOVx_deg) - 15.0;
		//double range = ((targetWidth/2)/(Math.atan(2*width/6.8085)));
		double range = (targetWidth * 640)/(2*width*Math.atan(FOVx_deg/2));
		System.out.println("ANGLE: " + angleX);
		System.out.println("RANGE: " + range);
		return true;
	}

}
