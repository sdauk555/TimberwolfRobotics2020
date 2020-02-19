package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.InstantCommand;

public class FeederIn extends InstantCommand {

    public FeederIn() {
        requires(Robot.feederSubsystem);
    }

    @Override
    protected void execute() {
        Robot.feederSubsystem.feederIn();
    }

    @Override
    protected void interrupted() {
    }
}
