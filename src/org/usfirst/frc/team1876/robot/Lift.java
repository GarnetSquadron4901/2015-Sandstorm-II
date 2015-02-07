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
    
    public setStage(boolean TS, boolean BS){
        TopStage.set(TS);
        BottomStage.set(BS);
    }
}
