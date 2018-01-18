package org.usfirst.frc.team4586.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class CubeSystem extends Subsystem {
	Compressor compressor;
	Solenoid solenoid1;
	Solenoid solenoid2;
	Victor elevatorsMotor;
	DigitalInput scaleSensor;
	DigitalInput switchSensor;
	DigitalInput floorSensor;
	
	public CubeSystem(Solenoid solenoid2,Solenoid solenoid1,Compressor compressor, Victor elevatorsMotor, DigitalInput scaleSensor, DigitalInput switchSensor, DigitalInput floorSensor)
	{
		this.compressor = compressor;
		this.solenoid1 = solenoid1;
		this.solenoid2= solenoid2;
		this.elevatorsMotor = elevatorsMotor;
		this.scaleSensor = scaleSensor;
		this.switchSensor=switchSensor;
		this.floorSensor=floorSensor;
	}
	//בודק אם המכנות פתוחות
	public boolean isOpened()
	{
		return (solenoid1.get() && solenoid2.get());
	}
	//אם הבוכנות פתוחות אז זה סוגר אותן אותן
	public void setPiston(boolean isOpsened) 
	{
		if(isOpsened){
			solenoid1.set(false);
			solenoid2.set(false);
		}
		else{
			solenoid1.set(true);
			solenoid2.set(true);
		}
	}
	//קובע את מהירות המעלית
	public void setSpeedElevators(double speed)
	{
		this.elevatorsMotor.set(speed);
	}
//מקבל את מהירות המעלית
	public double getSpeedElevators()
	{
		return this.elevatorsMotor.getSpeed();
	}
	//מקבל את הערך של חישן רצפה וכל מה שאחריו עד לתיעוד הבא אותו רעיון
	public boolean getFloorSensor()
	{
		return floorSensor.get();
	}
	public boolean getSwitchSensor()
	{
		return switchSensor.get();
	}
	public boolean getScaleSensor()
	{
		return scaleSensor.get();
	}
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

