package org.usfirst.frc.team1876.robot;

import org.usfirst.frc.team1876.robot.autonomus.MoveDistanceRoutine;
import org.usfirst.frc.team1876.robot.io.LogitechController;

import edu.wpi.first.wpilibj.IterativeRobot;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	Drivetrain drivetrain;
	LogitechController lc;
	
	MoveDistanceRoutine mdr;

	int autoTickCount = 0;
	int autoMaxTickCount = 100;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit()
	{
		drivetrain = new Drivetrain();
		drivetrain.startFLEncoder();
		
		mdr = new MoveDistanceRoutine();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic()
	{
		mdr.update(drivetrain);

	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic()
	{
		// drivetrain.drive(x, y);
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic()
	{

	}

}
