package frc.robot.commands;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class ClimberExtend extends Command {
    public ClimberExtend() {
        requires(Robot.climber);
    }

    protected void initialize() {
    }

    protected void execute() {
        
        
           Robot.climber.extend(); //Robot climber pusher extends 
    }

    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }
    
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}