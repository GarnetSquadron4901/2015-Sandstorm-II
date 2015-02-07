package org.usfirst.frc.team1876.robot;

import org.usfirst.frc.team1876.robot.io.LogitechController;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	Joystick joy;
	Drivetrain drivetrain;
	LogitechController lc;
	
	private int USB0 = 0;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit()
	{
		drivetrain = new Drivetrain();
		joy = new Joystick(USB0);
		lc = new LogitechController();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic()
	{

	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic()
	{
		// Temporary!
		double forward = lc.filterAxisDeadband(joy.getRawAxis(1));
		double rotation = lc.filterAxisDeadband(joy.getRawAxis(4));
		double strafe = lc.filterAxisDeadband(joy.getRawAxis(3)) - lc.filterAxisDeadband(joy.getRawAxis(2));
		
		drivetrain.FPSDrive(forward, rotation, strafe);
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic()
	{

	}

}
