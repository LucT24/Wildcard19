package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.subsystems.GearLift;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LiftDown extends Command {

    public LiftDown() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.lift);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	GearLift.liftMotor.set(-.4);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}