/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.PrintColor;
import frc.robot.commands.ShooterRun;
import frc.robot.commands.ShooterSlow;
import frc.robot.commands.ShooterSpeed;
import frc.robot.commands.ShooterStop;

/**
 * Add your docs here.
 */
public class OI {

    public OI () {
		//driverButtonA.whenPressed(new LiftCommand());
		//driverButtonStart.whenPressed(new FeederDeploy());
		//driverButtonBack.whenPressed(new FeederRetract());

		operatorButtonLeftBumper.whenPressed(new ShooterSlow());
		operatorButtonRightBumper.whenPressed(new ShooterSpeed());
		operatorButtonA.whenPressed(new ShooterRun());
		operatorButtonX.whenPressed(new ShooterStop());
		//operatorButtonA.whenPressed(new SelectGreen());
		operatorButtonB.whenPressed(new PrintColor());
		//operatorButtonX.whenPressed(new SelectBlue());
		//operatorButtonY.whenPressed(new SelectYellow());
		//operatorButtonRightBumper.whenPressed(new ShooterStart());
		//operatorButtonLeftBumper.whenPressed(new ShooterStop());
		//operatorButtonStart.whenPressed(new FeederStart());
		//operatorButtonBack.whenPressed(new FeederStop());
    }

    private static final int LEFT_HORIZ_AXIS = 0;
	private static final int LEFT_VERT_AXIS = 1;
	private static final int RIGHT_HORIZ_AXIS = 4;
	private static final int RIGHT_VERT_AXIS = 5;
	private static final int LEFT_Z_AXIS = 3;
	private static final int RIGHT_Z_AXIS = 2;

	private static final double STICK_DEADZONE = 0.3;
	private static final double STICK_MAX = 0.97;

	// driver controller setup
	private Joystick driverController = new Joystick(0);
	private Button driverButtonA = new JoystickButton(driverController, 1);
	private Button driverButtonB = new JoystickButton(driverController, 2);
	private Button driverButtonX = new JoystickButton(driverController, 3);
	private Button driverButtonY = new JoystickButton(driverController, 4);
	private Button driverButtonLeftBumper = new JoystickButton(driverController, 5);
	private Button driverButtonRightBumper = new JoystickButton(driverController, 6);
	private Button driverButtonBack = new JoystickButton(driverController, 7);
	private Button driverButtonStart = new JoystickButton(driverController, 8);
	private Button driverButtonLeftAxisPress = new JoystickButton(driverController, 9);
	private Button driverButtonRightAxisPress = new JoystickButton(driverController, 10);
	
	// Operator controller setup
	private Joystick operatorController = new Joystick(RobotMap.controller2);
	private Button operatorButtonA = new JoystickButton(operatorController, 1);
	private Button operatorButtonB = new JoystickButton(operatorController, 2);
	private Button operatorButtonX = new JoystickButton(operatorController, 3);
	private Button operatorButtonY = new JoystickButton(operatorController, 4);
	private Button operatorButtonLeftBumper = new JoystickButton(operatorController, 5);
	private Button operatorButtonRightBumper = new JoystickButton(operatorController, 6);
	private Button operatorButtonBack = new JoystickButton(operatorController, 7);
	private Button operatorButtonStart = new JoystickButton(operatorController, 8);
	private Button operatorButtonLeftAxisPress = new JoystickButton(operatorController, 9);
	private Button operatorButtonRightAxisPress = new JoystickButton(operatorController, 10);
}
