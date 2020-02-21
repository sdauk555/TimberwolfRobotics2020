// /*----------------------------------------------------------------------------*/
// /* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
// /* Open Source Software - may be modified and shared by FRC teams. The code   */
// /* must be accompanied by the FIRST BSD license file in the root directory of */
// /* the project.                                                               */
// /*----------------------------------------------------------------------------*/

// package frc.robot.commands;

// import edu.wpi.first.wpilibj.command.InstantCommand;
// import frc.robot.Robot; 

// public class AlignRobot extends InstantCommand {
//   /**
//    * Creates a new AlignRobot.
//    */
//   public AlignRobot() {
//     //requires(Robot.driveSubsystem);
//     //requires(Robot.visionSubsystem);
//     // Use addRequirements() here to declare subsystem dependencies.
//   }

//   // Called when the command is initially scheduled.
//   @Override
//   public void initialize() {
//   }

//   // Called every time the scheduler runs while the command is scheduled.
//   @Override
//   public void execute() {
//     double midX = Robot.visionSubsystem.getMidPointX();
//     boolean resultscheck = Robot.visionSubsystem.getResultsCheck();
//     if (resultscheck== false) {
//       return;
//     }
//     else 
//       if (midX < -0.1 ) {
//         Robot.driveSubsystem.driveSystem(0, 0.1);
//     }
//     else
//       if (midX > 0.1) {
//         Robot.driveSubsystem.driveSystem(0, -0.1);
//     }
//     else 
//       if (midX > -0.1 && midX < 0.1) {
    
//     }

//   }
// }
