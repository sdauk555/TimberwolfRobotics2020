package frc.robot.commands.control_panel;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;

public class ControlPanelStageOne extends SequentialCommandGroup {

    public ControlPanelStageOne() {
        addCommands(new ControlPanelExtend(), new WaitCommand(3), new ControlPanelMotorStart().withTimeout(3),
                new ControlPanelMotorStop().withTimeout(1), new ControlPanelContract().withTimeout(1));
    }
}
