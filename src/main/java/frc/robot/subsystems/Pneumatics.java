/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Compressor;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

//import frc.robot.RobotMap;
//import edu.wpi.first.wpilibj.GenericHID.Hand;
//import edu.wpi.first.wpilibj.GenericHID;



public class Pneumatics extends Subsystem {
    private static final Compressor comp = new Compressor(0);
    private static final DoubleSolenoid feederSolenoid = new DoubleSolenoid(RobotMap.hammerPneumaticsForward, RobotMap.hammerPneumaticsBackward);
    private static final DoubleSolenoid armSolenoid = new DoubleSolenoid(RobotMap.armsPneumaticsForward, RobotMap.armsPneumaticsBackward);
    
    public void start(){
        Pneumatics.comp.start();
        Pneumatics.comp.setClosedLoopControl(true);
        
    }
//runs compressor


    public void feederMove(){
        feederSolenoid.set(DoubleSolenoid.Value.kForward);

    }
//moves feeder pistons

    public void off(){
        feederSolenoid.set(Value.kOff);
    }
//Stops pistons

    public void ArmsOff(){
        armSolenoid.set(Value.kOff);
    }
//moves arms

    public void ArmsMove(){
        armSolenoid.set(DoubleSolenoid.Value.kReverse);
    }
// lowers arms

    @Override
    protected void initDefaultCommand() {

    }
//Necessary override


}