

package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.subsystems.Pneumatics;

import edu.wpi.first.wpilibj.command.InstantCommand;

public class PneumaticsPull extends InstantCommand {

    public PneumaticsPull(){
        requires(Robot.pneumaticsSubsystem);
    }

    @Override
    protected void execute() {
        (Robot.pneumaticsSubsystem).feederRetract();
    
    }

    @Override
  protected void interrupted() {
  }

}
