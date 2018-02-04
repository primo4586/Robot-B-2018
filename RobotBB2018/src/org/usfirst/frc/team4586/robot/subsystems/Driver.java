package org.usfirst.frc.team4586.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.PIDController;
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
	
	private DrivingGyroPID gyroSource;
	private DrivingRotationPID rotationPID;
	PIDController gyroController;
	
	private DrivingEncoderPID encoderSource;
	private DrivingSpeedPID speedPID;
	PIDController encoderController;

	public Driver(Jaguar leftFrontMotor,Jaguar leftBackMotor ,Jaguar rightFrontMotor,Jaguar rightBackMotor ,AnalogGyro gyro,Encoder drivingEncoder) 
	{
		this.leftFrontMotor = leftFrontMotor;
		this.leftBackMotor = leftBackMotor;
		this.rightFrontMotor = rightFrontMotor;
		this.rightBackMotor =rightBackMotor;
		this.gyro=gyro;
		this.drivingEncoder=drivingEncoder;
		this.drivingEncoder.setDistancePerPulse(0.47877872);
		this.rightController = new SpeedControllerGroup(this.rightBackMotor, this.rightFrontMotor);
		this.leftController = new SpeedControllerGroup(this.leftBackMotor, this.leftFrontMotor);
		this.diffDrive = new DifferentialDrive(this.leftController, this.rightController);
		
		this.encoderSource = new DrivingEncoderPID(drivingEncoder);
		this.speedPID =  new DrivingSpeedPID();
		this.encoderController = new PIDController(0, 0, 0, this.encoderSource, this.speedPID);
		this.gyroSource = new DrivingGyroPID(this.gyro);
		this.rotationPID = new DrivingRotationPID();
		this.gyroController = new PIDController(0, 0, 0, this.gyroSource, this.rotationPID);
	}
	
	public PIDController getGyroController(){
		return this.gyroController;
	}
	
	public PIDController getEncoderController(){
		return this.encoderController;
	}
	
	public void setSetPointGyro(double setpoint) {
		this.gyroController.setSetpoint(setpoint);
	}
	
	public void setEncoderControllerSetPoint(double setpoint) {
		this.encoderController.setSetpoint(setpoint);
	}
	
	public void enableGyro() {
		this.gyroController.enable();
	}
	
	public void enableEncoder() {
		this.encoderController.enable();
	}
	
	public void disableEncoder() {
		this.encoderController.disable();
	}
	
	
	public void disableGyro() {
		this.gyroController.disable();
	}
	
	public double getRotation() {
		return this.rotationPID.getRotation();
	}
	
	public double getSpeed() {
		return this.speedPID.getSpeed();
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
