
package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.subsystems.Pneumatics;

import edu.wpi.first.wpilibj.command.InstantCommand;

public class PneumaticsDeploy extends InstantCommand {

    public PneumaticsDeploy(){
        requires(Robot.pneumaticsSubsystem);
    }

    @Override
    protected void execute() {
        (Robot.pneumaticsSubsystem).feederDeployment();
    
    }

    @Override
  protected void interrupted() {
  }

}