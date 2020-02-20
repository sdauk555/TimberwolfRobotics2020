package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.InstantCommand;

public class FeederContract extends InstantCommand {
    public FeederContract() {
        requires(Robot.feederSubsystem);
    }

    @Override
    protected void execute() {
        Robot.feederSubsystem.feederContract();
    }

    @Override
    protected void interrupted() {
    }
}