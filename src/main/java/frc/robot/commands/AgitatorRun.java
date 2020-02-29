package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class AgitatorRun extends CommandBase {

    public AgitatorRun() {
        addRequirements(Robot.agitatorSubsystem);
    }

    @Override
    public void execute() {
        Robot.agitatorSubsystem.run();
    }

    @Override
    public void end(boolean interrupted) {
    }
}