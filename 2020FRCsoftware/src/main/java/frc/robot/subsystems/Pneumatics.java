/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.pneumaticsCommand;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.GenericHID.Hand;


public class Pneumatics extends Subsystem {
    private static final XboxController logitech1 = new XboxController(RobotMap.controller1);
    private static final Compressor charlie = new Compressor(0);
    public static final DoubleSolenoid pushy = new DoubleSolenoid(RobotMap.pushy[0],RobotMap.pushy[1])
    //charlie.setClosedLoopControl(true);
    //charlie.setClosedLoopControl(false);
    
    @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new PneumaticsCommand());
  }

  //public void pneumaticsSystem() {
    //boolean enabled = charlie.enabled();
    //boolean pressureSwitch = charlie.getPressureSwitch();
    //double current = charlie.getCompressorCurrent();
  //}

  public void pushy() {
      boolean downDPad = logitech.getStartButtonPushed(Hand.kRight)
      public boolean getStartButtonPressed()

  }
  
}
