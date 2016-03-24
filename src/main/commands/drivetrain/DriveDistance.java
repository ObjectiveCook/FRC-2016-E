package main.commands.drivetrain;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Command;
import main.HardwareAdapter;
import main.Robot;

/**
 *
 */
public class DriveDistance extends Command {

	private static final double TOLERANCE = 5;
	private AnalogGyro gyro = HardwareAdapter.gyro;
	private PIDController pid;
	private double maxSpeed = 0.6;
	private double distance = 0.0;

	private double kP = 2.0;
	private double kI = 0.0;
	private double kD = 1.0;

	public DriveDistance(double distance, double maxSpeed, double kp, double ki, double kd) {
		requires(Robot.dt);
		kP = kp;
		kI = ki;
		kD = kd;
		this.maxSpeed = maxSpeed;
		this.distance = distance;
		buildController();
	}

	public DriveDistance(double distance, double maxSpeed) {
		requires(Robot.dt);
		this.maxSpeed = maxSpeed;
		this.distance = distance;
		buildController();
	}

	public DriveDistance(double distance) {
		requires(Robot.dt);
		this.distance = distance;
		buildController();
	}

	private void buildController() {

		pid = new PIDController(kP, kI, kD, new PIDSource() {
			PIDSourceType m_sourceType = PIDSourceType.kDisplacement;

			public double pidGet() {
				return Robot.dt.getDistance();
			}

			public void setPIDSourceType(PIDSourceType pidSource) {
				m_sourceType = pidSource;
			}

			public PIDSourceType getPIDSourceType() {
				return m_sourceType;
			}
		}, new PIDOutput() {

			public void pidWrite(double d) {
				// Drive with the magnitude returned by the PID calculation,
				// and curve the opposite way from the current yaw reading
				// (Divide yaw by 180 so as to normalize to -1.0 / + 1.0)
				Robot.dt.drive(-d, 0);
			}
		});

		pid.setAbsoluteTolerance(TOLERANCE);
		pid.setOutputRange((maxSpeed * -1.0), maxSpeed);
		pid.setSetpoint(distance);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		// Get everything in a safe starting state.
		Robot.dt.reset();
		pid.reset();
		pid.enable();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {

	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		double error = pid.getError();
		return (error >= 0 && error <= TOLERANCE);
	}

	// Called once after isFinished returns true
	protected void end() {
		// Stop PID and the wheels
		pid.disable();
		Robot.dt.drive(0, 0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
