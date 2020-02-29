/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.subsystems.*;
import frc.robot.commands.agitator.AgitatorStop;
import frc.robot.commands.auto_commands.*;
import frc.robot.commands.control_panel.ControlPanelMotorStop;
import frc.robot.commands.drive.DriveCommand;
import frc.robot.commands.hopper.HopperMotorStop;
import frc.robot.commands.shooter.ShooterStop;
/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();

  public static final Drive driveSubsystem = new Drive();
  public static final VisionProcessing visionSubsystem = new VisionProcessing();
  public static final PneumaticsCompressor compressorSubsystem = new PneumaticsCompressor();
  public static final Shooter shooterSubsystem = new Shooter();
  //feeder disabled due to not being added to the robot
  //public static final Feeder feederSubsystem = new Feeder();
  public static final Hopper hopperSubsystem = new Hopper();
  public static final ColorSensor colorSensorSubsystem = new ColorSensor();

  public static final ControlPanel controlpanelSubsystem = new ControlPanel(); 
  public static final Agitator agitatorSubsystem =new Agitator();
  public static final OI CONTROLLERBINDING = new OI();

  public AutoMid autoPos2;
  public PositionOne autoPos1;
  public PositionThree autoPos3;


  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto choices", m_chooser);
    
    hopperSubsystem.setDefaultCommand(new HopperMotorStop());
    driveSubsystem.setDefaultCommand(new DriveCommand());
    shooterSubsystem.setDefaultCommand(new ShooterStop());
    //feederSubsystem.setDefaultCommand(new FeederStop());
    controlpanelSubsystem.setDefaultCommand(new ControlPanelMotorStop());
    agitatorSubsystem.setDefaultCommand(new AgitatorStop());
    autoPos2 = new AutoMid();
    autoPos1 = new PositionOne();
    autoPos3 = new PositionThree();
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to
   * the switch structure below with additional strings. If using the
   * SendableChooser make sure to add them to the chooser code above as well.
   */
  @Override
  public void autonomousInit() {
    m_autoSelected = m_chooser.getSelected();
    // m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
    autoPos2.schedule();
    autoPos1.schedule();
    autoPos3.schedule();

    System.out.println("Auto selected: " + m_autoSelected);
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    switch (m_autoSelected) {
      case kCustomAuto:
        // Put custom auto code here
        break;
      case kDefaultAuto:
      default:
        // Put default auto code here
        CommandScheduler.getInstance().run();
        break;
    }
  }

  @Override
  public void teleopInit() {
    autoPos2.cancel();
    autoPos1.cancel();
    autoPos3.cancel();
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    CommandScheduler.getInstance().run();
    
    //CameraServer camera1 = CameraServer.getInstance();
    //camera1.startAutomaticCapture("cam1", 0);
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
