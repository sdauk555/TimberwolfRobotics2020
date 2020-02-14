
package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.InstantCommand;

public class FeederDeploy extends InstantCommand {

    public FeederDeploy() {
        requires(Robot.pneumaticsSubsystem);
    }

    @Override
    protected void execute() {
        Robot.pneumaticsSubsystem.feederDeployment();

    }

    @Override
    protected void interrupted() {
    }

}