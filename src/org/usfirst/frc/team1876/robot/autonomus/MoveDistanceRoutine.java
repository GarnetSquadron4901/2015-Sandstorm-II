package org.usfirst.frc.team1876.robot.autonomus;

import org.usfirst.frc.team1876.robot.Robot;
import edu.wpi.first.wpilibj.Timer;

public class MoveDistanceRoutine {
	private Robot rob;
	private Timer time;
	boolean isTimerStarted = false;
	int stateControl = 0;
	
	public void update (Robot rob) {
		this.rob = rob;
		
		// move forward state
		if (stateControl == 0) {
			if (!isTimerStarted) {
				isTimerStarted = true;
				time.start();
			}
			
			// move the arm slowly in a direction
			// THIS DIRECTION WILL NEED TO BE VERIFIED!!!!
			rob.ContainerARM.ArmControl(0.1);
			
			
			moveTimeBased(1000, 1, 1, 0, 1);
		}
		
		// done moving stage
		if (stateControl == 1) {
			// do shit
		}
	}
	
	public void moveTimeBased (int durancy, double rightPower, double leftPower, double strafePower, int terminationState){
		
		if(!isTimerStarted){
			time.start();
			isTimerStarted = true;
		}
		
		rob.Drivetrain.setMotors(leftPower, rightPower, strafePower);
			
		if(time.get() > durancy){
			stateControl = terminationState;
			time.stop();
			time.reset();
				
			// The motors need to be reset to zero, else the robot will forever drive
			rob.Drivetrain.setMotors(0, 0, 0);
			isTimerStarted = false;
		}
		
	}
	
}
