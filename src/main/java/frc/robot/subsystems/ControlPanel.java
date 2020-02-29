package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class ControlPanel extends SubsystemBase {
  private static final DoubleSolenoid ControlPanelSolenoid = new DoubleSolenoid(10, RobotMap.controlpanelExtend,
      RobotMap.controlpanelContract);
  private static final WPI_VictorSPX ControlPanelMotor = new WPI_VictorSPX(RobotMap.controlPanelMotor);

  private String colorString;

  public ControlPanel() {
    m_colorMatcher.addColorMatch(kBlueTarget);
    m_colorMatcher.addColorMatch(kGreenTarget);
    m_colorMatcher.addColorMatch(kRedTarget);
    m_colorMatcher.addColorMatch(kYellowTarget);
  }

  @Override
  public void periodic() {
    Color detectedColor = colorSensor.getColor();
    ColorMatchResult match = m_colorMatcher.matchClosestColor(detectedColor);

    if (match.color == kBlueTarget) {
      colorString = "Blue";
    } else if (match.color == kRedTarget) {
      colorString = "Red";
    } else if (match.color == kGreenTarget) {
      colorString = "Green";
    } else if (match.color == kYellowTarget) {
      colorString = "Yellow";
    } else {
      colorString = "Unknown";
    }
  }

  public String getColor() {
    return colorString;
  }

  public void start() {
    ControlPanelMotor.set(ControlMode.PercentOutput, .1);
  }

  public void stop() {
    ControlPanelMotor.stopMotor();
  }

  public void controlpanelExtend() {
    ControlPanelSolenoid.set(DoubleSolenoid.Value.kForward);
  }

  public void controlpanelContract() {
    ControlPanelSolenoid.set(DoubleSolenoid.Value.kReverse);
  }
}
