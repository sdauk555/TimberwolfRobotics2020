/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Compressor;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.motorcontrol.ControlMode;

public class Feeder extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    static final Compressor comp = new Compressor(10);
    //private static final Solenoid feederSolenoid = new Solenoid(0);
    private static final WPI_VictorSPX FeederMotor = new WPI_VictorSPX(RobotMap.FeederMotor);
  
    @Override
    public void initDefaultCommand(){

    } 

    public void pneumaticsStart() {
        Feeder.comp.start();
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
    public void feederIn() {
        //feederSolenoid.set(true);
    }

    // moves pistons backward
    public void feederOut() {
        //feederSolenoid.set(false);
    }
}
