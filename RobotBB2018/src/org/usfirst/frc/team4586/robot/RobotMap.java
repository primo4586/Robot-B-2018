/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4586.robot;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;

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
	public static Victor climbMotor1;
	public static Victor climbMotor2;
	public static Solenoid openPlatfroms;
	public static Solenoid closePlatfroms;
	public static Solenoid pushCube;
	public static Victor elevatorsMotor;
	public static AnalogGyro gyro;
	public static Encoder drivingEncoder;
	public static DigitalInput scaleSensor;
	public static DigitalInput switchSensor;
	public static DigitalInput floorSensor;
	public static Compressor compressor;
	public static Solenoid solenoidCube1;
	public static Solenoid solenoidCube2;

	public static void Init() {
		// TODO Check connections
		leftFrontMotor = new Jaguar(3);
		leftBackMotor = new Jaguar(7);
		rightFrontMotor = new Jaguar(4);
		rightBackMotor = new Jaguar(6);
		climbMotor1 = new Victor(2);
		climbMotor2 = new Victor(0);
		openPlatfroms = new Solenoid(5);
		closePlatfroms = new Solenoid(4);
		elevatorsMotor = new Victor(5);
		gyro = new AnalogGyro(1);
		drivingEncoder = new Encoder(1, 2);
		scaleSensor = new DigitalInput(3);
		switchSensor = new DigitalInput(4);
		floorSensor = new DigitalInput(5);
		compressor = new Compressor();
		solenoidCube1 = new Solenoid(2);
		solenoidCube2 = new Solenoid(1);
		pushCube = new Solenoid(6);
	}
	

	// For example to map the left and right motors, you could define the
	// following variables to use with your subsystem.
	// public static leftMotor = 1;
	// public static rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a :
	// public static rangefinderPort = 1;
	// public static rangefinderModule = 1;
}
