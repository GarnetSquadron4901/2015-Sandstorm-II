package org.usfirst.frc.team1876.robot;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;

public class Drivetrain {

	// TODO set constants

	private final int RIGHTTALONPWN = 0;
	private final int LEFTTALON_PWN = 1;

	private final int STRAFE_VICTOR_PWN = 3;
	
	private final double FULLSPEED = 1.0;
	private final double HALFSPEED = 0.5;
	private final double QUARTERSPEED = 0.25;
	

	private Talon LeftTalon;
	private Talon RightTalon;

	private Victor strafeVictor;

	//The following is the default constructor.... blah blah blah
	public Drivetrain()
	{
		LeftTalon = new Talon(LEFT_TALON_PWN);
		RightTalon = new Talon(RIGHT_TALON_PWN);
		
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
	public void FPSDrive(double forwardValue, double rotationValue,	double strafePower, boolean HALFPOW, boolean QUARTPOW)
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
		
		//Added boolean operators for seting speed reductions
		if(HALFPOW && !QUARTPOW){
			setMotors(leftPower, rightPower, strafePower, HALFSPEED);	
		}else{
			if(QUARTPOW && !HALFPOW){
				setMotors(leftPower, rightPower, strafePower, QUARTERSPEED);	
			}
			else{
				setMotors(leftPower, rightPower, strafePower, FULLSPEED);
			}
		}
	}
	
	/**
	 * Set the motors' power
	 * 
	 * @param lp left power
	 * @param rp right power
	 * @param sp strafe power
	 * @param reduc reduction multiple
	 */
	public void setMotors(double lp, double rp, double sp, double reduc) {
		LeftTalon.set(lp * reduc);
	        RightTalon.set(-rp * reduc);
		strafeVictor.set(sp);
	}
	
	
	// TODO method for wheel rotations

}
