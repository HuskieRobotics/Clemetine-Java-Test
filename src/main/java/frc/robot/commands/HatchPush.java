package frc.robot.commands;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class HatchPush extends Command {
    public HatchPush() {
        requires(Robot.hatch);
    }

    protected void initialize() {
        
        Robot.hatch.in(); //Beins in the retracted position
    }

    protected void execute() {
        
        
           Robot.hatch.out(); //Robot hatch pusher extends
        }
        
        
        
    }

    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        Robot.hatch.in(); //Ends in the retracted position
    }
    
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}