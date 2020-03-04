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
  private final ColorSensorV3 colorSensor = new ColorSensorV3(I2C.Port.kOnboard);
  private final ColorMatch m_colorMatcher = new ColorMatch();
  private final Color kBlueTarget = ColorMatch.makeColor(0.143, 0.427, 0.429);
  private final Color kGreenTarget = ColorMatch.makeColor(0.197, 0.561, 0.240);
  private final Color kRedTarget = ColorMatch.makeColor(0.561, 0.232, 0.114);
  private final Color kYellowTarget = ColorMatch.makeColor(0.361, 0.524, 0.113);

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

    // if (match.color == kBlueTarget) {
    // } else if (match.color == kRedTarget) {
    //   colorString = "Red";
    // } else if (match.color == kGreenTarget) {
    //   colorString = "Green";
    // } else if (match.color == kYellowTarget) {
    //   colorString = "Yellow";
    // } else {
    //   colorString = "Unknown";
    // }
    }

  public Color getColor() {
    return colorSensor.getColor();
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
