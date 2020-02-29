/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import java.util.Map;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Robot;

public class Autonomous extends SubsystemBase {
  /**
   * Creates a new Autonomous.
   */
  private ShuffleboardTab autoForwardTab = Shuffleboard.getTab("Autonomous");
  private NetworkTableEntry forward = autoForwardTab.add("Forward", 0.5).withWidget(BuiltInWidgets.kNumberSlider)
      .withProperties(Map.of("min", 0, "max", 1)).getEntry();

  private ShuffleboardTab autoBackwardTab = Shuffleboard.getTab("Autonomous");
  private NetworkTableEntry backward = autoBackwardTab.add("Backward", -0.5).withWidget(BuiltInWidgets.kNumberSlider)
      .withProperties(Map.of("min", -1, "max", 0)).getEntry();

  private ShuffleboardTab autoRightTab = Shuffleboard.getTab("Autonomous");
  private NetworkTableEntry right = autoRightTab.add("Right", 0.5).withWidget(BuiltInWidgets.kNumberSlider)
      .withProperties(Map.of("min", 0, "max", 1)).getEntry();

  private ShuffleboardTab autoLeftTab = Shuffleboard.getTab("Autonomous");
  private NetworkTableEntry left = autoLeftTab.add("Left", -0.5).withWidget(BuiltInWidgets.kNumberSlider)
      .withProperties(Map.of("min", -1, "max", 0)).getEntry();

  public Autonomous() {
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void autoForward() {
    double forwardSpeed = forward.getDouble(0.5);
    Robot.driveSubsystem.driveSystem(forwardSpeed, 0);
  }

  public void autoBackward() {
    double backwardSpeed = backward.getDouble(-0.5);
    Robot.driveSubsystem.driveSystem(backwardSpeed, 0);
  }

  public void autoRight() {
    double rightSpeed = right.getDouble(0.5);
    Robot.driveSubsystem.driveSystem(0, rightSpeed);
  }

  public void autoLeft() {
    double leftSpeed = left.getDouble(-0.5);
    Robot.driveSubsystem.driveSystem(0, leftSpeed);
  }

  public void visionAlign() {
    double midX = Robot.visionSubsystem.getMidPointX();
    boolean resultscheck = Robot.visionSubsystem.getResultsCheck();

    if (resultscheck == false) {
      return;
    } else if (midX < -0.1) {
      Robot.driveSubsystem.driveSystem(0, 0.1);
    } else if (midX > 0.1) {
      Robot.driveSubsystem.driveSystem(0, -0.1);
    } else if (midX > -0.1 && midX < 0.1) {
      Robot.driveSubsystem.driveSystem(0, 0);
    }
  }
}
