package main;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import lib.XboxController;

public class HardwareAdapter implements Constants {
	// Joysticks
	public static final XboxController xbox = new XboxController(JOYSTICK);
	// Analog Sensors
	public static final AnalogGyro gyro = new AnalogGyro(GYRO);
	// CANTalons
	public static final CANTalon leftDrive = new CANTalon(LEFT_DRIVE);
	public static final CANTalon leftSlave = new CANTalon(LEFT_SLAVE);
	public static final CANTalon rightDrive = new CANTalon(RIGHT_DRIVE);
	public static final CANTalon rightSlave = new CANTalon(RIGHT_SLAVE);
	public static final CANTalon winch = new CANTalon(WINCH);
	// Pneumatics
	public static final DoubleSolenoid launcher = new DoubleSolenoid(PCM, LAUNCHER_EXT, LAUNCHER_RET);
	public static final DoubleSolenoid leftAxe = new DoubleSolenoid(PCM, LEFT_AXE_EXT, LEFT_AXE_RET);
	public static final DoubleSolenoid rightAxe = new DoubleSolenoid(PCM, RIGHT_AXE_EXT, RIGHT_AXE_RET);

}
