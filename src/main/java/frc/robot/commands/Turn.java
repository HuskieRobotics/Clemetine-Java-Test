package frc.robot.commands;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Turn extends Command {
   
    private double target;
    double [] ypr = new double [3];
  
    public Turn(double target) {
        requires(Robot.drivetrain);
        this.target = target;
        target %= 360;
    }

    protected void execute() {
        Robot.pigeon.getYawPitchRoll(ypr);
        double current = ypr[0]%360;
        double difference = target - current;
        double leftPower = 0;
        double rightPower = 0;
        if(Math.abs(difference) > 180) {
            double power;
            if (difference > 0) 
                power = 360-difference;
            else 
                power = -(360+difference);
            power/= 90;
            if (power > 0) {
                power = Math.min(.3, power);
                //power = Math.max(.3, power);
            }
            else {
                power = Math.max(-.3, power);
                //power = Math.min(-.1, power);
            }
            leftPower = power;
            rightPower = -power;
        }
        else {
            double power;
            power = difference;
            power/= 90;
            if (power > 0) {
                power = Math.min(.3, power);
                //power = Math.max(.3, power);
            }
            else {
                power = Math.max(-.3, power);
                //power = Math.min(-.3, power);
            }
            leftPower = -power;
            rightPower = power;
        }
        Robot.drivetrain.setLeftPower(leftPower);
        Robot.drivetrain.setRightPower(rightPower);
        SmartDashboard.putNumber("left", leftPower);
        SmartDashboard.putNumber("right", rightPower);

    }

    protected boolean isFinished() {
        Robot.pigeon.getYawPitchRoll(ypr);
        SmartDashboard.putNumber("ypr", ((ypr[0]%360)+360)%360);
        SmartDashboard.putNumber("target",target);

        return Math.abs((((ypr[0]%360)+360)%360)-target)<5;
    }

}