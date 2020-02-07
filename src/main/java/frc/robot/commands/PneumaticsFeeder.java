

package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.subsystems.Pneumatics;

import edu.wpi.first.wpilibj.command.InstantCommand;

public class PneumaticsFeeder extends InstantCommand {

    public PneumaticsFeeder(){
        requires(Robot.pneumaticsSubsystem);
    }

    @Override
    protected void execute() {
        (Robot.pneumaticsSubsystem).feederMove();
    
    }

    @Override
  protected void interrupted() {
  }

}
