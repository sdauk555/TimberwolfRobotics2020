package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.Robot;

/**
 * Add your docs here.
 */
public class ControlPanelMotorStop extends InstantCommand {
  /**
   * Add your docs here.
   */
  public ControlPanelMotorStop() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    addRequirements(Robot.controlpanelSubsystem);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
    Robot.controlpanelSubsystem.stop();
  }
}

