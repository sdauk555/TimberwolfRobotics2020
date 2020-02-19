package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.InstantCommand;

public class FeederOut extends InstantCommand {
    public FeederOut() {
        requires(Robot.feederSubsystem);
    }

    @Override
    protected void execute() {
        Robot.feederSubsystem.feederOut();
    }

    @Override
    protected void interrupted() {
    }
}