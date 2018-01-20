package org.usfirst.frc.team4586.robot.commands;

import org.usfirst.frc.team4586.robot.OI;
import org.usfirst.frc.team4586.robot.Robot;
import org.usfirst.frc.team4586.robot.subsystems.CubeSystem;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class LiftToFloor extends Command {
	CubeSystem cubeSystem;
	 OI oi;
    public LiftToFloor() {
    	 this.cubeSystem=Robot.cubeSystem;
	        this.oi=Robot.m_oi;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	cubeSystem.setSpeedElevators(-SmartDashboard.getNumber("Elavator Speed",0));
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	  
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return cubeSystem.getFloorSensor();
    }

    // Called once after isFinished returns true
    protected void end() {
    	cubeSystem.setSpeedElevators(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	cubeSystem.setSpeedElevators(0);
    }
}
