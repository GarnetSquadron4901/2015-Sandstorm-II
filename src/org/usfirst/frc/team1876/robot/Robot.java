package org.usfirst.frc.team1876.robot;

import org.usfirst.frc.team1876.robot.io.LogitechController;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	Drivetrain drivetrain;
	LogitechController lc, lc2;
	Compressor AIR;
	Lift lift;
	Relay Comp;
	Arm ContainerARM;
	DigitalInput limitSwitch;
	Command autonomousCommand;
	SendableChooser autoChooser;
	
	
	private int USB0 = 0;
	private int USB1 = 1;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit()
	{
		AIR = new Compressor();
		Comp = new Relay(0);
		drivetrain = new Drivetrain();
		lift = new Lift();
		lc = new LogitechController(USB0);
		lc2 = new LogitechController(USB1);
		ContainerARM = new Arm();
		limitSwitch = new DigitalInput(1); //I know it's not in one but humour me here
		autoChooser = new SendableChooser();
		autoChooser.addDefault("Default for now", new AutoDrive());
		autoChooser.addObject("GrabRCs", new GrabContainersAuto());
		SmartDashboard.putData("Autonomous mode Chooser" ,autoChooser);
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic()
	{
		autonomousCommand = (Command)autoChooser.getSelected();
		autonomousCommand.start();
	}

	//Preferences p;
	
	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic()
	{
		//p = p.getInstance();
		// I think we should start the air compressor in the robotInit()
		// You can not start the compressor in the robotInit()
		AIR.start();
		if(AIR.enabled()){
			Comp.set(Relay.Value.kForward);
		}else{
			Comp.set(Relay.Value.kOff);
		}
		
		//SmartDashboard.putNumber("lc2 left axis y", lc2.getLeftAxisY());;
		
		double forward = lc.getLeftAxisY();
		double rotation = lc.getRightAxisX();
		double strafe = lc.getThrottle();
		
		// = null;
		
		//p.putDouble("lc2 left axis y", lc2.getLeftAxisY());
		drivetrain.FPSDrive(forward, rotation, strafe, true, false);
		
	    	lift.setStage(lc2.isAButtonPressed(), lc2.isBButtonPressed());
	    	
	    	
	    	
	    	ContainerARM.ArmControl(lc2.getRawLeftAxisY());
	    	ContainerARM.setArmStage(lc2.isLeftBumperPressed());
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic()
	{

	}

}
