/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.DefaultCommand;
import frc.robot.commands.PrintNetTable;

/**
 * Add your docs here.
 */
public class VisionProcessing extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  NetworkTableInstance ntinst = NetworkTableInstance.getDefault();

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new PrintNetTable());
  }

  public void getCameraData() {
    ntinst.getTable("contourPoints").getEntry("area").getDouble(-1);
    ntinst.getTable("contourPoints").getEntry("midPointX").getDouble(-1);
    ntinst.getTable("contourPoints").getEntry("midPointY").getDouble(-1);
    ntinst.getTable("contourPoints").getEntry("resultsCheck").getBoolean(false);
  }

  public void printCameraData() {
    double area = ntinst.getTable("contourPoints").getEntry("area").getDouble(-1);
    double midX = ntinst.getTable("contourPoints").getEntry("midPointX").getDouble(-1);
    double midY = ntinst.getTable("contourPoints").getEntry("midPointY").getDouble(-1);
    boolean resultsCheck = ntinst.getTable("contourPoints").getEntry("resultsCheck").getBoolean(false);

    if (resultsCheck == true) {
      System.out.println(area);
      System.out.println(midX);
      System.out.println(midY);
    }
  }
}
