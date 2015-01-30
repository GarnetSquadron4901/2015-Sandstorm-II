package org.usfirst.frc.team1876.robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;

public class Drivetrain {
	
	
	// TODO set constants
	private final int FL_T = 1;
	private final int FR_T = 1;
	
	private final int BL_T = 1;
	private final int BR_T = 1;
	
	private final int M_V = 1;

	private Talon frontLeftTalon;
	private Talon frontRightTalon;
	
	private Talon backLeftTalon;
	private Talon backRightTalon;
	
	private Victor middleTalon;
	
	private Encoder frontLeftEncoder;
	
	public Drivetrain () {
		frontLeftTalon = new Talon (FL_T);
		frontRightTalon = new Talon (FR_T);
		
		backLeftTalon = new Talon (BL_T);
		backRightTalon = new Talon (BR_T);
		
		middleVictor = new Victor (M_V);
		
		frontLeftEncoder = new Encoder (1, 2);
	}
	
	public void FPSDrive(double moveValue, double rotateValue, double strafePower){
		double Leftpower = 0.0;
		double Rightpower = 0.0;
		
        if (moveValue > 0.0) {
            if (rotateValue > 0.0) {
            	Leftpower = moveValue - rotateValue;
            	Rightpower = Math.max(moveValue, rotateValue);
            } else {
            	Leftpower = Math.max(moveValue, -rotateValue);
            	Rightpower = moveValue + rotateValue;
            }
        } else {
            if (rotateValue > 0.0) {
            	Leftpower = -Math.max(-moveValue, rotateValue);
            	Rightpower = moveValue + rotateValue;
            } else {
            	Leftpower = moveValue - rotateValue;
            	Rightpower = -Math.max(-moveValue, -rotateValue);
            }
          }	
          	frontLeftTalon.set(Leftpower);
		backLeftTalon.set(Leftpower);
		frontRightTalon.set(-Rightpower);
		backRightTalon.set(-Rightpower);
		middleVictor.set(strafePower);
	}
	
	public void startFLEncoder () {
		frontLeftEncoder.reset();
	}
	
	public int getFLEncoder () {
		return frontLeftEncoder.get();
	}
	
}
