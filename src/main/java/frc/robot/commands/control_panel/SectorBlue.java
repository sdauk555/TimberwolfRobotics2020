/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.control_panel;
import frc.robot.Robot;

import edu.wpi.first.wpilibj2.command.CommandBase;
import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.util.Color;

public class SectorBlue extends CommandBase {

  private final ColorSensorV3 colorSensor = new ColorSensorV3(I2C.Port.kOnboard);
  private final ColorMatch m_colorMatcher = new ColorMatch();
  private final Color kBlueTarget = ColorMatch.makeColor(0.143, 0.427, 0.429);
  
  /**
   * Creates a new SectorBlue.
   */
  public SectorBlue() {
    addRequirements(Robot.controlpanelSubsystem); 

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Color detectedColor = colorSensor.getColor();
    ColorMatchResult match = m_colorMatcher.matchClosestColor(detectedColor);
    m_colorMatcher.addColorMatch(kBlueTarget);
  
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Robot.controlpanelSubsystem.getColor();
    Robot.controlpanelSubsystem.start();
    if ( colorSensor.getColor() == kBlueTarget)
    Robot.controlpanelSubsystem.stop();

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
