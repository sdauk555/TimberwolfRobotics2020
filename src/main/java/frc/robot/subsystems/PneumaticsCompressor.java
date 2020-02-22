/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class PneumaticsCompressor extends SubsystemBase {
  /**
   * Creates a new PneumaticsCompressor.
   */
  public static final Compressor comp = new Compressor(RobotMap.compressor);

  public PneumaticsCompressor() {

  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  
  public void CompressorStart() {
    comp.start();
  }
        
  public void CompressorStop() {
    comp.stop();
  }
}
