package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.HatchPiston;

public class Hatch extends Subsystem {
    private Solenoid hatchSolenoid;
    public Hatch() {
            hatchSolenoid = new Solenoid(2);
    }

    public void out(){
        this.hatchSolenoid.set(true);
    }

    public void in(){
        this.hatchSolenoid.set(false);
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new HatchPiston());

    }

}