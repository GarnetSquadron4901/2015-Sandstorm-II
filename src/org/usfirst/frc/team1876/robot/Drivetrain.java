package org.usfirst.frc.team1876.robot;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;

public class Drivetrain {

	// TODO set constants
	private final int FRONT_LEFT_TALON_PWN = 2;
	private final int FRONT_RIGHT_TALON_PWN = 1;

	private final int BACK_LEFT_TALON_PWN = 3;
	private final int BACK_RIGHT_TALON_PWN = 0;

	private final int STRAFE_VICTOR_PWN = 4;

	private Talon frontLeftTalon;
	private Talon frontRightTalon;

	private Talon backLeftTalon;
	private Talon backRightTalon;

	private Victor strafeVictor;

	//The following is the default constructor.... blah blah blah
	public Drivetrain()
	{
		frontLeftTalon = new Talon(FRONT_LEFT_TALON_PWN);
		frontRightTalon = new Talon(FRONT_RIGHT_TALON_PWN);

		backLeftTalon = new Talon(BACK_LEFT_TALON_PWN);
		backRightTalon = new Talon(BACK_RIGHT_TALON_PWN);

		strafeVictor = new Victor(STRAFE_VICTOR_PWN);
	}

	/**
	 * First Person Shooter Drivetrain
	 * 
	 *   Emulates a FPS game controller
	 * 
	 * @param forwardValue
	 * @param rotationValue
	 * @param strafePower
	 */
	public void FPSDrive(double forwardValue, double rotationValue,	double strafePower)
	{
		double leftPower = 0.0;
		double rightPower = 0.0;

		if (forwardValue > 0.0)
		{
			if (rotationValue > 0.0)
			{
				leftPower = forwardValue - rotationValue;
				rightPower = Math.max(forwardValue, rotationValue);
			} else
			{
				leftPower = Math.max(forwardValue, -rotationValue);
				rightPower = forwardValue + rotationValue;
			}
		} else
		{
			if (rotationValue > 0.0)
			{
				leftPower = -Math.max(-forwardValue, rotationValue);
				rightPower = forwardValue + rotationValue;
			} else
			{
				leftPower = forwardValue - rotationValue;
				rightPower = -Math.max(-forwardValue, -rotationValue);
			}
		}
		
		setMotors(leftPower, rightPower, strafePower);
	}
	
	/**
	 * Set the motors' power
	 * 
	 * @param lp left power
	 * @param rp right power
	 * @param sp strafe power
	 */
	public void setMotors(double lp, double rp, double sp) {
		frontLeftTalon.set(lp);
		backLeftTalon.set(lp);
		frontRightTalon.set(-rp);
		backRightTalon.set(-rp);
		strafeVictor.set(sp);
	}
	
	
	// TODO method for wheel rotations

}
