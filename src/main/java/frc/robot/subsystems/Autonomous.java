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
  double defaultForward = 0.5;
  double defaultBackward = -0.5;
  double defaultRight = 0.5;
  double defaultLeft = -0.5;
  double defaultDriveTime = 0.5;
  double defaultShootTime = 5;

  private ShuffleboardTab autonomousTab = Shuffleboard.getTab("Autonomous");

  private NetworkTableEntry forward = autonomousTab.add("Forward", defaultForward)
      .withWidget(BuiltInWidgets.kNumberSlider).withProperties(Map.of("min", -1, "max", 1)).getEntry();

  private NetworkTableEntry backward = autonomousTab.add("Backward", defaultBackward)
      .withWidget(BuiltInWidgets.kNumberSlider).withProperties(Map.of("min", -1, "max", 1)).getEntry();

  private NetworkTableEntry right = autonomousTab.add("Right", defaultRight).withWidget(BuiltInWidgets.kNumberSlider)
      .withProperties(Map.of("min", -1, "max", 1)).getEntry();

  private NetworkTableEntry left = autonomousTab.add("Left", defaultLeft).withWidget(BuiltInWidgets.kNumberSlider)
      .withProperties(Map.of("min", -1, "max", 1)).getEntry();

  private NetworkTableEntry waitShoot = autonomousTab.add("Shooter Run Time", defaultShootTime)
      .withWidget(BuiltInWidgets.kNumberSlider).withProperties(Map.of("min", 0, "max", 10)).getEntry();
  
  private NetworkTableEntry waitForward = autonomousTab.add("Forward Run Time", defaultDriveTime)
      .withWidget(BuiltInWidgets.kNumberSlider).withProperties(Map.of("min", 0, "max", 10)).getEntry();

  private NetworkTableEntry waitBackward = autonomousTab.add("Backward Run Time", defaultDriveTime)
      .withWidget(BuiltInWidgets.kNumberSlider).withProperties(Map.of("min", 0, "max", 10)).getEntry();

  private NetworkTableEntry waitRight = autonomousTab.add("Right Run Time", defaultDriveTime)
      .withWidget(BuiltInWidgets.kNumberSlider).withProperties(Map.of("min", 0, "max", 10)).getEntry();

  private NetworkTableEntry waitLeft = autonomousTab.add("Left Run Time", defaultDriveTime)
      .withWidget(BuiltInWidgets.kNumberSlider).withProperties(Map.of("min", 0, "max", 10)).getEntry();

  public double shootRun = waitShoot.getDouble(defaultShootTime);
  public double forwardRun = waitForward.getDouble(defaultDriveTime);
  public double backwardRun = waitBackward.getDouble(defaultDriveTime);
  public double rightRun = waitRight.getDouble(defaultDriveTime);
  public double leftRun = waitLeft.getDouble(defaultDriveTime);

  public Autonomous() {
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void autoForward() {
    double forwardSpeed = forward.getDouble(defaultForward);
    Robot.driveSubsystem.driveSystem(forwardSpeed, 0);
  }

  public void autoBackward() {
    double backwardSpeed = backward.getDouble(defaultBackward);
    Robot.driveSubsystem.driveSystem(backwardSpeed, 0);
  }

  public void autoRight() {
    double rightSpeed = right.getDouble(defaultRight);
    Robot.driveSubsystem.driveSystem(0, rightSpeed);
  }

  public void autoLeft() {
    double leftSpeed = left.getDouble(defaultLeft);
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
