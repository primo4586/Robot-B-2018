package org.usfirst.frc.team4586.robot.commands;

import org.usfirst.frc.team4586.robot.OI;
import org.usfirst.frc.team4586.robot.Robot;
import org.usfirst.frc.team4586.robot.subsystems.CubeSystem;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */

//ANALOG CONTROL IN ELEVATOR

public class LiftCubeByJoystick extends Command {
	 private CubeSystem cubeSystem;
	 private OI oi;
	 private double speed;
	 
    public LiftCubeByJoystick() {
        this.cubeSystem=Robot.cubeSystem;
        this.oi=Robot.m_oi;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	this.speed = this.oi.joystickOpertor.getRawAxis(1) * SmartDashboard.getNumber("Elavator Speed",0);
    	if((cubeSystem.getScaleSensor() && speed > 0) || (cubeSystem.getFloorSensor() && speed < 0)) {
    		this.speed=0;
    	}
    	this.cubeSystem.setSpeedElevators(this.speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	this.cubeSystem.setSpeedElevators(0);

    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	this.cubeSystem.setSpeedElevators(0);

    }
}
