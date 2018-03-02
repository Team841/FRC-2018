/**
 * 
 */
package org.usfirst.frc841.MyRobot.subsystems;

/**
 * In this class we are storing all the constants and tunings used in all the commands and subsystems
 * @author Team841-P01
 *
 */
public class C {

	private C(){
		// Prevents instantiation
	}

	// STRUCTURE OF THE CONSTANTS CONTAINED IN THIS DOCUMENT
	//public static final double test = 10.001;	
	
	// CONSTANTS FOR THE DRIVETRAIN
	public static final double throttleDeadband = 0.02; 
	public static final double wheelDeadband = 0.02;	
	public static final double sensitivityHigh = 0.85;	
	public static final double sensitivityLow = 0.75;
	public static final double centervalue = 140;
	public static final double tolerance = 10;
	public static final int currentlimit = 25;
	public static final int currentPeak = 0;
	public static final int currenttimeout =10;
	
	// Settings for Quad Encoder
	public static final int pulsePerRev =20;
    public static final double wheelDiameter = 6; //in inches  
    public static double gearRatio = 0.1152;
    
    //AutoMode Constants
    public double[][] Path1 = new double [][] {
    	{ 0,0 },
    	{ 2,3 }
    };
    
    public double TotalTime = 12;
    public double TimeStep = 0.1;
    public double robotTrackWidth = 2.167;
    
    
    //Claw PID Loop
    public static final double c_p = 0.00022;
    public static final double c_i = 0.0000;
    public static final double c_d = 0.00003;
    public static final double c_offset = 0;
    
    
    //Claw PID Loop
    public static final double cl_p = 0.00015;
    public static final double cl_i = 0.0000;
    public static final double cl_d = 0.00003;
    
    public static final double claw_dwn = 2972;
    public static final double claw_mid = 5500;
    public static final double claw_up = 6055;
    
    public static final int intake_stop = 0;
    public static final int intake_suck = 1;
    public static final int intake_spit = 2;
    
   
    
    
}