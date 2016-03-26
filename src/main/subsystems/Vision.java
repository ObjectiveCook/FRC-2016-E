package main.subsystems;

import java.io.IOException;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Vision extends Subsystem {
	private NetworkTable grip;

	private final double FOVx_px = 320;
	private final double FOVx_deg = 58.4;
	private final double targetLength = 1.667; // Feet
	private final double targetHeight = 1.0; // Feet
	private double[] defaultValue = new double[0];
	private double centerX, centerY, width, height;
	public double angleX, distance;

	public void initDefaultCommand() {
		setDefaultCommand(null);
	}

	public Vision() {
		try {
			new ProcessBuilder("/home/lvuser/grip").inheritIO().start();
		} catch (IOException e) {
			e.printStackTrace();
		}

		grip = NetworkTable.getTable("Vision");
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
			return true;
		} else {
			return false;
		}
	}
	
	public boolean targetGoal() {
		angleX = ((centerX - FOVx_px)/FOVx_px) * FOVx_deg;
		distance = (targetLength * FOVx_px)/(2 * width * Math.tan(angleX));
		SmartDashboard.putNumber("Angle", angleX);
		SmartDashboard.putNumber("Distance", distance);
		return true;
	}

}
