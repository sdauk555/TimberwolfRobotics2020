/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import frc.robot.commands.*;

/**
 * Add your docs here.
 */
public class OI {

    public OI () {
		
		//driver
		// driverButtonRightBumper.whenPressed(new FeederStart());
		// driverButtonLeftBumper.whenPressed(new FeederStop());
		driverButtonA.whenPressed(new AlignRobot());
		driverButtonB.whenPressed(new ControlPanelMotorStart());
		driverButtonY.whenPressed(new ControlPanelMotorStop());
		
		operatorButtonRightBumper.whileHeld(new HopperMotorRun());
		operatorButtonLeftBumper.whileHeld(new ShooterRun());
		
		//operatorButtonA.whenPressed(new SelectGreen());
		operatorButtonB.whenPressed(new PrintColor());
		//operatorButtonX.whenPressed(new SelectBlue());
		//operatorButtonY.whenPressed(new SelectYellow());
		//operatorButtonRightBumper.whenPressed(new ShooterStart());
		//operatorButtonLeftBumper.whenPressed(new ShooterStop());

    }

	// driver controller setup
	private Joystick driverController = new Joystick(RobotMap.driverController);
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
	private Joystick operatorController = new Joystick(RobotMap.operatorController);
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
