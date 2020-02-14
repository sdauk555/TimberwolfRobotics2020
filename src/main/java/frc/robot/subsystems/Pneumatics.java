/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SolenoidBase;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.FeederStart;



public class Pneumatics extends Subsystem {
    private static final Compressor comp = new Compressor(0);
    private static final XboxController controller1 = new XboxController(RobotMap.controller1);
    //private static final DoubleSolenoid feederSolenoid = new DoubleSolenoid(RobotMap.hammerPneumaticsForward, RobotMap.hammerPneumaticsBackward);
    //private static final DoubleSolenoid armSolenoid = new DoubleSolenoid(RobotMap.armsPneumaticsForward, RobotMap.armsPneumaticsBackward);
    //public static final //PressureSwitch pSwitch = new PressureSwitch(1);

    private static final Solenoid feederA = new Solenoid(0);
    private static final Solenoid feederB = new Solenoid(1);
    private static final Solenoid armA = new Solenoid(2);
    private static final Solenoid armB = new Solenoid(3);
     
    

    public void startComp() {
        Pneumatics.comp.start();

    }
//runs compressor, Contains Pseudocode. This should be about right however I can't look up the proper syntax as I am currently,
// in the Colorado maountians for hockey and don't even have service.

//Note 1: pSwitch must be a double or an int for this code to work, otherwise I'll have to adjust the code a bit to make it compatable
//          with booleans. Can NOT be a value!

//Note 2: The code below this note still needs testing, however I don't have a controller availiable(see note above for details) and
//          therefore can't test if the if statements will actually bind the buttons to the solenoids.

//Note 3: Have Shane and/or Sam Proofread this code to make sure that a) it works and b) the titles and buttons I am using don't conflict anywhere else

    public void feederDeployment(){
        Double triggerL = controller1.getRawAxis(4);

        if (triggerL == 1){
        feederA.set(true);
        feederB.set(true);
        }
    }
//moves pistons forward


    public void feederRetract() {
        Double triggerL = controller1.getRawAxis(4);

        if (triggerL == -1){
        feederA.set(false);
        feederB.set(false);
        }
}
//moves pistons backward

////////////////////////////////////////////////////////////////////////////////

public void ArmsRaise(){
    Double triggerR = controller1.getRawAxis(5);

    if (triggerR == 1) {
    armA.set(true);
    armB.set(true);
    }
}
//Raises arms

public void ArmsRetract(){
    Double triggerR = controller1.getRawAxis(5);

    if (triggerR == -1){
    armA.set(false);
    armB.set(false);
    }
}
// lowers arms

///////////////////////////////////////////////////////////////////////////////////////

@Override
    protected void initDefaultCommand() {

    }
//Necessary override


}