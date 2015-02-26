package org.usfirst.frc.team1876.robot;
//package should have 3490 in it
import edu.wpi.first.wpilibj.Timer;

public class GrabContainersAuto {
	
	/**
	 * If this code works then it was written by Bradley Faircloth. If it doesn't not then
	 * I'm not sure who wrote this, probably 3824
	 */

	private Robot robo;
	private AutoDrive drive;
	private static Timer timer;
	public boolean isDown;
	
	
	public void update(Robot robo)
	{
		this.robo = robo;
		robo.limitSwitch.get();
		if(robo.limitSwitch.equals(false))
		{
			timer.reset();
			aMethod(robo.ContainerARM);
		}
		else
		{
			timer.reset();
			bMethod(robo.ContainerARM);
			drive.moveTimeBased(2000, 1.0, 1.0, 0, 1);
			
		}
		
	}
	
	
	
	
	/**Some things that need to be fixed is to allow the arm to slow down and not try to brute stop it
		Also the timer delay/timer in general needs to be fixed
		Maybe I could make this where it can be more purposeful?
	*/
	public void aMethod(Arm anArm)
	{
		while(robo.limitSwitch.equals(false)) 
		{
			timer.start();
			anArm.ArmControl(1.0);
			if(timer.get() == 1.0)
			{
				anArm.setArmStage(true);
			}		
		}
		if(robo.limitSwitch.equals(true))
		{
			anArm.ArmControl(0);
			timer.stop();
		}
		
	}
	//Timer on here also needs to be tweaked
	public void bMethod(Arm anArm)
	{
		anArm.setArmStage(false);
		timer.start();
		while(timer.get() != 2.0)
		{
			anArm.ArmControl(-1.0);
		}
		anArm.ArmControl(0);
		timer.stop();
		
		
	}

}
