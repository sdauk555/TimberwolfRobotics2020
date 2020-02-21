package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj.Timer;



public class HopperMotorRun extends InstantCommand {
    
    private final Timer m_timer = new Timer();
    
    public HopperMotorRun() {
        addRequirements(Robot.hopperSubsystem);
    }

    @Override
    public void execute() {  
        m_timer.reset();
        m_timer.start(); 
        if (m_timer.get() < 2.0) {
                Robot.hopperSubsystem.run(); 
            } else {
                Robot.hopperSubsystem.stop();
       } 
    }
    
    @Override
    public void end(boolean interrupted) {
    }

}
