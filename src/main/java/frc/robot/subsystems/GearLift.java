package frc.robot.subsystems;

import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.Talon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearLift extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public static Talon liftMotor = new Talon(RobotMap.lift);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
