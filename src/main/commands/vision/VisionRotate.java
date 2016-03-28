package main.commands.vision;

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
public class VisionRotate extends Command {
	private double angle, maxSpeed, multiplier;
	private static double kP = 2.0;
	private static double kI = 1.0;
	private static double kD = 1.0;
	private static final double TOLERANCE = 2.5;

	private PIDController pid;
	private AnalogGyro gyro = HardwareAdapter.gyro;

	public VisionRotate(double maxSpeed, double multiplier) {
		requires(Robot.dt);
		this.maxSpeed = maxSpeed;
		this.multiplier = multiplier;
		setTimeout(2);
	}


	private void buildController() {
		angle = gyro.getAngle();
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
		pid.setSetpoint(angle + (Robot.vi.angleX * multiplier));
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
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return (pid.onTarget());
	}

	// Called once after isFinished returns true
	protected void end() {
		pid.reset();
		pid.disable();
		Robot.dt.arcadeDrive(0, 0, false);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
