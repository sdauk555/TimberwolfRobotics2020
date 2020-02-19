package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.InstantCommand;

public class FeederIn extends InstantCommand {

    public FeederIn() {
        requires(Robot.pneumaticsSubsystem);
    }

    @Override
    protected void execute() {
        Robot.pneumaticsSubsystem.feederIn();
    }

    @Override
    protected void interrupted() {
    }
}
