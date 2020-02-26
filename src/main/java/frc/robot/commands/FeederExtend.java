package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj2.command.InstantCommand;

public class FeederExtend extends InstantCommand {

    public void FeederDeploy() {
        addRequirements(Robot.feederSubsystem);
    }

    @Override
    public void execute() {
        Robot.feederSubsystem.feederExtend();
    }

    @Override
    public void end(boolean interrupted) {
    }
}
