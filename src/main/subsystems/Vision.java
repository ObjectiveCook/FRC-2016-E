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
	public double centerX, centerY, width, height;

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
}
