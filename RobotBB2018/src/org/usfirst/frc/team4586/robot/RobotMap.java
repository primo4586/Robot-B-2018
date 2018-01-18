/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4586.robot;

import java.util.Vector;

import javax.naming.InitialContext;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.interfaces.Gyro;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	public static Jaguar leftFrontMotor;
	public static Jaguar leftBackMotor;
	public static Jaguar rightFrontMotor;
	public static Jaguar rightBackMotor;
	public static Jaguar climbMotor1;
	public static Jaguar climbMotor2;
	public static Solenoid openLeftPlatfrom;
	public static Solenoid openRightPlatfrom;
	public static Victor elevatorsMotor;
	public static AnalogGyro gyro;
	public static Encoder drivingEncoder ;
	public static DigitalInput scaleSensor;
	public static DigitalInput switchSensor;
	public static DigitalInput floorSensor;
	public static Compressor compressor;
	public static Solenoid solenoidCube1;
	public static Solenoid solenoidCube2;
	
	public static void Init()
	{
		//צריך לבדוק חיבורים
		leftFrontMotor = new Jaguar(2);
		leftBackMotor = new Jaguar(4);
		rightFrontMotor = new Jaguar(8);
		rightBackMotor = new Jaguar(1);
		climbMotor1 = new Jaguar(9);
		climbMotor2 = new Jaguar(5);
		openLeftPlatfrom =  new Solenoid(9);
		openRightPlatfrom =  new Solenoid(5);
		elevatorsMotor = new Victor(2);
		gyro = new AnalogGyro(0);
		drivingEncoder = new Encoder(0,0);
		scaleSensor = new DigitalInput(0);
		switchSensor= new DigitalInput(0);
		floorSensor= new DigitalInput(0);
		compressor = new  Compressor();
		solenoidCube1 = new Solenoid(0);
		solenoidCube2 = new Solenoid(0);
	}
	
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}

