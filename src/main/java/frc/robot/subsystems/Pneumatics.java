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
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
//import frc.robot.RobotMap;
//import edu.wpi.first.wpilibj.GenericHID.Hand;
//import edu.wpi.first.wpilibj.GenericHID;



public class Pneumatics extends Subsystem {
    private static final Compressor comp = new Compressor(0);
    private static final XboxController controller1 = new XboxController(RobotMap.controller1);
    private static final XboxController controller2 = new XboxController(RobotMap.controller2);
    private static final DoubleSolenoid feederSolenoid = new DoubleSolenoid(RobotMap.hammerPneumaticsForward, RobotMap.hammerPneumaticsBackward);
    private static final DoubleSolenoid armSolenoid = new DoubleSolenoid(RobotMap.armsPneumaticsForward, RobotMap.armsPneumaticsBackward);
    public static final //PressureSwitch pSwitch = new PressureSwitch(1);
 
    void start() {
        Pneumatics.comp.start();
        Pneumatics.comp.getCompressorCurrent();
        
        //if (pSwitch == 90){
        //    Pneumatics.comp.start();
        //}

        //if (pSwitch == 120){
        //    Pneumatics.comp.stop();
        //}
    }
//runs compressor, Contains Pseudocode. This should be about right however I can't look up the proper syntax as I am currently,
// in the Colorado maountians for hockey and don't even have service.

//Note 1: pSwitch must be a double or an int for this code to work, otherwise I'll have to adjust the code a bit to make it compatable
//          with booleans. Can NOT be a value!

//Note 2: The code below this note still needs testing, however I don't have a controller availiable(see note abouve for details) and
//          therefore can't test if the if statements will actually bind the buttons to the solenoids.

//Note 3: Have Shane and/or Sam Proofread this code to make sure that a) it works and b) the titles and buttons I am using don't conflict anywhere else

    public void feederDeployment(){
        Double triggerL = controller1.getTriggerAxis(Hand.kLeft);

        if (triggerL == 1){
        feederSolenoid.set(DoubleSolenoid.Value.kForward);
        }
    }
//moves pistons forward


    public void feederRetract() {
        Double triggerL = controller1.getTriggerAxis(Hand.kLeft);

        if (triggerL == 0){
        feederSolenoid.set(DoubleSolenoid.Value.kReverse);
        }
}
//moves pistons backward

public void off(){
    int Pov = controller1.getPOV();

    if(Pov == 270){
        feederSolenoid.set(Value.kOff);
    }
}
//Stops pistons

////////////////////////////////////////////////////////////////////////////////

public void ArmsRaise(){
    Double triggerR = controller1.getTriggerAxis(Hand.kRight);

    if (triggerR == 1) {
    armSolenoid.set(DoubleSolenoid.Value.kForward);
    }
}
//Raises arms

public void ArmsRetract(){
    Double triggerR = controller1.getTriggerAxis(Hand.kRight);

    if (triggerR == 0){
    armSolenoid.set(DoubleSolenoid.Value.kReverse);
    }
}
// lowers arms

public void stop(){
        int Pov = controller1.getPOV();
    
        if(Pov == 270){
            armSolenoid.set(Value.kOff);
        }
}
//Stops pistons


///////////////////////////////////////////////////////////////////////////////////////

@Override
    protected void initDefaultCommand() {

    }
//Necessary override


}