package org.usfirst.frc.team4586.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class Driver extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	Jaguar leftFrontMotor;
	Jaguar leftBackMotor;
	Jaguar rightFrontMotor;
	Jaguar rightBackMotor;
	AnalogGyro gyro;
	Encoder drivingEncoder ;
	SpeedControllerGroup rightController, leftController;
	DifferentialDrive diffDrive;

	public Driver(Jaguar leftFrontMotor,Jaguar leftBackMotor ,Jaguar rightFrontMotor,Jaguar rightBackMotor ,AnalogGyro gyro,Encoder drivingEncoder) 
	{
		this.leftFrontMotor = leftFrontMotor;
		this.leftBackMotor = leftBackMotor;
		this.rightFrontMotor = rightFrontMotor;
		this.rightBackMotor =rightBackMotor;
		this.gyro=gyro;
		this.drivingEncoder=drivingEncoder;
		this.rightController = new SpeedControllerGroup(this.rightBackMotor, this.rightFrontMotor);
		this.leftController = new SpeedControllerGroup(this.leftBackMotor, this.leftFrontMotor);
		this.diffDrive = new DifferentialDrive(this.leftController, this.rightController);
	}
	
	
	

	
	//wheels
	  public double getWheelSpeedLeftFront() 
	  {
		  return leftFrontMotor.get();
	  }
	  public double getWheelSpeedLeftBack() 
	  {
		  return leftBackMotor.get();
	  }
	  public double getWheelSpeedRightBack() 
	  {
		  return rightBackMotor.get();
	  }
	  public double getWheelSpeedRightFront() 
	  {
		  return rightFrontMotor.get();
	  }
	  //stops the wheels
	  public void stopAllWheels()
		{
			this.leftBackMotor.set(0);
			this.leftFrontMotor.set(0);
			this.rightFrontMotor.set(0);
			this.rightBackMotor.set(0);
		}
	  
	  //gyro
		public void resetGyro()
		{
			this.gyro.reset();
		}
		public double getGyroAngle()
		{
			return this.gyro.getAngle();
		}
		//calibrates the gyro
		public void calibrateGyro()
		{
			this.gyro.calibrate();
		}
		

		//encoder
		public double getSpeedEncoder()
		{
			return drivingEncoder.get();
		}
		public double getDistenceEncoder()
		{
			return this.drivingEncoder.getDistance();
		}
		public void resetEncoder()
		{
			this.drivingEncoder.reset();
		}
		
		//drive
		public void arcadeDrive(double speed, double rotation)
		{
			this.diffDrive.arcadeDrive(speed, rotation);
		}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
