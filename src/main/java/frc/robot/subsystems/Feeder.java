/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.RobotMap;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.motorcontrol.ControlMode;

public class Feeder extends SubsystemBase {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private static final WPI_VictorSPX FeederMotor = new WPI_VictorSPX(RobotMap.FeederMotor);
  
    // Starts the roller bar
    public void start() {
        FeederMotor.set(ControlMode.PercentOutput, .1);

    }
    
    // Stops the roller bar
    public void stop() {
        FeederMotor.set(ControlMode.PercentOutput, 0);

    }
    // Deploys the roller bar
    public void deploy() {

    }
    // Retracts the roller bar
    public void retract() {

    }
}
