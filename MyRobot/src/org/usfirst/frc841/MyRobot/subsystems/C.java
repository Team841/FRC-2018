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
    public static final double c_p = 0;
    public static final double c_i = 0;
    public static final double c_d = 0;
    public static final int c_izone = 0;
    public static final double c_ramprate = 100;
    
 
	// AUTONOMOUS CONSTANTS
	public static final double autoDrivingDistance = .5; // In time, is seconds driving from the starting point to one of the nodes of movement in the autonomous mode.
	public static final double autoTurningDistance = .4; // In time, is seconds to turn until 45 degrees from a 0 turning speed.	
	public static final double autoMotorSpeed = .5;
	public static final double autoMotorLowSpeed = .3;
	//public static int nAutonomousMode = 0;
	
	
	
}
