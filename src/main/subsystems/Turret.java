package main.subsystems;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import main.Constants;
import main.HardwareAdapter;

/**
 *
 */
public class Turret extends Subsystem implements Constants{
    private CANTalon winch = HardwareAdapter.winch;
    private DigitalInput upper = HardwareAdapter.upperLimit;
    private DigitalInput lower = HardwareAdapter.lowerLimit;
    
    public Turret() {
    	winch.changeControlMode(POSITION);
    	winch.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
    	winch.setForwardSoftLimit(90);
    	winch.setReverseSoftLimit(0);
    	winch.enableForwardSoftLimit(true);
    	winch.enableReverseSoftLimit(true);
    	winch.setCloseLoopRampRate(2);
    	winch.setPID(1.0, 0, 0);
    }
    
    public void setAngle(double angle) {
    	winch.set(angle);
    }

    public void initDefaultCommand() {
    	setDefaultCommand(null);
    }
}

