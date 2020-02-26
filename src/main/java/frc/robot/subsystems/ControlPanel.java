//Found: https://github.com/STMARobotics/frc-7028-2020/blob/9cbe4d4594168554d8071f844c2e7cd5451bd47f/src/main/java/frc/robot/subsystems/ControlPanelSubsystem.java


package frc.robot.subsystems;

import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class ControlPanel extends SubsystemBase