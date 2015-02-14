package org.usfirst.frc.team1876.robot.io;

import edu.wpi.first.wpilibj.Joystick;

public class LogitechController {
	
	Joystick joystick;
	
	private int aButton = 1;
	private int bButton = 2;
	private int xButton = 3;
	private int yButton = 4;
	
	private int startButton = 8;
	private int backButton = 7;
	
	private int leftBumperButton = 5;
	private int rightBumperButton = 6;
	
	private int throttleAxis = 3;
	
	private int leftAnalogXAxis = 1;
	private int leftAnalogYAxis = 2;
	
	private int rightAnalogXAxis = 4;
	private int rightAnalogYAxis = 5;
	
	private int dPadXAxis = 6;
	private int dPadXLeft = -1;
	private int dPadXRight = 1;
	
	final double DEADBAND_THRESHOLD = 0.15;
	
	public LogitechController (int usbPort) {
		joystick = new Joystick(usbPort);
	}
	
	public boolean isAButtonPressed () {
		return joystick.getRawButton(aButton);
	}
	
	public boolean isBButtonPressed () {
		return joystick.getRawButton(bButton);
	}
	
	public boolean isXButtonPressed () {
		return joystick.getRawButton(xButton);
	}
	
	public boolean isYButtonPressed () {
		return joystick.getRawButton(yButton);
	}
	
	public boolean isStartButtonPressed () {
		return joystick.getRawButton(startButton);
	}
	
	public boolean isBackButtonPressed () {
		return joystick.getRawButton(backButton);
	}
	
	public boolean isLeftBumperPressed () {
		return joystick.getRawButton(leftBumperButton);
	}
	
	public boolean isRightBumperPressed () {
		return joystick.getRawButton(rightBumperButton);
	}
	
	public double getRawLeftAxisX () {
		return joystick.getRawAxis(leftAnalogXAxis);
	}
	
	public double getLeftAxisX () {
		return filterAxisDeadband(getRawLeftAxisX());
	}
	
	public double getRawLeftAxisY () {
		return joystick.getRawAxis(leftAnalogYAxis);
	}
	
	public double getLeftAxisY () {
		return filterAxisDeadband(getRawLeftAxisY());
	}
	
	public double getRawRightAxisX () {
		return joystick.getRawAxis(rightAnalogXAxis);
	}
	
	public double getRightAxisX () {
		return filterAxisDeadband(getRawRightAxisX());
	}
	
	public double getRawRightAxisY () {
		return joystick.getRawAxis(rightAnalogYAxis);
	}
	
	public double getRightAxisY () {
		return filterAxisDeadband(getRawRightAxisY());
	}
	
	public double getRawThrottle () {
		return joystick.getRawAxis(throttleAxis);
	}
	
	public double getThrottle () {
		return filterAxisDeadband(getRawThrottle());
	}
	
	public double getRawXDPad() {
		return joystick.getRawAxis(dPadXAxis);
	}
	
	public boolean isLeftDPadPressed () {
		return getRawXDPad() == dPadXLeft;
	}
	
	public boolean isRightDPadPressed () {
		return getRawXDPad() == dPadXRight;
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
