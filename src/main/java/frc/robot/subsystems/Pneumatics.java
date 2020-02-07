/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SolenoidBase;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
//import frc.robot.RobotMap;
//import edu.wpi.first.wpilibj.GenericHID.Hand;
//import edu.wpi.first.wpilibj.GenericHID;



public class Pneumatics extends Subsystem {
    private static final Compressor comp = new Compressor(0);
    private static final XboxController controller1 = new XboxController(RobotMap.controller1);
    private static final DoubleSolenoid feederSolenoid = new DoubleSolenoid(RobotMap.hammerPneumaticsForward, RobotMap.hammerPneumaticsBackward);
    private static final DoubleSolenoid armSolenoid = new DoubleSolenoid(RobotMap.armsPneumaticsForward, RobotMap.armsPneumaticsBackward);

    public void start(){
        Pneumatics.comp.start();
        Pneumatics.comp.setClosedLoopControl(true);
        
    }
//runs compressor

public void feederDeployment(){
        feederSolenoid.set(DoubleSolenoid.Value.kForward);
}
//moves pistons forward

public void feederRetract(){
    feederSolenoid.set(DoubleSolenoid.Value.kReverse);
}
//moves pistons backward

public void off(){
    if(controller1.getRawButtonReleased(2)) {
        feederSolenoid.set(Value.kOff);
    }
}
//Stops pistons

////////////////////////////////////////////////////////////////////////////////

public void ArmsRaise(){
    armSolenoid.set(DoubleSolenoid.Value.kForward);
}
//Raises arms

public void ArmsRetract(){
    armSolenoid.set(DoubleSolenoid.Value.kReverse);
}
// lowers arms

public void stop(){
    armSolenoid.set(Value.kOff);
}
//Stops pistons


///////////////////////////////////////////////////////////////////////////////////////

@Override
    protected void initDefaultCommand() {

    }
//Necessary override


}