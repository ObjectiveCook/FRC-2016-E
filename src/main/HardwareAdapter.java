package main;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Spark;
import lib.XboxController;

public class HardwareAdapter implements Constants {
	// Joysticks
	public static final XboxController xbox = new XboxController(JOYSTICK);
	// Digital Sensor
	public static final DigitalInput upperLimit = new DigitalInput(UPPER_LIMIT);
	public static final DigitalInput lowerLimit = new DigitalInput(LOWER_LIMIT);
	// Analog Sensors
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
	public static final Spark leftIntake = new Spark(LEFT_INTAKE);
	public static final Spark rightIntake = new Spark(RIGHT_INTAKE);
	// Pneumatics
	public static final DoubleSolenoid launcher = new DoubleSolenoid(PCM, LAUNCHER_EXT, LAUNCHER_RET);
	public static final DoubleSolenoid leftAxe = new DoubleSolenoid(PCM, LEFT_AXE_EXT, LEFT_AXE_RET);
	public static final DoubleSolenoid rightAxe = new DoubleSolenoid(PCM, RIGHT_AXE_EXT, RIGHT_AXE_RET);

}
