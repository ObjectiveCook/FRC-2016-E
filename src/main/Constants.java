package main;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public interface Constants {
	// Throttles
	public static final double DRIVING_THROTTLE = 1.0;
	public static final double TURNING_THROTTLE = 1.0;
	public static final double UPWARD_THROTTLE = 1.0;
	public static final double DOWNWARD_THROTTLE = 1.0;
	// CANTalon Brake Modes
	public static final boolean BRAKE = true;
	public static final boolean COAST = false;
	// CANTalon Control Modes
	public static final TalonControlMode VBUS = TalonControlMode.PercentVbus;
	public static final TalonControlMode POSITION = TalonControlMode.Position;
	public static final TalonControlMode SLAVE = TalonControlMode.Follower;
	public static final TalonControlMode DISABLED = TalonControlMode.Disabled;
	// Solenoid states
	public static final DoubleSolenoid.Value EXT = DoubleSolenoid.Value.kForward;
	public static final DoubleSolenoid.Value RET = DoubleSolenoid.Value.kReverse;
	public static final DoubleSolenoid.Value OFF = DoubleSolenoid.Value.kOff;
	// USB Ports
	public static final int JOYSTICK = 0;
	// DIO Ports
	public static final int LOWER_LIMIT = 0;
	public static final int UPPER_LIMIT = 1;
	// Analog Ports
	public static final int GYRO = 0;
	// CAN Bus Ports
	public static final int PCM = 0;
	public static final int PDP = 1;
	public static final int LEFT_DRIVE = 2;
	public static final int LEFT_SLAVE = 3;
	public static final int RIGHT_DRIVE = 4;
	public static final int RIGHT_SLAVE = 5;
	public static final int WINCH = 6;
	// PWM Ports
	public static final int LEFT_SHOOTER = 0;
	public static final int RIGHT_SHOOTER = 1;
	public static final int LEFT_SCALER = 2;
	public static final int RIGHT_SCALER = 3;
	// PCM Ports
	public static final int LAUNCHER_EXT = 0;
	public static final int LAUNCHER_RET = 1;
	public static final int SHIFTER_EXT = 2;
	public static final int SHIFTER_RET = 3;
	public static final int LEFT_AXE_EXT = 4;
	public static final int LEFT_AXE_RET = 5;
	public static final int RIGHT_AXE_EXT = 6;
	public static final int RIGHT_AXE_RET = 7;
	// PDP Ports
	public static final int LEFT_DRIVE_PDP = 2;
	public static final int LEFT_SLAVE_PDP = 3;
	public static final int RIGHT_DRIVE_PDP = 4;
	public static final int RIGHT_SLAVE_PDP = 5;
	public static final int WINCH_PDP = 6;
	public static final int LEFT_SHOOTER_PDP = 0;
	public static final int RIGHT_SHOOTER_PDP = 1;
	public static final int LEFT_SCALER_PDP = 2;
	public static final int RIGHT_SCALER_PDP = 3;
}
