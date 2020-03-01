package frc.robot.subsystems;

import java.util.Map;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class Agitator extends SubsystemBase {
  private static final WPI_VictorSPX agitatorMotor = new WPI_VictorSPX(RobotMap.agitatorMotor);
  double defaultSpeed = 1.0;

  private ShuffleboardTab testingTab = Shuffleboard.getTab("Testing");
  private NetworkTableEntry agitator = testingTab.add("Agitator", defaultSpeed).withWidget(BuiltInWidgets.kNumberSlider)
      .withProperties(Map.of("min", -1, "max", 1)).getEntry();

  public void run() {
    double agitatorSpeed = agitator.getDouble(defaultSpeed);
    agitatorMotor.set(ControlMode.PercentOutput, agitatorSpeed);
  }

  public void stop() {
    agitatorMotor.set(ControlMode.PercentOutput, 0);
  }
}
