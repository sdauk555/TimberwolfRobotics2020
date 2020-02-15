/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.HopperMotorStop;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import frc.robot.RobotMap;

public class Hopper extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private static final PWMVictorSPX motor5 = new PWMVictorSPX(RobotMap.HopperMotor);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new HopperMotorStop());

  }

  public void run() {
    motor5.setSpeed(1);
  }

  public void stop(){
    motor5.setSpeed(0);
    }
}
