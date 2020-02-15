package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.InstantCommand;

public class HopperMotorStop extends InstantCommand {

    public HopperMotorStop(){
        requires(Robot.hopperSubsystem);
    }

    @Override
    protected void execute() {
        Robot.hopperSubsystem.stop();
    
    }

    @Override
  protected void interrupted() {
  }

}
