package frc.robot.commands.control_panel;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.Robot;

public class ControlPanelStageOne extends SequentialCommandGroup {
    public ControlPanelStageOne(){
    addCommands(new ControlPanelExtend(), new ControlPanelMotorStart(), new WaitCommand(3.0), 
    new ControlPanelMotorStop(), new ControlPanelContract());
    }
}


