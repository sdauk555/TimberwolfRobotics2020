package frc.robot.commands.auto_commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Robot;

public class PositionOne extends SequentialCommandGroup {

    public PositionOne() {
        addCommands(new AutoBackward().withTimeout(Robot.autonomousSubsystem.backwardRun),
                new AutoRight().withTimeout(Robot.autonomousSubsystem.rightRun),
                new AutoForward().withTimeout(Robot.autonomousSubsystem.forwardRun),
                new AutoLeft().withTimeout(Robot.autonomousSubsystem.leftRun),
                new AlignRobot().withTimeout(Robot.autonomousSubsystem.alignRun),
                new AutoShoot().withTimeout(Robot.autonomousSubsystem.shootRun),
                new AutoBackward().withTimeout(Robot.autonomousSubsystem.backwardRun));
                new AutoRight().withTimeout(Robot.autonomousSubsystem.rightRun);
                new AutoTurnAround().withTimeout(Robot.autonomousSubsystem.turnAround);
    }
}