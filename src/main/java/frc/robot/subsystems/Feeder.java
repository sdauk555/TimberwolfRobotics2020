/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.motorcontrol.ControlMode;

public class Feeder extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private static final DoubleSolenoid feederSolenoid = new DoubleSolenoid(10, RobotMap.feederExtend, RobotMap.feederContract);
    private static final WPI_VictorSPX FeederMotor = new WPI_VictorSPX(RobotMap.FeederMotor);
  
    @Override
    public void initDefaultCommand(){
    } 

    // Starts the roller bar
    public void start() {
        FeederMotor.set(ControlMode.PercentOutput, .1);
    }
    
    // Stops the roller bar
    public void stop() {
        FeederMotor.stopMotor();
    }

    // moves pistons forward
    public void feederExtend() {
        feederSolenoid.set(DoubleSolenoid.Value.kForward);
    }

    // moves pistons backward
    public void feederContract() {
        feederSolenoid.set(DoubleSolenoid.Value.kReverse);
    }

    public void feederSolenoidOff() {
        feederSolenoid.set(DoubleSolenoid.Value.kOff);
    }
}