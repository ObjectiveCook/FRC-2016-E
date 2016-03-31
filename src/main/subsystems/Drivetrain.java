 package main.subsystems;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import main.Constants;
import main.HardwareAdapter;
import main.commands.drivetrain.Drive;

/**
 *
 */
public class Drivetrain extends Subsystem implements Constants {
	private AnalogGyro gyro = HardwareAdapter.gyro;
	private CANTalon left = HardwareAdapter.leftDrive;
	private CANTalon leftSlave = HardwareAdapter.leftSlave;
	private CANTalon right = HardwareAdapter.rightDrive;
	private CANTalon rightSlave = HardwareAdapter.rightSlave;
	private RobotDrive drive;

	public void initDefaultCommand() {
		setDefaultCommand(new Drive());
	}

	public Drivetrain() {
		gyro.reset();

		setControlMode(VBUS);
		left.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		left.configEncoderCodesPerRev(57);
		left.setPosition(0);
		left.enableBrakeMode(true);
		leftSlave.enableBrakeMode(true);

		right.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		right.configEncoderCodesPerRev(57);
		right.setPosition(0);
		right.enableBrakeMode(true);
		rightSlave.enableBrakeMode(true);

		drive = new RobotDrive(left, right);
		drive.setExpiration(0.1);
		drive.setMaxOutput(0.85);
	}

	public void arcadeDrive(double move, double rotate, boolean squared) {
		drive.arcadeDrive(move, rotate, false);
		System.out.println("GYRO: " + gyro.getAngle());
	}

	public void drive(double magnitude, double curve) {
		drive.drive(magnitude, curve);
	}

	public double getDistance() {
		return -(((-left.getPosition()) + (right.getPosition())) / 2);
	}

	public void reset() {
		left.setPosition(0);
		right.setPosition(0);
	}

	public void setControlMode(TalonControlMode mode) {
		left.changeControlMode(mode);
		leftSlave.changeControlMode(SLAVE);
		leftSlave.set(left.getDeviceID());
		right.changeControlMode(mode);
		rightSlave.changeControlMode(SLAVE);
		rightSlave.set(right.getDeviceID());
	}

	public void setBrakeMode(boolean brake) {
		left.enableBrakeMode(brake);
		leftSlave.enableBrakeMode(brake);
		right.enableBrakeMode(brake);
		leftSlave.enableBrakeMode(brake);
	}

}
