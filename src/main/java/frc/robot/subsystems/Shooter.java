/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.RobotMap;

import java.util.Map;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * Add your docs here.
 */
public class Shooter extends SubsystemBase {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private static final WPI_VictorSPX shooterMotor = new WPI_VictorSPX(RobotMap.shooterMotor);
  double defaultSpeed = -0.8;
  double defaultShootWaitTime = 2;

  private ShuffleboardTab testingTab = Shuffleboard.getTab("Testing");
  private NetworkTableEntry shooter = testingTab.add("Shooter", defaultSpeed).withWidget(BuiltInWidgets.kNumberSlider)
      .withProperties(Map.of("min", -1, "max", 1)).getEntry();
  private NetworkTableEntry shoot = testingTab.add("Shoot Wait Time", defaultShootWaitTime)
      .withWidget(BuiltInWidgets.kNumberSlider).withProperties(Map.of("min", 0, "max", 5)).getEntry();

  public double shootWait = shoot.getDouble(defaultShootWaitTime);

  public void shoot() {
    double shooterSpeed = shooter.getDouble(defaultSpeed);
    shooterMotor.set(ControlMode.PercentOutput, shooterSpeed);
  }

  public void shooterStop() {
    shooterMotor.set(ControlMode.PercentOutput, 0);
  }
}
