/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import java.util.Map;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class Hopper extends SubsystemBase {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private static final WPI_VictorSPX hopperMotor = new WPI_VictorSPX(RobotMap.hopperMotor);
  private ShuffleboardTab hopperTab = Shuffleboard.getTab("Testing");
  private NetworkTableEntry hopper = hopperTab.add("Hopper", -.7).withWidget(BuiltInWidgets.kNumberSlider)
      .withProperties(Map.of("min", -1, "max", 1)).getEntry();

  public void run() {
    double hopperSpeed = hopper.getDouble(-.7);
    hopperMotor.set(ControlMode.PercentOutput, hopperSpeed);
  }

  public void stop() {
    hopperMotor.set(ControlMode.PercentOutput, 0);
  }
}
