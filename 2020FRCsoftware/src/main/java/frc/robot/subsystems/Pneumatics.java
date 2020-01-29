/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
//From 5839

import edu.wpi.first.wpilibj.Compressor;
//import frc.robot.RobotMap;
//import edu.wpi.first.wpilibj.GenericHID.Hand;
//import edu.wpi.first.wpilibj.GenericHID;



public class Pneumatics extends Subsystem {
    private static final Compressor comp = new Compressor(0);

    private DoubleSolenoid doubleSolenoid;
    //From 5839
    
    
    public void start(){
        Pneumatics.comp.start();
        Pneumatics.comp.setClosedLoopControl(true);
        
    }
    public void forward(){
        doubleSolenoid.set(DoubleSolenoid.Value.kForward);
        //From 5839
    }
    
    public void reverse(){
        doubleSolenoid.set(DoubleSolenoid.Value.kReverse);
        //From 5839
    }

    public void off(){
        doubleSolenoid.set(Value.kOff);
    }
    @Override
    protected void initDefaultCommand() {

    }
}
