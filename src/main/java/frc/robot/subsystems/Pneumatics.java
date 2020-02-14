/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Pneumatics extends Subsystem {
    private static final Compressor comp = new Compressor(0);
    private static final Solenoid feederA = new Solenoid(0);

    public void start() {
        Pneumatics.comp.start();
    }

    public void feederDeployment() {
        feederA.set(true);

    }
    // moves pistons forward

    public void feederRetract() {
        feederA.set(false);
    }

    // moves pistons backward

    @Override
    protected void initDefaultCommand() {

    }
    // Necessary override

}