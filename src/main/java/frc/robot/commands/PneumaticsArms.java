

package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.subsystems.Pneumatics;

import edu.wpi.first.wpilibj.command.InstantCommand;

public class PneumaticsArms extends InstantCommand {

    public PneumaticsArms(){
        requires(Robot.pneumaticsSubsystem);
    }

    @Override
    protected void execute() {
        (Robot.pneumaticsSubsystem).ArmsMove();
    
    }

    @Override
  protected void interrupted() {
  }

}
