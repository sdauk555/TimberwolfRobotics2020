//*----------------------------------------------------------------------------*/
// /* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
// /* Open Source Software - may be modified and shared by FRC teams. The code   */
// /* must be accompanied by the FIRST BSD license file in the root directory of */
// /* the project.                                                               */
// /*----------------------------------------------------------------------------*/

package frc.robot.commands.auto_commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class AutoRight extends CommandBase {

  public AutoRight(){
    addRequirements(Robot.driveSubsystem);

  }

  @Override
    public void initialize() {
   }  

  @Override
    public void execute(){
      Robot.driveSubsystem.driveSystem(0, 1);
    }

  @Override
  public boolean isFinished() {
    return false;
  }

  @Override
  public void end(boolean interrupted) {
  }
}