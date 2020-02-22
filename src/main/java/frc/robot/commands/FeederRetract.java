

package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj2.command.InstantCommand;

public class FeederRetract extends InstantCommand {

    public FeederRetract(){
        addRequirements(Robot.pneumaticsSubsystem);
    }

    @Override
    public void execute() {
        Robot.pneumaticsSubsystem.feederRetract();
    
    }

    @Override
  public void end(boolean interrupted) {
  }

}
