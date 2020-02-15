

package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 * Add your docs here.
 */
public class ShooterFullForward extends InstantCommand {
  /**
   * Add your docs here.
   */
  public ShooterFullForward() {
    super();
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.shooterTestSubsystem);
  }

  // Called once when the command executes
  @Override
  protected void execute() {
    Robot.shooterTestSubsystem.fullSpeed();
  }

}
