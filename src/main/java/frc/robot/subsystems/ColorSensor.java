//Not entirely sure how this will work, it's an example.

/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;

import com.revrobotics.ColorSensorV3;

public class ColorSensor extends SubsystemBase {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  /**
   * Change the I2C port below to match the connection of your color sensor
   */
  
  public final I2C.Port i2cPort = I2C.Port.kOnboard;
  
  private final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);

  // public double getIR() {

  //   double IR = m_colorSensor.getIR();

  //   SmartDashboard.putNumber("IR", IR);

  //   return IR;
  // }

  public void getColor() {

    Color detectedColor = m_colorSensor.getColor();
    // System.out.println(detectedColor);

    SmartDashboard.putNumber("Red", detectedColor.red);
    SmartDashboard.putNumber("Green", detectedColor.green);
    SmartDashboard.putNumber("Blue", detectedColor.blue);

    //  return detectedColor;
  }
}