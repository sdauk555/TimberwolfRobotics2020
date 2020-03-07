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
import edu.wpi.first.wpilibj.util.Color;

public class SectorRed extends CommandBase {
  private final ColorMatch m_colorMatcher = new ColorMatch();
  private final Color kBlueTarget = ColorMatch.makeColor(0.143, 0.427, 0.429);

  /**
   * Creates a new SectorRed.
   */
  public SectorRed() {
    addRequirements(Robot.controlpanelSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_colorMatcher.addColorMatch(kBlueTarget);
    m_colorMatcher.setConfidenceThreshold(0.6);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Robot.controlpanelSubsystem.start();
    System.out.println(Robot.controlpanelSubsystem.getColor());
    System.out.println(m_colorMatcher.matchColor(kBlueTarget));
    System.out.println(m_colorMatcher);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.controlpanelSubsystem.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    Color detectedColor = Robot.controlpanelSubsystem.getColor();
    if (m_colorMatcher.matchColor(detectedColor) == null)
      return false;
    else
      return true;
  }
}
