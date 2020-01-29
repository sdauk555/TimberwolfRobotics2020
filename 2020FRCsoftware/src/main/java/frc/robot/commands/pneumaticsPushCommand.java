

package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.subsystems.Pneumatics;

import edu.wpi.first.wpilibj.command.InstantCommand;

public class pneumaticsPushCommand extends InstantCommand {

    public pneumaticsPushCommand(){
        requires(Robot.pneumaticsSubsystem);
    }

    @Override
    protected void execute() {
        ((Pneumatics) Robot.pneumaticsSubsystem).feederDeployment();
    }

    @Override
  protected void interrupted() {
  }

}
