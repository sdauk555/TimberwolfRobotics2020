package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj2.command.InstantCommand;

public class HopperMotorStop extends InstantCommand {

    public HopperMotorStop(){
        addRequirements(Robot.hopperSubsystem);
    }

    @Override
    public void execute() {
        Robot.hopperSubsystem.stop();
    
    }

    @Override
  public void end(boolean interrupted) {
  }

}
