package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.HatchPiston;
import frc.robot.commands.GearShift;;


public class OI {

    private final Joystick JOYSTICK_1;
    private final Joystick JOYSTICK_2;

    private final JoystickButton[] joystickButtons1;
    private final JoystickButton[] joystickButtons2;


    public OI() {
        this.JOYSTICK_1 = new Joystick(0);
        this.JOYSTICK_2 = new Joystick(1);

            this.joystickButtons1 = new JoystickButton[13];
            for(int i = 1; i <= joystickButtons1.length; i++) {
                joystickButtons1[i-1] = new JoystickButton(JOYSTICK_1, i);
            }

            this.joystickButtons2 = new JoystickButton[13];
            for(int j = 1; j <= joystickButtons2.length; j++) {
                joystickButtons2[j-1] = new JoystickButton(JOYSTICK_2, j);
            }

            this.joystickButtons1[0].whileHeld(new HatchPiston());
            this.joystickButtons2[0].whileHeld(new GearShift());
      }
    
    public boolean getButton1()
    {
        return JOYSTICK_1.getRawButton(1);
    }


    public boolean getButton2()
    {
        return JOYSTICK_2.getRawButton(1);
    }
    public double getLeftX(){
        return JOYSTICK_1.getX();
    }

    public double getRightX(){
        return JOYSTICK_2.getX();
    }

    public double getLeftY(){
        return JOYSTICK_1.getY();
    }

    public double getRightY(){
        return JOYSTICK_2.getY();
    }


}