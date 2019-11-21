package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.GearShift;

public class DogShifter extends Subsystem {
    private Solenoid dShifter;
    public DogShifter() {
        dShifter= new Solenoid(0);
    }

    public void highGear(){
        this.dShifter.set(true);
    }

    public void lowGear(){
        this.dShifter.set(false);
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new GearShift());

    }

}