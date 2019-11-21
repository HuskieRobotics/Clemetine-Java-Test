package frc.robot.commands;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class GearShift extends Command {
    public GearShift() {
        requires(Robot.dShifter);
    }

    protected void initialize() {
        
        Robot.dShifter.lowGear();
    }

    protected void execute() {
        
        if (Robot.oi.getButton2())
        {
           Robot.dShifter.highGear();
        }
    }

    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        Robot.dShifter.lowGear();
    }
    
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}