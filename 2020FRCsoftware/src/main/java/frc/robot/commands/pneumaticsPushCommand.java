

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
        (Robot.pneumaticsSubsystem).feederDeployment();
        
        (Robot.pneumaticsSubsystem).feederRetract();
    }

    @Override
  protected void interrupted() {
  }

}
