/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.cameraserver.CameraServer;

/**
 * Add your docs here.
 */
public class Camera extends SubsystemBase {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public void addCamera() {
    CameraServer camera1 = CameraServer.getInstance();
    camera1.startAutomaticCapture("cam1", 0);
  }
}
