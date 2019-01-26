package frc.robot.commands;

import frc.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ArmDown extends Command {

	 public ArmDown() {
	        // Use requires() here to declare subsystem dependencies
	        // eg. requires(chassis);
	    	requires(Robot.armUno);
	    }

	    // Called just before this Command runs the first time
	    protected void initialize() {
	    	Robot.armUno.initializeCounter();
	    }

	    // Called repeatedly when this Command is scheduled to run
	    protected void execute() {
	    	Robot.armUno.armDown();
	    }

	    // Make this return true when this Command no longer needs to run execute()
	    protected boolean isFinished() {
	    	return Robot.armUno.isSwitchSet();
	    }

	    // Called once after isFinished returns true
	    protected void end() {
	    	Robot.armUno.armStop();
	    }

	    // Called when another command which requires one or more of the same
	    // subsystems is scheduled to run
	    protected void interrupted() {
	    }
}