package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.InstantCommand;

public class RunHopperMotor extends InstantCommand {

    public RunHopperMotor(){
        requires(Robot.hopperSubsystem);
    }

    @Override
    protected void execute() {
        Robot.hopperSubsystem.run();
    
    }

    @Override
  protected void interrupted() {
  }

}
