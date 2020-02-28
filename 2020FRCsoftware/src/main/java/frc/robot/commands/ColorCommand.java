//2020*1*25

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot; 

public class ColorCommand extends Command {
    public ColorCommand() {
      // Use requires() here to declare subsystem dependencies
      // eg. requires(chassis);
      requires(Robot.driveSubsystem);
    }
  
    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    }
  
    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
/**         Not certain this portion is needed, since the color sensor can give what color it senses by defaul, without testing for it.
 *   if (sensorColor.blue() == true) {
        return onBlue
        // then we are on blue sector, do something here
     } else if (sensorColor.green == true) {
       return onGreen
        // then we are on green sector, do something here
     } else if (sensorColor.red == true) {
       return onRed
        // then we are on red sector, do something here
     } else if (sensorColor.yellow == true) {
       return onYellow
        // then we are on yellow sector, do something here
     }
*/
     
      Robot.driveSubsystem.driveSystem();
    }
  
    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
      return false;
    }
  
    // Called once after isFinished returns true
    @Override
    protected void end() {
    }
  
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }
  }
  