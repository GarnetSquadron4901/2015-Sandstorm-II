package org.usfirst.frc.team1876.robot.io;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;

public class LogitechController {

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
	
	public boolean isXButtonPressed () {
		return joystick.getRawButton(xButton);
	}
	
	public double getRightAxisX () {
		return joystick.getRawAxis(rightXAxis);
	}
	
	
}
