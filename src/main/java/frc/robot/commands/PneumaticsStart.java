
package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.InstantCommand;

public class PneumaticsStart extends InstantCommand {

    public PneumaticsStart(){
        requires(Robot.feederSubsystem);
    }

    @Override
    protected void execute() {
        Robot.feederSubsystem.start();
    
    }

    @Override
  protected void interrupted() {
  }

}
