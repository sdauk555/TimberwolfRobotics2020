package frc.robot.commands.control_panel;

import frc.robot.Robot;
import edu.wpi.first.wpilibj2.command.InstantCommand;

public class ControlPanelExtend extends InstantCommand {

    public void ControlPanelDeploy() {
        addRequirements(Robot.controlpanelSubsystem);
    }

    @Override
    public void execute() {
        Robot.controlpanelSubsystem.controlpanelExtend();
    }

    @Override
    public void end(boolean interrupted) {
    }
}

