package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.CommandBase;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class PositionOne extends SequentialCommandGroup {

    public PositionOne(){
        addCommands(new AutoBack().withTimeout(1), new AutoRight().withTimeout(.5), new AutoForward().withTimeout(1), new AutoLeft().withTimeout(.25), new AlignRobot().withTimeout(3));
        addCommands(new HopperMotorRun().alongWith(new ShooterRun()));
    }
}
