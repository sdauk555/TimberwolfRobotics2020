/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class FeederTest extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private static final WPI_VictorSPX feederMotor = new WPI_VictorSPX(RobotMap.feederMotor);
  double currentSpeed = 0;

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void feed() {
    feederMotor.set(ControlMode.PercentOutput, .1);
  }

  public void speedUp() {
    double speedIncrease = .1;
    //double currentSpeed = feederMotor.get();
    double fastSpeed = currentSpeed + speedIncrease;
    if (fastSpeed > 1.0) {
      fastSpeed = 1.0;
    }
    feederMotor.set(ControlMode.PercentOutput, fastSpeed);
    System.out.println(fastSpeed);
    currentSpeed = fastSpeed;
  }

  public void speedDown() {
    double speedDecrease = -.1;
    //double currentSpeed = feederMotor.get();
    double slowSpeed = currentSpeed + speedDecrease;
    if (slowSpeed < -1.0) {
      slowSpeed = -1.0;
    }
    feederMotor.set(ControlMode.PercentOutput, slowSpeed);
    System.out.println(slowSpeed);
    currentSpeed = slowSpeed;
  }

  public void feederStop() {
    feederMotor.set(ControlMode.PercentOutput, 0);
  }

  public void fullSpeed() {
    feederMotor.set(ControlMode.PercentOutput, 1);
  }

  public void fullReverse() {
    feederMotor.set(ControlMode.PercentOutput, -1);
  }
}
