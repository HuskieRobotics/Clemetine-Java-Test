package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.KickerPistons;

public class Kicker extends Subsystem {
    private Solenoid kickerSolenoid;
    public Kicker() {
            kickerSolenoid = new Solenoid(1);
    }

    public void out(){
        this.kickerSolenoid.set(true);
    }

    public void in(){
        
        this.kickerSolenoid.set(false);
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new KickerPistons());

    }

}