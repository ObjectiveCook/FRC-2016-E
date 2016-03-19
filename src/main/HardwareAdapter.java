package main;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;

public class HardwareAdapter implements Constants{
	// Joysticks
	public static final Joystick driveStick = new Joystick(JOYSTICK);
	// Digital sensors
	public static final DigitalInput lowerLimit = new DigitalInput(LOWER_LIMIT);
	public static final DigitalInput upperLimit = new DigitalInput(UPPER_LIMIT);
	// Analog sensors
	public static final AnalogGyro gyro = new AnalogGyro(GYRO);
	// CANTalons
	public static final CANTalon leftDrive = new CANTalon(LEFT_DRIVE);
	public static final CANTalon leftSlave = new CANTalon(LEFT_SLAVE);
	public static final CANTalon rightDrive = new CANTalon(RIGHT_DRIVE);
	public static final CANTalon rightSlave = new CANTalon(RIGHT_SLAVE);
	public static final CANTalon winch = new CANTalon(WINCH);
	// Sparks
	public static final Spark leftShooter = new Spark(LEFT_SHOOTER);
	public static final Spark rightShooter = new Spark(RIGHT_SHOOTER);
	public static final Spark leftScaler = new Spark(LEFT_SCALER);
	public static final Spark rightScaler = new Spark(RIGHT_SCALER);
	// Solenoids
	public static final DoubleSolenoid launcher = new DoubleSolenoid(PCM, LAUNCHER_EXT, LAUNCHER_RET);
	public static final DoubleSolenoid shifter = new DoubleSolenoid(PCM, SHIFTER_EXT, SHIFTER_RET);
	public static final DoubleSolenoid leftAxe = new DoubleSolenoid(PCM, LEFT_AXE_EXT, LEFT_AXE_RET);
	public static final DoubleSolenoid rightAxe = new DoubleSolenoid(PCM, RIGHT_AXE_EXT, RIGHT_AXE_RET);
	//Compressor
	public static final Compressor compressor = new Compressor(PCM);
}
