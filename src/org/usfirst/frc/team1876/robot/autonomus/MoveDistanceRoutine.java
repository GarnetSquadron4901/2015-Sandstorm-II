package org.usfirst.frc.team1876.robot.autonomus;

import org.usfirst.frc.team1876.robot.Robot;

public class MoveDistanceRoutine {
	private Robot rob;
	
	private Timer time;
	
	boolean isTimerStarted = false;
	
	int stateControl = 0;

	
	public void update (Robot rob) {
		this.rob = rob;
	}
	
	public void moveForward_1(){
		
		if(!isTimerStarted){
			time.start();
			isTimerStarted = true;
		}
		
		if(stateControl == 0){
			
			rob.Drivetrain.setMotors(1.0);
			
			if(time.get() > 4000){
				stateControl = 1;
				time.stop();
				time.reset();
				
				rob.Drivetrain.setMotors(0.0);
				isTimerStarted = false;
			}
		}
	}
	
	public void moveForward_2(){
		
		if(!isTimerStarted){
			time.start();
			isTimerStarted = true;
		}
		
		if(stateControl == 0){
			
			rob.Drivetrain.setMotors(1.0);
			
			if(time.get() > 3000){
				stateControl = 1;
				time.stop();
				time.reset();
				
				rob.Drivetrain.setMotors(0.0);
				isTimerStarted = false;
			}
		}
	}
	
	public void moveForward_3(){
		
		if(!isTimerStarted){
			time.start();
			isTimerStarted = true;
		}
		
		if(stateControl == 0){
			
			rob.Drivetrain.setMotors(1.0);
			
			if(time.get() > 4000){
				stateControl = 1;
				time.stop();
				time.reset();
				
				rob.Drivetrain.setMotors(0.0);
				isTimerStarted = false;
			}
		}
	}
	
	
}
