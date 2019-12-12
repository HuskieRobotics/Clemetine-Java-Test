package frc.robot.commands;
import frc.robot.Robot;
import frc.robot.subsystems.Limelight;
import edu.wpi.first.wpilibj.command.Command;

public class VisionStart extends Command {
    public VisionStart() {
        requires(Robot.limelight);
    }

    protected void execute() {

        
        Robot.drivetrain.arcadeDrive(Robot.limelight.getLimelightSteerCommand(), Robot.limelight.getLimelightDriveCommand());

        
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}