/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.networktables.NetworkTableInstance;

public class VisionProcessing extends SubsystemBase {
  /**
   * Creates a new VisionProcessing.
   */
  NetworkTableInstance ntinst = NetworkTableInstance.getDefault();

  public VisionProcessing() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
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

  public double getArea() {
    return ntinst.getTable("contourPoints").getEntry("area").getDouble(-1); 
  }

  public double getMidPointX() {
    return ntinst.getTable("contourPoints").getEntry("midPointX").getDouble(-1);
  }

  public double getMidPointY() {
    return ntinst.getTable("contourPoints").getEntry("midPointY").getDouble(-1);
  }

  public boolean getResultsCheck() {
    return ntinst.getTable("contourPoints").getEntry("resultsCheck").getBoolean(false);
  }
}
