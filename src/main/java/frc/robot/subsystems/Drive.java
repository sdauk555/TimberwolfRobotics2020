/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Robot;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Drive extends SubsystemBase {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private static final XboxController controller1 = new XboxController(RobotMap.driverController);
  private static final PWMVictorSPX motor1 = new PWMVictorSPX(RobotMap.leftMotors[0]);
  private static final PWMVictorSPX motor2 = new PWMVictorSPX(RobotMap.leftMotors[1]);
  private static final PWMVictorSPX motor3 = new PWMVictorSPX(RobotMap.rightMotors[0]);
  private static final PWMVictorSPX motor4 = new PWMVictorSPX(RobotMap.rightMotors[1]);
  SpeedControllerGroup leftmotors = new SpeedControllerGroup(motor1, motor2);
  SpeedControllerGroup rightmotors = new SpeedControllerGroup(motor3, motor4);
  DifferentialDrive maindrive = new DifferentialDrive(leftmotors, rightmotors);

  public void driveSystem() {
    double analogLY = controller1.getY(Hand.kLeft);
    double analogLX = controller1.getX(Hand.kLeft);
    maindrive.arcadeDrive(analogLY, analogLX, isTriggered());
  }

  public void driveSystem(double speed, double zRotation) {
    maindrive.arcadeDrive(speed, zRotation, false);
  }

  public void stopDrive() {
    maindrive.stopMotor();
  }

  public boolean isTriggered() {
    double triggerValue = Robot.CONTROLLERBINDING.driverController.getRawAxis(3);
    return triggerValue > 0.3;
  }

}
