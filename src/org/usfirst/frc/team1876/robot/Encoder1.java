package org.usfirst.frc.team1876.robot;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;


public class Encoder1 {
	
	//http://robotics.francisparker.org/javadoc/
	//https://wpilib.screenstepslive.com/s/4485/m/13809/l/241875-encoders-measuring-rotation-of-a-wheel-or-other-shaft
	
	Encoder1 test;
	double maxPer;
	int minRate;
	int disPerPul;
	boolean isInvert;
	int sampToAver;
	
	public Encoder1(int portnum0, int portnum1, boolean isInvert, EncodingType k4x)
	{	
	
	test = new Encoder1(portnum0,portnum1,isInvert, Encoder.EncodingType.k4X);
	
	}

	public double getMaxPer() {
		return maxPer;
	}

	public void setMaxPer(double maxPer) {
		this.maxPer = maxPer;
	}

	public int getMinRate() {
		return minRate;
	}

	public void setMinRate(int minRate) {
		this.minRate = minRate;
	}

	public int getDisPerPul() {
		return disPerPul;
	}

	public void setDisPerPul(int disPerPul) {
		this.disPerPul = disPerPul;
	}

	public boolean isInvert() {
		return isInvert;
	}

	public void setInvert(boolean isInvert) {
		this.isInvert = isInvert;
	}

	public int getSampToAver() {
		return sampToAver;
	}

	public void setSampToAver(int sampToAver) {
		this.sampToAver = sampToAver;
	}
	
	public void settingUpEncoder(double aNum, int bNum, int cNum, boolean aBool, int dNum)
	{
		test.setMaxPer(aNum);
		test.setMinRate(bNum);
		test.setDisPerPul(cNum);
		test.setInvert(aBool);
		test.setSampToAver(dNum);
	}
}
