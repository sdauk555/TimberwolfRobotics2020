package frc.robot.commands.auto_commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.hopper.HopperMotorRun;
import frc.robot.commands.shooter.ShooterRun;

public class PositionOne extends SequentialCommandGroup {

    public PositionOne() {
        addCommands(
            new AutoBackward().withTimeout(3), 
            new AutoRight().withTimeout(3), 
            new AutoForward().withTimeout(3),
            new AutoLeft().withTimeout(3), 
            new AlignRobot().withTimeout(3));
        addCommands(
            new HopperMotorRun().alongWith(new ShooterRun()));
    }
}
//