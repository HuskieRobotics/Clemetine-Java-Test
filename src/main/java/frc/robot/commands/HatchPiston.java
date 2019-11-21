package frc.robot.commands;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class HatchPiston extends Command {
    public HatchPiston() {
        requires(Robot.hatch);
    }

    protected void initialize() {
        
        Robot.hatch.in();
    }

    protected void execute() {
        
        
        if (Robot.oi.getButton1())
        {
           Robot.hatch.out();
        }
        
        
        
    }

    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        Robot.hatch.in();
    }
    
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}