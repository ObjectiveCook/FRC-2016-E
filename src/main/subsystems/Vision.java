package main.subsystems;

import java.io.IOException;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

/**
 *
 */
public class Vision extends Subsystem {
	private NetworkTable vision;
	private double[] CenterX, CenterY, Width, Height, defaultValue = new double[0];
	public double angleX, angleY, distance, centerX, centerY, width, height;
	
	private final double targetlength = 1.667;
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
}
	
	/*public boolean createImage() {
        	CenterX = vision.getNumberArray("centerX", defaultValue);
        	CenterY = vision.getNumberArray("centerY", defaultValue);
        	Width = table.getNumberArray("width", defaultValue);
		Height = table.getNumberArray("height", defaultValue);
		
		if (CenterX.length == 1 && CenterX[0] != null) {
			centerX = centerx[0];
			centerY = centery[0];
			width = width[0];
			height = height[0];
			return true;
		} else {
			return false;
		}
	}
	
	public boolean targetGoal() {
		angleX = ((centerX - FOVx_px)/(FOVx_px) * FOVx_deg;
		distance = (targetLength * FOVx_px)/(2 * Width * Math.tan(angleX));	
		
	}
}*/
