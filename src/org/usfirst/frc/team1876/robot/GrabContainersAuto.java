package org.usfirst.frc.team1876.robot;

import edu.wpi.first.wpilibj.Timer;

public class GrabContainersAuto {

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
			aMethod(robo.ContainerARM);
		}
		else
		{
			bMethod(robo.ContainerARM);
			//I will have to double check to see if this will run the AutoDrive or I just need to call drive
			//I'll double check with Andrew as well to make sure  but I think last one will work
			drive.stateControl = 0;
			//or
			drive.update(robo);
			//or
			drive.moveTimeBased(2000, 1.0, 1.0, 0, 1);
			
		}
		
	}
	
	
	
	
	/**Some things that need to be fixed is to allow the arm to slow down and not try to brute stop it
		Also the timer delay/timer in general needs to be fixed
		Maybe I could make this when it can be more purposeful?
	*/
	public void aMethod(Arm anArm)
	{
		while(robo.limitSwitch.equals(false)) 
		{
			timer.start();
		anArm.ArmControl(1.0);
		timer.delay(1);
		anArm.setArmStage(true);
		}
		
	}
	//Timer on here also needs to be tweaked
	public void bMethod(Arm anArm)
	{
		anArm.setArmStage(false);
		timer.stop();
		timer.reset();
		timer.start();
		anArm.ArmControl(-1.0);
		if(timer.equals(2))
		{
			anArm.ArmControl(0);
		}
		
	}

}
