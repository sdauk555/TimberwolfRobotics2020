/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.shooter;

import java.util.function.BooleanSupplier;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.ConditionalCommand;
import frc.robot.RobotMap;

public class Shoot extends ConditionalCommand {
  /**
   * Creates a new Shoot.
   */
  
  private static final XboxController controller1 = new XboxController(RobotMap.operatorController);
  
  public Shoot() {
    // Use addRequirements() here to declare subsystem dependencies.
    super(new RumbleShoot(), new ShooterStop(), () -> {
        if (controller1 == null) return false;
        double triggerValue = controller1.getRawAxis(5);
        return triggerValue > -0.7;
    });
    initialize();
  }
}
