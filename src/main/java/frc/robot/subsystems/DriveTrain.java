package frc.robot.subsystems;

import frc.robot.RobotMap;
import frc.robot.commands.Drive;

import edu.wpi.first.wpilibj.Talon;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {
    
	public ADXRS450_Gyro gyro = new ADXRS450_Gyro();
	
	static Talon frontLeft = new Talon(RobotMap.fLeft);
	static Talon frontRight = new Talon(RobotMap.fRight);
	static Talon backLeft = new Talon(RobotMap.bLeft);
	static Talon backRight = new Talon(RobotMap.bRight);
	
	static DifferentialDrive rDrive = new DifferentialDrive(RobotMap.fLeft, RobotMap.fRight);
	public DriveTrain(){
		rDrive.setSafetyEnabled(false);
	}
	
    public void initDefaultCommand() {
    	setDefaultCommand(new Drive());
    }
    
    public static void drive(double stick1, double stick2){
    	rDrive.tankDrive(stick1, stick2);
    }
    
    public static void angleDriveStraight(double angle){
    	if(angle < 5 && angle > 0){
    		DriveTrain.drive(.2, .4);
    	}else if(angle < 0 && angle > -5){
    		DriveTrain.drive(.4, .2);
    	}else{
    		DriveTrain.drive(.5, .5);
    	}
    }
    
    public static void stop(){
    	rDrive.tankDrive(0,0);
    }
    
}
