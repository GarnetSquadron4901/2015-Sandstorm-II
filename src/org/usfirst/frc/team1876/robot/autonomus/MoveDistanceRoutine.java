package org.usfirst.frc.team1876.robot.autonomus;

import org.usfirst.frc.team1876.robot.Drivetrain;

public class MoveDistanceRoutine {

	
	public void update (Drivetrain drivetrain) {
		double wheelCircumference = 3 * (Math.PI) * 2; // in inches

		double distanceToGo = 5 * 12; // in inches

		if (distanceToGo < wheelCircumference
				* (double) (drivetrain.getFLEncoder() / 360))
		{
			drivetrain.drive4D(1, 1);
		}
	}
}
