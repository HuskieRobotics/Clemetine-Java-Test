package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.networktables.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Limelight extends Subsystem {

    private boolean m_LimelightHasValidTarget = false;
    private double m_LimelightDriveCommand = 0.0;
    private double m_LimelightSteerCommand = 0.0;




    public void Update_Limelight_Tracking() {
        // These numbers must be tuned for your Robot! Be careful!
        final double STEER_K = 0.005; // how hard to turn toward the target
        final double DRIVE_K = 0.28; // how hard to drive fwd toward the target
        final double DESIRED_TARGET_AREA = 2.4; // Area of the target when the robot reaches the wall
        final double MAX_DRIVE = 0.18; // Simple speed limit so we don't drive too fast

        double tv = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tv").getDouble(0);
        double tx = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx").getDouble(0);
        double ty = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ty").getDouble(0);
        double ta = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ta").getDouble(0);

        if (tv < 1.0) {
            m_LimelightHasValidTarget = false;
            m_LimelightDriveCommand = 0.0;
            m_LimelightSteerCommand = 0.0;
            return;
        }

        m_LimelightHasValidTarget = true;


        // Start with proportional steering
        double steer_cmd = tx * STEER_K;
        m_LimelightSteerCommand = steer_cmd;

        // try to drive forward until the target area reaches our desired area
        double drive_cmd = (DESIRED_TARGET_AREA - ta) * DRIVE_K;

        // don't let the robot drive too fast into the goal
        if (drive_cmd > MAX_DRIVE) {
            drive_cmd = MAX_DRIVE;
        }
        m_LimelightDriveCommand = drive_cmd;

        SmartDashboard.putNumber("ta", ta);
        SmartDashboard.putNumber("tx", tx);
        SmartDashboard.putNumber("ty", ty);
        
    }

    public boolean getLimelightHasValidTarget()
    {
        return m_LimelightHasValidTarget;
    }

    public double getLimelightDriveCommand()
    {
        return m_LimelightDriveCommand;
    }

    public double getLimelightSteerCommand()
    {
        return m_LimelightSteerCommand;
    }

    
    protected void initDefaultCommand() {
        this.Update_Limelight_Tracking();
    }
}