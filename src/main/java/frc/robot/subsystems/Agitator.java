package frc.robot.subsystems;

import java.util.Map;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class Agitator extends SubsystemBase {
  private static final WPI_VictorSPX agitatorMotor = new WPI_VictorSPX(RobotMap.agitatorMotor);
  double defaultSpeed = -0.4;

  private ShuffleboardTab testingTab = Shuffleboard.getTab("Testing");
  private NetworkTableEntry agitator = testingTab.add("Agitator", defaultSpeed).withWidget(BuiltInWidgets.kNumberSlider)
      .withProperties(Map.of("min", -1, "max", 1)).getEntry();

  public void run() {
    double agitatorSpeed = agitator.getDouble(defaultSpeed);    
    XboxController ctrl = Robot.CONTROLLERBINDING.operatorController;
    double triggerValue = Robot.isSimulation() ? ctrl.getX(Hand.kRight) : ctrl.getTriggerAxis(Hand.kLeft);
    if (triggerValue > 0.5){
      agitatorMotor.set(ControlMode.PercentOutput, -agitatorSpeed);  
    }
    else {
      agitatorMotor.set(ControlMode.PercentOutput, agitatorSpeed);
    }
  }

  public void stop() {
    agitatorMotor.set(ControlMode.PercentOutput, 0);
  }
}
