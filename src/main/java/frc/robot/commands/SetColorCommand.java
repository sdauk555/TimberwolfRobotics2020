//Found: https://github.com/STMARobotics/frc-7028-2020/blob/9cbe4d4594168554d8071f844c2e7cd5451bd47f/src/main/java/frc/robot/commands/SetColorCommand.java

package frc.robot.commands;

import java.util.Collections;
import java.util.Map;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ControlPanel;


public class SetColorCommand extends CommandBase {

  private static final Map<String, String> colorMap = Collections.unmodifiableMap(Map.of(
      "G", "Yellow",
      "B", "Red",
      "Y", "Green",
      "R", "Blue"
  ));

  private final ControlPanel controlPanel;
  private String targetColor;

  public SetColorCommand(ControlPanel controlPanel) {
    this.controlPanel = controlPanel;
  }

  @Override
  public void initialize() {
    String gameData = DriverStation.getInstance().getGameSpecificMessage();
    targetColor = colorMap.get(gameData);
  }

  @Override
  public void execute() {
    controlPanel.start();
  }

  @Override
  public boolean isFinished() {
    if (targetColor == null) {
      return true;
    }
    return targetColor == controlPanel.getColor();
  }

  @Override
  public void end(boolean interrupted) {
    controlPanel.stop();
  }

}