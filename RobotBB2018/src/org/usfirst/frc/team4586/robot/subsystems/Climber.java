package org.usfirst.frc.team4586.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem {
	Compressor compressor;
	Jaguar climbMotor1;
	Jaguar climbMotor2;
	Solenoid openRightPlatfrom;
	Solenoid openLeftPlatfrom;
	
	 //הפעולה מגדירה את המנועים
	public Climber(Jaguar climbMotor1,Jaguar climbMotor2 ,Compressor compressor, Solenoid openLeftPlatfrom, Solenoid openRightPlatfrom) 
	{
		this.climbMotor1 =climbMotor1;
		this.climbMotor2 =climbMotor2;
		this.compressor = compressor;
		this.openRightPlatfrom = openRightPlatfrom;
		this. openLeftPlatfrom = openLeftPlatfrom;
	}
	//בודק אם המכנות פתוחות
		public boolean isOpened()
		{
			return (openRightPlatfrom.get() && openLeftPlatfrom.get());
		}
		//אם הבוכנות פתוחות אז זה סוגר אותן אותן
		public void setPiston(boolean isOpsened) 
		{
			if(isOpsened){
				openRightPlatfrom.set(false);
				openLeftPlatfrom.set(false);
			}
			else{
				openRightPlatfrom.set(true);
				openLeftPlatfrom.set(true);
			}
		}
		
	//הפעולה שמה ערך מהירות בכל מנועה
	public void setSpeedClimb(double speed)
	{
		this.climbMotor1.set(speed);
		this.climbMotor2.set(speed);
	}
	//אותו דבר כמו הקודם
	public void setSpeedPlatforms(boolean open)
	{
		this.openLeftPlatfrom.set(open);
		this.openRightPlatfrom.set(open);
	}
	//אותו דבר כמו הקודם רק לשמאל
	public void setSpeedPlatformsLeft(boolean open)
	{
		this.openLeftPlatfrom.set(open);
	
	}
	//אותו דבר כמו הקודם רק לביבי 
		public void setSpeedPlatformsRight(boolean open)
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

