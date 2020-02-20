package frc.robot.commands;
import frc.robot.Robot;
import frc.robot.subsystems.Limelight;
import edu.wpi.first.wpilibj.command.Command;

public class VisionStart extends Command {
    public VisionStart() {
        requires(Robot.limelight);
        requires(Robot.drivetrain);
    }

    protected void execute() {

        if (Robot.limelight.getLimelightHasValidTarget() == true) {
            Robot.drivetrain.arcadeDrive(Robot.limelight.getLimelightSteerCommand(), Robot.limelight.getLimelightDriveCommand());
        }
        
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}