/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.shooter;

import java.util.function.BooleanSupplier;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.ConditionalCommand;
import frc.robot.Robot;
public class Shoot extends ConditionalCommand {
  /**
   * Creates a new Shoot.
   */
  public Shoot() {
    // Use addRequirements() here to declare subsystem dependencies.
    super(new RumbleShoot(), new ShooterStop(), new BooleanSupplier() {

      @Override
      public boolean getAsBoolean() {
        Joystick controller = Robot.CONTROLLERBINDING.operatorController;
        double triggerValue = controller.getRawAxis(5);
        return triggerValue > -0.7;
      }
    });
  }
}
