
package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 * Add your docs here.
 */
public class FeederSlow extends InstantCommand {
  /**
   * Add your docs here.
   */
  public FeederSlow() {
    super();
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.feederTestSubsystem);
  }

  // Called once when the command executes
  @Override
  protected void execute() {
    Robot.feederTestSubsystem.speedDown();
  }
}
