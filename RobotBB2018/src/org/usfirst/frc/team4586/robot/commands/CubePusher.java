package org.usfirst.frc.team4586.robot.commands;

import org.usfirst.frc.team4586.robot.Robot;
import org.usfirst.frc.team4586.robot.subsystems.CubeSystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CubePusher extends Command {
	
	CubeSystem cubeSystem;
	boolean isOpened;
	
    public CubePusher(){
      	 this.cubeSystem=Robot.cubeSystem;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(0.5);
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	cubeSystem.setCubePusher(!this.cubeSystem.isOpenedPusher());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
