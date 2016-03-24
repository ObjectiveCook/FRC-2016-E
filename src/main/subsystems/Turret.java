package main.subsystems;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import main.Constants;
import main.HardwareAdapter;
import main.commands.turret.Pivot;

/**
 *
 */
public class Turret extends Subsystem implements Constants {
	private CANTalon winch = HardwareAdapter.winch;
	private DigitalInput upper = HardwareAdapter.upperLimit;
	private DigitalInput lower = HardwareAdapter.lowerLimit;

	public void initDefaultCommand() {
		setDefaultCommand(new Pivot());
	}
	
	public Turret() {
		setCtrlMode(VBUS);
		winch.setInverted(true);
		winch.enableBrakeMode(BRAKE);
		winch.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		winch.changeControlMode(POS);
		winch.configEncoderCodesPerRev(LIFT_CODES_PER_REV);
		winch.setPID(WINCH_P, WINCH_I, WINCH_D);
		winch.setAllowableClosedLoopErr(WINCH_TOLERANCE);
	}

	public void home() {
			winch.set(TURRET_DOWNWARD_THROTTLE);
	}

	public void pivot(double yAxis) {
		if (yAxis > 0.0 && !upper.get())
			winch.set(yAxis * TURRET_UPWARD_THROTTLE);
		else if (yAxis < 0.0 && !lower.get())
			winch.set(yAxis * TURRET_DOWNWARD_THROTTLE);
		else
			winch.set(yAxis);

	}
	
	public void reset() {
		winch.setPosition(0);
	}

	public void setAngle(double angle) {
		winch.set(angle);
	}

	public void setCtrlMode(TalonControlMode mode) {
		winch.changeControlMode(mode);
	}


}
