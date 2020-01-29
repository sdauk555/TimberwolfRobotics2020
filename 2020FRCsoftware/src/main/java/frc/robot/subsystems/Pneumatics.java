/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor; //Pneumatics, Compressor
import edu.wpi.first.wpilibj.DoubleSolenoid; //Pneumatics, Solenoid
import frc.robot.commands.pneumaticsCommand;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;  //Pneumatics, Solenoid values
import edu.wpi.first.wpilibj.XboxController;  //Controller
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.GenericHID;



public class Pneumatics extends Subsystem {
    private static final XboxController logitech1 = new XboxController(RobotMap.controller1);
    private static final Compressor comp = new Compressor(0);

    public static final DoubleSolenoid.Value kForward;
    public static final DoubleSolenoid.Value kReverse;
    
    public void XboxController
    public boolean getX(GenericHID.Hand hand);
    public boolean getY(GenericHID.Hand hand);

    DoubleSolenoid pistonArm;
    Compressor compressor;
    
    public void pistons(){
        pistonArm = new DoubleSolenoid(1, 2);
		compressor = new Compressor();
    
    }

    public void bumper(){
        compressor.start();
        compressor.setClosedLoopControl(true);
        
    }

    @Override
    protected void initDefaultCommand() {
        // TODO Auto-generated method stub

    }
}
