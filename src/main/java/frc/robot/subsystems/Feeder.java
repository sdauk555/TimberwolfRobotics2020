/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import java.util.Map;

import com.ctre.phoenix.motorcontrol.ControlMode;

public class Feeder extends SubsystemBase {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private static final DoubleSolenoid feederSolenoid = new DoubleSolenoid(10, RobotMap.feederExtend,
            RobotMap.feederContract);
    private static final WPI_VictorSPX feederMotor = new WPI_VictorSPX(RobotMap.feederMotor);

    double defaultValueA = 0;

    private ShuffleboardTab HopperTab = Shuffleboard.getTab("Testing");

    private NetworkTableEntry ValueA = HopperTab.add("Forward Speed", defaultValueA).withPosition(0, 0)
            .withWidget(BuiltInWidgets.kNumberSlider).withProperties(Map.of("min", -1, "max", 1)).getEntry();

    // Starts the roller bar
    public void start() {
        Double ValueAD = ValueA.getDouble(defaultValueA);
        feederMotor.set(ControlMode.PercentOutput, ValueAD);
    }

    // Stops the roller bar
    public void stop() {
        feederMotor.stopMotor();
    }

    // moves pistons forward
    public void feederExtend() {
        feederSolenoid.set(DoubleSolenoid.Value.kForward);
    }

    // moves pistons backward
    public void feederContract() {
        feederSolenoid.set(DoubleSolenoid.Value.kReverse);
    }

    public void FeederSolenoidOff() {
        feederSolenoid.set(DoubleSolenoid.Value.kOff);
    }
}