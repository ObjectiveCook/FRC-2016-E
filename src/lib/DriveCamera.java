package lib;

import edu.wpi.first.wpilibj.CameraServer;

public class DriveCamera {

	private CameraServer server;
	private String camera;
	private int quality = 50;
	
	public DriveCamera(String camera) {
		server = CameraServer.getInstance();
		this.camera = camera;
	}
	
	public DriveCamera(String camera, int quality) {
		server = CameraServer.getInstance();
		this.camera = camera;
		this.quality = quality;
	}
	
	public void start() {
		server.setQuality(quality);
		server.startAutomaticCapture(camera);
	}
	
	public void setCamera(String camera) {
		this.camera = camera;
	}
	
	public void setQuality(int quality) {
		this.quality = quality;
	}
}
