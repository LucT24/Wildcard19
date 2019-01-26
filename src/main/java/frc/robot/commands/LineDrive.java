package frc.robot.commands;

import frc.robot.OI;
import frc.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.subsystems.GearLift;
import frc.robot.subsystems.DriveTrain;

/**
 *
 */
public class LineDrive extends Command {

	boolean done;
	final double LINE = .7;
	//final double CARPET = .5;
	JoystickButton button2 = new JoystickButton(OI.stick2, 1);
    public LineDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetrain);
    	requires(Robot.leftEye);
    	requires(Robot.rightEye);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	System.out.println("LINE DRIVE STARTED");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double rightEye = Robot.rightEye.getVoltage();
    	double leftEye = Robot.leftEye.getVoltage();
    	//double middleEye = Robot.middleEye.getVoltage();
    	Pair<Double, Boolean> distance = Robot.vision.getDistanceFromTarget();
    	//System.out.println("leftEye: " + leftEye + "     middleEye: " + middleEye + "     rightEye: " + rightEye + "     Distance: " + distance.t);
    	/*if(rightEye > LINE && leftEye > LINE && middleEye < LINE){
    		DriveTrain.drive(.45, .45);
    	}
    	if((rightEye > LINE && leftEye < LINE) || (rightEye > LINE && middleEye < LINE)){
    		DriveTrain.drive(.25, .35);
    	}
    	if((rightEye < LINE && leftEye > LINE) || (leftEye > LINE && middleEye < LINE)){
    		DriveTrain.drive(.35, .25);
    	}*/
    	DriveTrain.drive(.70, .70);
    	Timer.delay(4);
    	//if(distance.t <= 30 && distance.t != 0){
    		//DriveTrain.drive(.45, .45);
    		//Timer.delay(5);
    		DriveTrain.stop();
    		GearLift.liftMotor.set(.4);
    		Timer.delay(2);
    		DriveTrain.drive(-.45, -.45);
    		Timer.delay(2);
    		done =  true;
    	//}
    	if(button2.get()){
    		done=true;
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return done;
    }

    // Called once after isFinished returns true
    protected void end() {
    	DriveTrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}