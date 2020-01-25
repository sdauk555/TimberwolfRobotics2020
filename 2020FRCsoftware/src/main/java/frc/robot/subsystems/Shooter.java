/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;

/**
 * Add your docs here.
 */
public class Shooter extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private static final WPI_TalonSRX shooterMotor = new WPI_TalonSRX(RobotMap.shooterMotor);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void shoot() {
    shooterMotor.set(ControlMode.PercentOutput, .1);
  }

  public void speedUp() {
    double speedIncrease = .1;
    double currentSpeed = shooterMotor.get();
    double fastSpeed = currentSpeed + speedIncrease;
    shooterMotor.set(ControlMode.PercentOutput, fastSpeed);
  }

  public void speedDown() {
    double speedDecrease = -.1;
    double currentSpeed = shooterMotor.get();
    double slowSpeed = currentSpeed + speedDecrease;
    shooterMotor.set(ControlMode.PercentOutput, slowSpeed);
  }

  public void shooterStop() {
    shooterMotor.set(ControlMode.PercentOutput, 0);
  }
}
