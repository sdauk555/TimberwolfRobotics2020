/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Robot;

public class Autonomous extends SubsystemBase {
  /**
   * Creates a new Autonomous.
   */
  public Autonomous() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void autoForward() {
    Robot.driveSubsystem.driveSystem();
  }

  public void autoBackward() {
    Robot.driveSubsystem.driveSystem();
  }

  public void autoRight() {
    Robot.driveSubsystem.driveSystem();
  }

  public void autoLeft() {
    Robot.driveSubsystem.driveSystem();
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
