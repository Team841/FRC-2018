// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc841.MyRobot.subsystems;

import org.usfirst.frc841.MyRobot.RobotMap;
import org.usfirst.frc841.MyRobot.commands.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Joystick;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class DriveTrain extends Subsystem {
	  /**
		 * constructor to set up encoders, PID loop, and Speed control current limits. 
		 */
		
			

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final Encoder leftQuad2 = RobotMap.driveTrainLeftQuad2;
    private final Encoder rightQuad1 = RobotMap.driveTrainRightQuad1;
    private final WPI_TalonSRX leftDrive1 = RobotMap.driveTrainLeftDrive1;
    private final WPI_TalonSRX leftDrive2 = RobotMap.driveTrainLeftDrive2;
    private final WPI_TalonSRX leftDrive3 = RobotMap.driveTrainLeftDrive3;
    private final WPI_TalonSRX rightDrive1 = RobotMap.driveTrainRightDrive1;
    private final WPI_TalonSRX rightDrive2 = RobotMap.driveTrainRightDrive2;
    private final WPI_TalonSRX rightDrive3 = RobotMap.driveTrainRightDrive3;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    //Variables used for Cheesy Poofs Drive Style
    
    boolean isHighGear = false;
    private double oldWheel = 0.0;
    private double quickStopAccumulator = 0;
    private double throttleDeadband = 0.02;
    private double wheelDeadband = 0.02;
    private double sensitivityHigh = 0.85; 
    private double sensitivityLow = 0.75;
    private boolean isQuickTurn = false;
    private boolean isStraight = false;
    public DriveTrain(){
		leftDrive1.configContinuousCurrentLimit(C.currentlimit, C.currenttimeout);
	    leftDrive2.configContinuousCurrentLimit(C.currentlimit, C.currenttimeout);
	    leftDrive3.configContinuousCurrentLimit(C.currentlimit, C.currenttimeout);
		rightDrive1.configContinuousCurrentLimit(C.currentlimit, C.currenttimeout);
		rightDrive2.configContinuousCurrentLimit(C.currentlimit, C.currenttimeout);
		rightDrive3.configContinuousCurrentLimit(C.currentlimit, C.currenttimeout);
		leftDrive1.enableCurrentLimit(false);
		leftDrive2.enableCurrentLimit(false);
	    leftDrive3.enableCurrentLimit(false);
		rightDrive1.enableCurrentLimit(false);
		rightDrive2.enableCurrentLimit(false);
		rightDrive3.enableCurrentLimit(false);
	}
    
    @Override
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        setDefaultCommand(new Drive());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
    

public void Drive(Joystick stick){
   // if (!this.EnablePID){
    cheesyDrive(stick);
    //tankDrive(stick);
    //}
}
//Set the power on the left and right motor drive
public void SetLeftRight(double LPower, double RPower){
	//this.PIDOutput = LPower; 
	leftDrive1.set(-1*LPower);
	leftDrive2.set(-1*LPower);
	leftDrive3.set(-1*LPower);
	rightDrive1.set(RPower);
	rightDrive2.set(RPower);
	rightDrive3.set(RPower);

}
//Shift drive to high gear and update memory
public void SetHighGear(){

	isHighGear = true;
}
//Shift drive train to low gear and update memory
public void SetLowGear(){
	isHighGear = false;
}
//returns the Yaxis value of te left joystck
public double getThrottle(Joystick stick){
	return stick.getY();
}
//returns the Xaxis value of the right joystick
public double getWheel(Joystick stick){
    return stick.getZ();
}
//returns the Yaxis value of the left joystick
public double getYAxisLeftSide(Joystick stick){
    return stick.getY();
}
//returns the Yaxis value of the right joystick
public double getYAxisRightSide(Joystick stick){
    return stick.getThrottle();
}

//Tank drive style code
public void tankDrive(Joystick stick){
    double axisNonLinearity;
    //Get Y axis and make a deadband 
    double leftY =  handleDeadband(getYAxisLeftSide(stick),0.02);
    double rightY =  handleDeadband(getYAxisRightSide(stick),0.02);
    
    
     if (isHighGear) {
        axisNonLinearity = 0.5;
        // Smooth the controls on Left side
        leftY = Math.sin(Math.PI / 2.0 * axisNonLinearity * leftY) /
            Math.sin(Math.PI / 2.0 * axisNonLinearity);
        leftY = Math.sin(Math.PI / 2.0 * axisNonLinearity * leftY) /
            Math.sin(Math.PI / 2.0 * axisNonLinearity);
     
        //Smooth the controls on Right side
        rightY = Math.sin(Math.PI / 2.0 * axisNonLinearity * rightY) /
            Math.sin(Math.PI / 2.0 * axisNonLinearity);
        rightY = Math.sin(Math.PI / 2.0 * axisNonLinearity * rightY) /
            Math.sin(Math.PI / 2.0 * axisNonLinearity);
        }
        else{
            axisNonLinearity = 0.5;
        // Smooth the controls on Left side
        leftY = Math.sin(Math.PI / 2.0 * axisNonLinearity * leftY) /
            Math.sin(Math.PI / 2.0 * axisNonLinearity);
        leftY = Math.sin(Math.PI / 2.0 * axisNonLinearity * leftY) /
            Math.sin(Math.PI / 2.0 * axisNonLinearity);
     
        //Smooth the controls on Right side
        rightY = Math.sin(Math.PI / 2.0 * axisNonLinearity * rightY) /
            Math.sin(Math.PI / 2.0 * axisNonLinearity);
        rightY = Math.sin(Math.PI / 2.0 * axisNonLinearity * rightY) /
            Math.sin(Math.PI / 2.0 * axisNonLinearity);
        }
    
        //set the motors
        SetLeftRight(leftY,rightY);
    
}

//Enable quick turn AKA classical Archade drive
public void setQuickTurn(){
isQuickTurn = true;
}
//Disable quick turn
public void resetQuickTurn(){
isQuickTurn = false;
}
//Slim down version of the Cheesy Poofs drive style.
public void cheesyDrive(Joystick stick){
    
    //Note quickturn and shift is taken care of with buttons in OI.
    
    double wheelNonLinearity;
    double wheel = handleDeadband(getWheel(stick),wheelDeadband); //double wheel = handleDeadband(controlBoard.rightStick.getX(), wheelDeadband);
    double throttle = - handleDeadband(getThrottle(stick),throttleDeadband);
    double negInertia = wheel - oldWheel;
   /* 
    if(getAverageSpeed()> 2000){
        SetHighGear();
    }
    else if (getAverageSpeed() < 1500){
      SetLowGear();
    }
     */  
            
    oldWheel = wheel;
    if (isHighGear) {
        wheelNonLinearity = 0.6;
        // Apply a sin function that's scaled to make it feel better.
        wheel = Math.sin(Math.PI / 2.0 * wheelNonLinearity * wheel) /
        Math.sin(Math.PI / 2.0 * wheelNonLinearity);
        wheel = Math.sin(Math.PI / 2.0 * wheelNonLinearity * wheel) /
        Math.sin(Math.PI / 2.0 * wheelNonLinearity);
    } else {
        wheelNonLinearity = 0.5;
        // Apply a sin function that's scaled to make it feel better.
        wheel = Math.sin(Math.PI / 2.0 * wheelNonLinearity * wheel) /
        Math.sin(Math.PI / 2.0 * wheelNonLinearity);
        wheel = Math.sin(Math.PI / 2.0 * wheelNonLinearity * wheel) /
        Math.sin(Math.PI / 2.0 * wheelNonLinearity);
        wheel = Math.sin(Math.PI / 2.0 * wheelNonLinearity * wheel) /
        Math.sin(Math.PI / 2.0 * wheelNonLinearity);
    }
    
    double leftPwm, rightPwm, overPower;
    double sensitivity = 1.7;
    double angularPower;
    double linearPower;
    // Negative inertia!
    double negInertiaAccumulator = 0.0;
    double negInertiaScalar;
    
    
    if (isHighGear) {
        negInertiaScalar = 5.0;
        sensitivity = sensitivityHigh; //sensitivity = Constants.sensitivityHigh.getDouble();
    } else {
        if (wheel * negInertia > 0) {
            negInertiaScalar = 2.5;
        } else {
            if (Math.abs(wheel) > 0.65) {
                negInertiaScalar = 5.0;
            } else {
                negInertiaScalar = 3.0;
            }
        }
        sensitivity = sensitivityLow;   //sensitivity = Constants.sensitivityLow.getDouble();
        if (Math.abs(throttle) > 0.1) {
   // sensitivity = 1.0 - (1.0 - sensitivity) / Math.abs(throttle);
        }
    }
    
    
    double negInertiaPower = negInertia * negInertiaScalar;
    negInertiaAccumulator += negInertiaPower;
    wheel = wheel + negInertiaAccumulator;
    if (negInertiaAccumulator > 1) {
        negInertiaAccumulator -= 1;
    } else if (negInertiaAccumulator < -1) {
        negInertiaAccumulator += 1;
    } else {
        negInertiaAccumulator = 0;
    }
    linearPower = throttle;
    // Quickturn!
    if (isQuickTurn) {
        if (Math.abs(linearPower) < 0.2) {
            double alpha = 0.1;
            quickStopAccumulator = (1 - alpha) * quickStopAccumulator + alpha * limit(wheel, 1.0) * 5;
        }
        overPower = 1.0;
        if (isHighGear) {
            sensitivity = 1.0;
        } else {
            sensitivity = 0.5;
            
        }
        angularPower = wheel;
    } else {
        overPower = 0.0;
        angularPower = Math.abs(throttle) * wheel * sensitivity - quickStopAccumulator;
        if (quickStopAccumulator > 1) {
            quickStopAccumulator -= 1;
        } else if (quickStopAccumulator < -1) {
            quickStopAccumulator += 1;
        } else {
            quickStopAccumulator = 0.0;
        }
    }
    rightPwm = leftPwm = linearPower;
    leftPwm += angularPower;
    rightPwm -= angularPower;
    if (leftPwm > 1.0) {
        rightPwm -= overPower * (leftPwm - 1.0);
        leftPwm = 1.0;
    } else if (rightPwm > 1.0) {
        leftPwm -= overPower * (rightPwm - 1.0);
    rightPwm = 1.0;
    } else if (leftPwm < -1.0) {
        rightPwm += overPower * (-1.0 - leftPwm);
        leftPwm = -1.0;
    } else if (rightPwm < -1.0) {
        leftPwm += overPower * (-1.0 - rightPwm);
        rightPwm = -1.0;
    } 
    SetLeftRight(leftPwm,-rightPwm);
    
}   

//If the value is too small make it zero. 
public double handleDeadband(double val, double deadband) {
    return (Math.abs(val) > Math.abs(deadband)) ? val : 0.0;
}
public static double limit(double v, double limit) {
    return (Math.abs(v) < limit) ? v : limit * (v < 0 ? -1 : 1);
}

    @Override
    public void periodic() {
        // Put code here to be run every loop

    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

}
