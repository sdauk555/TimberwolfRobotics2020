
package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj2.command.InstantCommand;

public class FeederDeploy extends InstantCommand {

    public FeederDeploy() {
        addRequirements(Robot.pneumaticsSubsystem);
    }

    @Override
    public void execute() {
        Robot.pneumaticsSubsystem.feederDeployment();

    }

    @Override
    public void end(boolean interrupted) {
    }

}