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
	// Talon Control Modes
	public static final TalonControlMode VBUS = TalonControlMode.PercentVbus;
	public static final TalonControlMode SLAVE = TalonControlMode.Follower;
	public static final TalonControlMode POS = TalonControlMode.Position;
	public static final TalonControlMode DISABLED = TalonControlMode.Disabled;
	// Talon Brake Modes
	public static final boolean BRAKE = true;
	public static final boolean COAST = false;
	// Solenoid states
	public static final DoubleSolenoid.Value EXT = DoubleSolenoid.Value.kForward;
	public static final DoubleSolenoid.Value RET = DoubleSolenoid.Value.kReverse;
	public static final DoubleSolenoid.Value OFF = DoubleSolenoid.Value.kOff;
	// USB Ports
	public static final int JOYSTICK = 0;
	// Analog Ports
	public static final int GYRO = 0;
	// CAN Bus Ports
	public static final int PDP = 0;
	public static final int PCM = 1;
	public static final int LEFT_DRIVE = 2;
	public static final int LEFT_SLAVE = 3;
	public static final int RIGHT_DRIVE = 4;
	public static final int RIGHT_SLAVE = 5;
	public static final int WINCH = 6;
	// PCM Ports
	public static final int SHIFTER_EXT = 1;
	public static final int SHIFTER_RET = 0;
	public static final int LAUNCHER_EXT = 3;
	public static final int LAUNCHER_RET = 2;
	public static final int LEFT_AXE_EXT = 4;
	public static final int LEFT_AXE_RET = 5;
	public static final int RIGHT_AXE_EXT = 6;
	public static final int RIGHT_AXE_RET = 7;
}
