package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class HopperMotorRun extends CommandBase {

    public HopperMotorRun() {
        addRequirements(Robot.hopperSubsystem);
    }

    @Override
    public void execute() {
        Robot.hopperSubsystem.run();
    }

    @Override
    public void end(boolean interrupted) {
    }
}
