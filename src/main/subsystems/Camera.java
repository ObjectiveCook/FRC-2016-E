package main.subsystems;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Camera extends Subsystem {
	private CameraServer server;

    public void initDefaultCommand() {
    	setDefaultCommand(null);
    }
    
    public Camera() {
    	server = CameraServer.getInstance();
    	server.setQuality(60);
    	server.startAutomaticCapture("cam0");
    }
}

