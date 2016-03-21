package main.subsystems;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import main.Constants;
import main.HardwareAdapter;
import main.commands.drivetrain.Drive;

/**
 *
 */
public class Drivetrain extends Subsystem implements Constants{
	
	private AnalogGyro gyro = HardwareAdapter.gyro;
    
	private CANTalon left = HardwareAdapter.leftDrive;
	private CANTalon leftSlave = HardwareAdapter.leftSlave;
	private CANTalon right = HardwareAdapter.rightDrive;
	private CANTalon rightSlave = HardwareAdapter.rightSlave;
	
	private RobotDrive drive;
	
	public Drivetrain() {
		gyro.reset();
		
		setControlMode(VBUS);
		setBrakeMode(COAST);
		left.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		right.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		
		drive = new RobotDrive(left, right);
		drive.setSafetyEnabled(true);
		drive.setExpiration(1.0);
		drive.setSensitivity(0.3);
		drive.setMaxOutput(1.0);
	}
	
	public void arcadeDrive(double move, double rotate, boolean squared) {
		drive.arcadeDrive(move, rotate, squared);
	}
	
	public void drive(double magnitude, double curve) {
		drive.drive(magnitude, curve);
	}
	
	public double getDistance() {
		return ((left.getPosition()) + (right.getPosition()))/2;
	}
	
	public void reset() {
		left.setPosition(0);
		right.setPosition(0);
	}
	
	public void setControlMode(TalonControlMode mode) {
		left.changeControlMode(mode);
		leftSlave.changeControlMode(SLAVE);
		right.changeControlMode(mode);
		rightSlave.changeControlMode(SLAVE);
	}
	
	public void setBrakeMode(boolean brake) {
		left.enableBrakeMode(brake);
		right.enableBrakeMode(brake);
	}

    public void initDefaultCommand() {
    	setDefaultCommand(new Drive());
    }
}

