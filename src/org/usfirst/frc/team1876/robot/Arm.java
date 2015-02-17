package org.usfirst.frc.team1876.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Victor;

public class Arm{

  private final int ContainerARM_1 = 2;
  private final int ContainerARM_2 = 3;
  private final int CA_PWM = 2;
    
  private DoubleSolenoid ContainerGripper;
  private Victor ContainerARM;
  
  
  public Arm(){
      ContainerGripper = new DoubleSolenoid(ContainerARM_1, ContainerARM_2);
      ContainerARM = new Victor(CA_PWM);
  }
  
  public void ArmControl(double Arm_input){
      ContainerARM.set(Arm_input);
  }
  
  public void setArmStage(boolean RB){
      if(RB){
        ContainerGripper.set(DoubleSolenoid.Value.kForward);
      }else{
        ContainerGripper.set(DoubleSolenoid.Value.kReverse);      
      }
  }

}
