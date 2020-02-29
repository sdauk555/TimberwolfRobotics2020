package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class AgitatorStop extends CommandBase {

    public AgitatorStop() {
        addRequirements(Robot.agitatorSubsystem);
    }

    @Override
    public void execute() {
        Robot.agitatorSubsystem.stop();
    }

    @Override
    public void end(boolean interrupted) {
    }
}
