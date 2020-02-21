
package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj2.command.InstantCommand;

public class PneumaticsStart extends InstantCommand {

    public PneumaticsStart(){
        addRequirements(Robot.pneumaticsSubsystem);
    }

    @Override
    public void execute() {
        Robot.pneumaticsSubsystem.start();
    
    }

    @Override
  public void end(boolean interrupted) {
  }

}
