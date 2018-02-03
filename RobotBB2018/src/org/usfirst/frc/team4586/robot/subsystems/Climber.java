package org.usfirst.frc.team4586.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Climber System
 */
public class Climber extends Subsystem {
    Compressor compressor;
    Victor climbMotor1;
    Victor climbMotor2;
    Solenoid openPlatfroms;
    Solenoid closePlatfroms;
    boolean isOpen;

    public Climber(Victor climbMotor1, Victor climbMotor2, Compressor compressor, Solenoid closePlatfroms,
	    Solenoid openPlatfroms) {
	this.isOpen = false;
	this.climbMotor1 = climbMotor1;
	this.climbMotor2 = climbMotor2;
	this.compressor = compressor;
	this.openPlatfroms = openPlatfroms;
	this.closePlatfroms = closePlatfroms;
    }

    // checks if the platforms' pistons are opened
    public boolean isOpened() {
	return openPlatfroms.get();
    }

    // set the pistons state
    public void setPiston(boolean isOpened) {

	openPlatfroms.set(!isOpened);
	closePlatfroms.set(isOpened);
    }

    public void setSpeedClimb(double speed) {
	this.climbMotor1.set(speed);
	this.climbMotor2.set(speed);
    }

    public void setPlatforms(boolean open) {
	this.closePlatfroms.set(!open);
	this.openPlatfroms.set(open);
    }

    public void setPlatformLeft(boolean open) {
	this.closePlatfroms.set(open);

    }

    public void setPlatformRight(boolean open) {
	this.openPlatfroms.set(open);
    }

    public void stopAllClimberMotors() {
	this.climbMotor1.setSpeed(0);
	this.climbMotor2.setSpeed(0);
    }
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
	// Set the default command for a subsystem here.
	// setDefaultCommand(new MySpecialCommand());
    }
}
