//Found: https://github.com/STMARobotics/frc-7028-2020/blob/9cbe4d4594168554d8071f844c2e7cd5451bd47f/src/main/java/frc/robot/subsystems/ControlPanelSubsystem.java


package frc.robot.subsystems;

import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class ControlPanel extends SubsystemBase {
    private final ColorSensorV3 colorSensor = new ColorSensorV3(I2C.Port.kOnboard);

  private final Color kBlueTarget = ColorMatch.makeColor(0.143, 0.427, 0.429);
  private final Color kGreenTarget = ColorMatch.makeColor(0.197, 0.561, 0.240);
  private final Color kRedTarget = ColorMatch.makeColor(0.561, 0.232, 0.114);
  private final Color kYellowTarget = ColorMatch.makeColor(0.361, 0.524, 0.113);

  private final ColorMatch m_colorMatcher = new ColorMatch();
  
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

  public void spinWheel() {
    SmartDashboard.putBoolean("Spinning Wheel", true);
    // TODO spin a motor or something
  }

  public void stopWheel() {
    SmartDashboard.putBoolean("Spinning Wheel", false);
    // TODO stop the motor
  }
}