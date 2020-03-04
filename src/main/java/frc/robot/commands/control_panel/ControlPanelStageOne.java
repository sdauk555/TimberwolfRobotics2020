package frc.robot.commands.control_panel;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.Robot;

public class ControlPanelStageOne extends InstantCommand {
    public ControlPanelStageOne(){
        addRequirements(Robot.controlpanelSubsystem);
    }

    @Override
    public void initialize() {
    Robot.controlpanelSubsystem.ControlPanelStageOne();
  }
}

