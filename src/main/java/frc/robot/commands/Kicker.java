package frc.robot.commands;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.Timer;



public class Kicker extends Command {
    public Kicker() {
       // requires(Robot.kickers);
    }

    protected void initialize() {
        Robot.kickers.up();
    }

    protected void execute() {
        Robot.kickers.down();
        Timer.delay(0.6);
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