

package frc.robot.commands;
import frc.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.InstantCommand;

public class pneumaticsPushCommand extends InstantCommand {

    public pneumaticsPushCommand(){
        requires(Robot.PneumaticsSubsystem);
    }

    @Override
    protected void execute(){
    Robot.PneumaticsSubsystem.feederDeployment();
    }

    @Override

}
