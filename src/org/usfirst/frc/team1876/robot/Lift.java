package org.usfirst.frc.team1876.robot;

import edu.wpi.first.wpilibj.Solenoid;


public class Lift{

    private final int TS_port = 0;
    private final int BS_port = 1;

    private Solenoid TopStage;
    private Solenoid BottomStage;

    public Lift(){
        TopStage = new Solenoid(TS_port);
        BottomStage = new Solenoid(BS_port);
    }
    
    public void setStage (boolean A, boolean B){
        if(A){
            TopStage.set(true);
            BottomStage.set(true);
        }else{
            if(B){
                TopStage.set(true);
                BottomStage.set(false);                
            }else{
                TopStage.set(false);
                BottomStage.set(false);                
            }
        }
    }
}
