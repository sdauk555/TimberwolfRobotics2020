/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class FeederTest extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void feed() {
    FeederMotor.set(ControlMode.PercentOutput, .1);
  }

public void speedUp() {
    double speedIncrease = .1;
    double currentSpeed = FeederMotor.get();
    double fastSpeed = currentSpeed + speedIncrease;
    if (fastSpeed > 1.0) {
      fastSpeed = 1.0;
    }
    FeederMotor.set(ControlMode.PercentOutput, fastSpeed);
  }

public void speedDown() {
    double speedDecrease = -.1;
    double currentSpeed = FeederMotor.get();
    double slowSpeed = currentSpeed + speedDecrease;
    if (slowSpeed < -1.0) {
      slowSpeed = -1.0;
    }
    FeederMotor.set(ControlMode.PercentOutput, slowSpeed);
  }

public void feederStop() {
    FeederMotor.set(ControlMode.PercentOutput, 0);
  }
}
