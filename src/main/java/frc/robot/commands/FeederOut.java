package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.InstantCommand;

public class FeederOut extends InstantCommand {
    public FeederOut() {
        requires(Robot.pneumaticsSubsystem);
    }

    @Override
    protected void execute() {
        Robot.pneumaticsSubsystem.feederOut();
    }

    @Override
    protected void interrupted() {
    }
}