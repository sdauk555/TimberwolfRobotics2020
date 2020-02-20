package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.InstantCommand;

public class FeederExtend extends InstantCommand {

    public FeederExtend() {
        requires(Robot.feederSubsystem);
    }

    @Override
    protected void execute() {
        Robot.feederSubsystem.feederExtend();
    }

    @Override
    protected void interrupted() {
    }
}
