/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.motorcontrol.ControlMode;

public class ControlPanel extends SubsystemBase {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private static final DoubleSolenoid ControlPanelSolenoid = new DoubleSolenoid(10, RobotMap.controlpanelExtend,
      RobotMap.controlpanelContract);
    private static final WPI_VictorSPX ControlPanelMotor = new WPI_VictorSPX(RobotMap.controlpanelMotor);
  
    // Starts the roller bar
    public void start() {
      ControlPanelMotor.set(ControlMode.PercentOutput, .1);
    }
    
    // Stops the roller bar
    public void stop() {
      ControlPanelMotor.stopMotor();
    }

    // moves pistons forward
    public void controlpanelExtend() {
      ControlPanelSolenoid.set(DoubleSolenoid.Value.kForward);
    }

    // moves pistons backward
    public void controlpanelContract() {
      ControlPanelSolenoid.set(DoubleSolenoid.Value.kReverse);
    }

    public void controlpanelSolenoidOff() {
      ControlPanelSolenoid.set(DoubleSolenoid.Value.kOff);
    }
}