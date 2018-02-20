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

import org.usfirst.frc841.lib.*;
import org.usfirst.frc841.MyRobot.RobotMap;
import org.usfirst.frc841.MyRobot.commands.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.SensorCollection;
import com.ctre.phoenix.motorcontrol.can.*;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class Claw extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final WPI_TalonSRX elbow = RobotMap.clawElbow;
    private final WPI_VictorSPX rightSuck = RobotMap.clawRightSuck;
    private final DoubleSolenoid clawActuator = RobotMap.clawClawActuator;
    private final DigitalInput grabSensor = RobotMap.clawGrabSensor;
    private final DigitalInput cubeSensor = RobotMap.clawCubeSensor;
    private final WPI_VictorSPX leftSuck = RobotMap.clawLeftSuck;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    //constructor
    public void Claw() {
    elbow.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
    elbow.setInverted(false);
    elbow.configNominalOutputForward(0, 10);
    elbow.configNominalOutputReverse(0, 10);
	elbow.configPeakOutputForward(1, 10);
	elbow.configPeakOutputReverse(-1, 10);
    elbow.configAllowableClosedloopError(0, 0, 10);
    elbow.config_kF(0, 0.0, 10);
	elbow.config_kP(0, C.c_p, 10);
	elbow.config_kI(0, C.c_i, 10);
	elbow.config_kD(0, C.c_d, 10);
	

    }
    @Override
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        setDefaultCommand(new UpdateClaw());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop

    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    public void suckIn() {
    	leftSuck.set(0.5);
    	rightSuck.set(-0.5);
    }
    public void stopSuck() {
    	leftSuck.set(0);
    	rightSuck.set(0);
    }
   public void spitOut() {
   		leftSuck.set(-0.5);
   		rightSuck.set(0.5);
   }
   public void openClaw() {
	   clawActuator.set(DoubleSolenoid.Value.kForward);
   }
   public void closeClaw() {
	   clawActuator.set(DoubleSolenoid.Value.kReverse);
	   
   }
   public boolean isGrab() {
	   return grabSensor.get();
	   
   }
   
   public boolean isCubeGot() {
	   return cubeSensor.get();
	   
   }
   
   public void zeroElbow() {
	   SensorCollection lim =   elbow.getSensorCollection();
	   if(lim.isFwdLimitSwitchClosed()) {
		   elbow.setSelectedSensorPosition(0, 0, 10);
	   }
   }
   	
   
}
