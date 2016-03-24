package main.subsystems;

import java.io.IOException;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import main.HardwareAdapter;

/**
 *
 */
public class Vision extends Subsystem {
	private NetworkTable vision;
	private AnalogGyro gyro = HardwareAdapter.gyro;
	private double[] CenterX, CenterY, Width, Height, defaultValue = new double[0];
	public double angleX, angleY, distance, centerX, centerY, width, height;

	private final double targetLength = 1.667;
	private final double targetHeight = 1.0;
	private final double FOVx_px = 320;
	private final double FOVx_deg = 58.4;
	private final double FOVy_px = 240;
	private final double FOVy_deg = 41.1;

	public void initDefaultCommand() {
		setDefaultCommand(null);
	}

	public Vision() {
		vision = NetworkTable.getTable("vision");

		try {
			new ProcessBuilder("/home/lvuser/grip").inheritIO().start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean createImage() {
		CenterX = vision.getNumberArray("centerX", defaultValue);
		CenterY = vision.getNumberArray("centerY", defaultValue);
		Width = vision.getNumberArray("width", defaultValue);
		Height = vision.getNumberArray("height", defaultValue);

		if (CenterX.length == 1 && CenterX != null) {
			centerX = CenterX[0];
			centerY = CenterY[0];
			width = Width[0];
			height = Height[0];
			return true;
		} else {
			return false;
		}
	}

	public void targetGoal() {
		angleX = ((centerX - FOVx_px) / (FOVx_px) * FOVx_deg) + (int) gyro.getAngle();
		angleY = -((centerY - FOVy_px) / (FOVy_px) * FOVy_deg);
		distance = (targetLength * FOVx_px) / (2 * width * Math.tan(angleX));
	}
}
