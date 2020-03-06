/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.control_panel;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

/**
 * Add your docs here.
 */
public class ControlPanelMotorStart extends CommandBase {
  /**
   * Add your docs here.
   */
  public ControlPanelMotorStart() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    addRequirements(Robot.controlpanelSubsystem);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
    Robot.controlpanelSubsystem.start();
  }
}

