package frc.robot.commands.control_panel;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import frc.robot.Robot;

public class ControlPanelStageOne extends SequentialCommandGroup {
    

    public ControlPanelStageOne() {
        addCommands(new ControlPanelExtend(),
                new WaitCommand(3),
                new ControlPanelMotorStart().withTimeout(3), 
                new ControlPanelMotorStop().withTimeout(1),
                new ControlPanelContract().withTimeout(1));
    }
}
