//Found: https://github.com/STMARobotics/frc-7028-2020/blob/9cbe4d4594168554d8071f844c2e7cd5451bd47f/src/main/java/frc/robot/commands/RotateWheelCommand.java

package frc.robot.commands.control_panel;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ControlPanel;

/**
 * RotateWheelCommand
 */
public class RotateWheelCommand extends CommandBase {

  private final ControlPanel controlPanel;

  private String initialColor;
  private int colorCount;
  private boolean wasLastInitial;

  public RotateWheelCommand(ControlPanel controlPanel) {
    this.controlPanel = controlPanel;
  }

  @Override
  public void initialize() {
    initialColor = controlPanel.getColor();
    colorCount = 0;
    wasLastInitial = true;
  }

  @Override
  public void execute() {
    controlPanel.start();
    boolean isCurrentInitial = controlPanel.getColor().equals(initialColor);
    controlPanel.getColor();
    if (!wasLastInitial && isCurrentInitial) {
      colorCount++;
    }
    wasLastInitial = isCurrentInitial;
  }

  @Override
  public boolean isFinished() {
    return (colorCount >= 6) && !controlPanel.getColor().equals(initialColor);
  }

  @Override
  public void end(boolean interrupted) {
    controlPanel.stop();
  }

}