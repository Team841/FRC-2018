
// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc841.MyRobot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Solenoid;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static Encoder driveTrainLeftQuad2;
    public static Encoder driveTrainRightQuad1;
    public static WPI_TalonSRX driveTrainLeftDrive1;
    public static WPI_TalonSRX driveTrainLeftDrive3;
    public static WPI_TalonSRX driveTrainLeftDrive2;
    public static WPI_TalonSRX driveTrainRightDrive1;
    public static WPI_TalonSRX driveTrainRightDrive2;
    public static WPI_TalonSRX driveTrainRightDrive3;
    public static DigitalInput driveTrainAutoSelector2;
    public static DigitalInput driveTrainAutoSelector;
    public static WPI_VictorSPX elevatorLift1;
    public static WPI_VictorSPX elevatorLift2;
    public static DigitalInput clawHallEffect;
    public static DoubleSolenoid clawDeathGrip;
    public static WPI_TalonSRX clawElbow;
    public static DoubleSolenoid clawClawActuator;
    public static DigitalInput clawGrabSensor;
    public static WPI_VictorSPX clawRightSuck;
    public static WPI_VictorSPX clawLeftSuck;
    public static Solenoid clawTheSalute;
    public static DigitalInput clawCubeSensor;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveTrainLeftQuad2 = new Encoder(2, 3, false, EncodingType.k4X);
        LiveWindow.addSensor("DriveTrain", "LeftQuad 2", driveTrainLeftQuad2);
        driveTrainLeftQuad2.setDistancePerPulse(1.0);
        driveTrainLeftQuad2.setPIDSourceType(PIDSourceType.kRate);
        driveTrainRightQuad1 = new Encoder(0, 1, false, EncodingType.k4X);
        LiveWindow.addSensor("DriveTrain", "RightQuad 1", driveTrainRightQuad1);
        driveTrainRightQuad1.setDistancePerPulse(1.0);
        driveTrainRightQuad1.setPIDSourceType(PIDSourceType.kRate);
        driveTrainLeftDrive1 = new WPI_TalonSRX(6);
        
        
        driveTrainLeftDrive3 = new WPI_TalonSRX(4);
        
        
        driveTrainLeftDrive2 = new WPI_TalonSRX(5);
        
        
        driveTrainRightDrive1 = new WPI_TalonSRX(1);
        
        
        driveTrainRightDrive2 = new WPI_TalonSRX(2);
        
        
        driveTrainRightDrive3 = new WPI_TalonSRX(3);
        
        
        driveTrainAutoSelector2 = new DigitalInput(7);
        LiveWindow.addSensor("DriveTrain", "AutoSelector2", driveTrainAutoSelector2);
        
        driveTrainAutoSelector = new DigitalInput(6);
        LiveWindow.addSensor("DriveTrain", "AutoSelector", driveTrainAutoSelector);
        
        elevatorLift1 = new WPI_VictorSPX(0);
        
        
        elevatorLift2 = new WPI_VictorSPX(7);
        
        
        clawHallEffect = new DigitalInput(25);
        LiveWindow.addSensor("Claw", "HallEffect", clawHallEffect);
        
        clawDeathGrip = new DoubleSolenoid(0, 0, 1);
        LiveWindow.addActuator("Claw", "DeathGrip", clawDeathGrip);
        
        clawElbow = new WPI_TalonSRX(8);
        
        
        clawClawActuator = new DoubleSolenoid(0, 3, 4);
        LiveWindow.addActuator("Claw", "ClawActuator", clawClawActuator);
        
        clawGrabSensor = new DigitalInput(4);
        LiveWindow.addSensor("Claw", "GrabSensor", clawGrabSensor);
        
        clawRightSuck = new WPI_VictorSPX(9);
        
        
        clawLeftSuck = new WPI_VictorSPX(10);
        
        
        clawTheSalute = new Solenoid(0, 2);
        LiveWindow.addActuator("Claw", "TheSalute", clawTheSalute);
        
        clawCubeSensor = new DigitalInput(5);
        LiveWindow.addSensor("Claw", "CubeSensor", clawCubeSensor);
        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
}
}
