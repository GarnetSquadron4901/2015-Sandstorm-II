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
		
		// 
		if (stateControl == 0) {
			if (!isTimerStarted) {
				isTimerStarted = true;
				time.start();
			}
			
			if (rob.limitSwitch.get() == false) {
			// move the arm slowly in a direction
			// THIS DIRECTION WILL NEED TO BE VERIFIED!!!!
			rob.ContainerARM.ArmControl(0.1);
			rob.setArmStage(true);
			
			} else {
				isTimerStarted = false;
				stateControl = 1;
				time.stop();
				time.reset();
			}
			
			
			//moveTimeBased(1000, 1, 1, 0, 1);
		}
		
		// 
		if (stateControl == 1) {
			if (!isTimerStarted) {
				isTimerStarted = true;
				time.start();
			}
			
			if (time.get() > 1000) {
				// move the arm slowly in a direction
				// THIS DIRECTION WILL NEED TO BE VERIFIED!!!!
				rob.setArmStage(false);
				rob.ContainerARM.ArmControl(-0.1);
				rob.Drivetrain.setMotors(0.1, 0.1, 0);
			} else {
				isTimerStarted = false;
				stateControl = 2;
				rob.ContainerARM.ArmControl(0);
				rob.Drivetrain.setMotors(0, 0, 0);
				time.stop();
				time.reset();
			}
		}
		
		if (stateControl == 3) {
			moveTimeBased(2000, 0.5, 0.5, 0, 4);
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
