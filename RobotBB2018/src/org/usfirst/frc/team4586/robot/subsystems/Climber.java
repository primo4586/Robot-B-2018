package org.usfirst.frc.team4586.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *	Climber System
 */
public class Climber extends Subsystem {
	Compressor compressor;
	Jaguar climbMotor1;
	Jaguar climbMotor2;
	Solenoid openRightPlatfrom;
	Solenoid openLeftPlatfrom;
	boolean isOpen;
	

	public Climber(Jaguar climbMotor1,Jaguar climbMotor2 ,Compressor compressor, Solenoid openLeftPlatfrom, Solenoid openRightPlatfrom) 
	{
		this.isOpen=false;
		this.climbMotor1 =climbMotor1;
		this.climbMotor2 =climbMotor2;
		this.compressor = compressor;
		this.openRightPlatfrom = openRightPlatfrom;
		this. openLeftPlatfrom = openLeftPlatfrom;
	}

	//checks if the platforms' pistons are opened
	public boolean isOpened()
	{
		return (openRightPlatfrom.get() && openLeftPlatfrom.get());
	}
	
	//set the pistons state
	public void setPiston(boolean isOpsened) 
	{
		
			openRightPlatfrom.set(!isOpsened);
			openLeftPlatfrom.set(!isOpsened);
	}
			
		
	
	public void setSpeedClimb(double speed)
	{
		this.climbMotor1.set(speed);
		this.climbMotor2.set(speed);
	}

	public void setPlatforms(boolean open)
	{
		this.openLeftPlatfrom.set(open);
		this.openRightPlatfrom.set(open);
	}

	public void setPlatformLeft(boolean open)
	{
		this.openLeftPlatfrom.set(open);
	
	}
	

	public void setPlatformRight(boolean open)
	{
		this.openRightPlatfrom.set(open);
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

