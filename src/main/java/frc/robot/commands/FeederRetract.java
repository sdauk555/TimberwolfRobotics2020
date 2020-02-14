

package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.InstantCommand;

public class FeederRetract extends InstantCommand {

    public FeederRetract(){
        requires(Robot.pneumaticsSubsystem);
    }

    @Override
    protected void execute() {
        Robot.pneumaticsSubsystem.feederRetract();
    
    }

    @Override
  protected void interrupted() {
  }

}
