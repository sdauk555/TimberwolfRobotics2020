package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class PositionOne extends SequentialCommandGroup {

    public PositionOne() {
        addCommands(
            new AutoBack().withTimeout(3), 
            new AutoRight().withTimeout(3), 
            new AutoForward().withTimeout(3),
            new AutoLeft().withTimeout(3), 
            new AlignRobot().withTimeout(3));
        addCommands(
            new HopperMotorRun().alongWith(new ShooterRun()));
    }
}
//