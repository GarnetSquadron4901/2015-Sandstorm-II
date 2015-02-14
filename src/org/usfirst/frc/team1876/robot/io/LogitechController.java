package org.usfirst.frc.team1876.robot.io;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;

public class LogitechController {

	// TODO finish this class
	
	private int aButton;
	private int bButton;
	private int xButton = 5;
	private int yButton;
	
	private int startButton;
	private int modeButton;
	private int backButton;
	
	private int leftBumperButton;
	private int rightBumperButton;
	
	private int rightXAxis;
	
	Joystick joystick;
	
	final double DEADBAND_THRESHOLD = 0.10;
	
	public boolean isXButtonPressed () {
		return joystick.getRawButton(xButton);
	}
	
	public double getRightAxisX () {
		return filterAxisDeadband(joystick.getRawAxis(rightXAxis));
	}
	
	public double filterAxisDeadband (double val) {
		if (Math.abs(val) > DEADBAND_THRESHOLD) {
			return scale(val);
		}
		
		return 0;
	}
	
	public double scale (double val) {
		return val;
	}
	
	
}
