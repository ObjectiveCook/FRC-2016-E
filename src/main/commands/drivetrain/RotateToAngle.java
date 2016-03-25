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
public class RotateToAngle extends Command {
	private double angle, maxSpeed;
	private static double kP = 2.0;
	private static double kI = 1.0;
	private static double kD = 1.0;
	private static final double TOLERANCE = 5.0;

	private PIDController pid;
	private AnalogGyro gyro = HardwareAdapter.gyro;
	private double current;

	public RotateToAngle(double degrees, double maxSpeed, double kp, double ki, double kd) {
		requires(Robot.dt);
		kD = kd;
		this.maxSpeed = maxSpeed;
		angle = degrees;
		//buildController();
		setTimeout(2);
	}

	public RotateToAngle(double angle, double maxSpeed) {
		requires(Robot.dt);
		current = gyro.getAngle();
		this.angle = angle;
		this.maxSpeed = maxSpeed;
		//buildController();
		setTimeout(2);
	}

	public RotateToAngle(double degrees) {
		requires(Robot.dt);
		current = gyro.getAngle();
		angle = degrees;
		//buildController();
	}

	private void buildController() {
		current = gyro.getAngle();
		pid = new PIDController(kP, kI, kD, new PIDSource() {
			PIDSourceType sourceType = PIDSourceType.kDisplacement;

			public double pidGet() {
				return gyro.getAngle();
			}

			public void setPIDSourceType(PIDSourceType pidSource) {
				sourceType = pidSource;
			}

			public PIDSourceType getPIDSourceType() {
				return sourceType;
			}
		}, new PIDOutput() {

			public void pidWrite(double d) {
				// Spin with the magnitude returned by the PID calculation,
				Robot.dt.arcadeDrive(0, -d, false);
			}
		});
		pid.setAbsoluteTolerance(TOLERANCE);
		pid.setOutputRange((maxSpeed * -1.0), maxSpeed);
		pid.setSetpoint(current + angle);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		buildController();
		pid.reset();
		pid.enable();
		

	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		//pid.enable();
		System.out.println("TURNING");
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		double error = pid.getError();

		return (pid.onTarget());
	}

	// Called once after isFinished returns true
	protected void end() {
		pid.reset();
		pid.disable();
		Robot.dt.arcadeDrive(0, 0, false);
		System.out.println("DONE!");
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
