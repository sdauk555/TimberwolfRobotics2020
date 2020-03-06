package frc.robot.commands.control_panel;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class ControlPanelMotorStop extends CommandBase {

  public ControlPanelMotorStop() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.controlpanelSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Robot.controlpanelSubsystem.stop();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

}
