package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class Agitator extends SubsystemBase {
  private static final WPI_VictorSPX agitatorMotor = new WPI_VictorSPX(RobotMap.agitatorMotor);

  public void run() {
    agitatorMotor.set(ControlMode.PercentOutput, .5);
  }

  public void stop() {
    agitatorMotor.set(ControlMode.PercentOutput, 0);
  }
}
