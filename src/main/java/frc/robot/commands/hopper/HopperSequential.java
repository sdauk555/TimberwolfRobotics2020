package frc.robot.commands.hopper;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class HopperSequential extends SequentialCommandGroup {

    public HopperSequential() {
        addCommands(new HopperMotorRun().withTimeout(1), new HopperMotorStop().withTimeout(3));
    }
}
