/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.auto_commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.Robot;

public class AlignRobot extends InstantCommand {
    private final static int MAXCOUNT = 50;
    private double holdMidX;
    private int count = MAXCOUNT;

    /**
     * Creates a new AlignRobot.
     */
    public AlignRobot() {
        // Use addRequirements() here to declare subsystem dependencies.
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        double midX = Robot.visionSubsystem.getMidPointX();
        boolean resultscheck = Robot.visionSubsystem.getResultsCheck();

        if (resultscheck == false) {
            if (count < MAXCOUNT) {
                midX = holdMidX;
                count = count + 1;
            } else {
                Robot.driveSubsystem.driveSystem(0, 0);
                return;
            }
        } else {
            holdMidX = midX;
            count = 0;
        }

        if (midX < -0.1) {
            Robot.driveSubsystem.driveSystem(0, 0.1);
        } else if (midX > 0.1) {
            Robot.driveSubsystem.driveSystem(0, -0.1);
        } else if (midX > -0.1 && midX < 0.1) {
            Robot.driveSubsystem.driveSystem(0, 0);
        }
    }
}
