package frc.robot.subsystems;

import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.Talon;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Arm extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	Counter counter;
	DigitalInput limitSwitch;
	public Arm(int port){
		limitSwitch = new DigitalInput(port);
		counter = new Counter(limitSwitch);
	}
	 
	Talon armMotor = new Talon(RobotMap.lift);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public boolean isSwitchSet() {
		System.out.println(!limitSwitch.get());
		return !limitSwitch.get();
	}
	public void initializeCounter() {
		System.out.println("Counter initialized");
		counter.reset();
	}
	public void armUp() {
		System.out.println("Arm up!");
		armMotor.set(0.5);
	}
	public void armDown() {
		System.out.println("Arm down!");
		armMotor.set(-0.5);
	}
	public void armStop() {
		System.out.println("Stop Arm");
		armMotor.set(0.0);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
