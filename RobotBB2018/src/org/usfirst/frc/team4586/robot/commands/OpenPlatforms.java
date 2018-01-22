package org.usfirst.frc.team4586.robot.commands;

import org.usfirst.frc.team4586.robot.Robot;
import org.usfirst.frc.team4586.robot.subsystems.Climber;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class OpenPlatforms extends Command {
	boolean isOpenedBothPistons;
	boolean isToOpen;
	private Climber climber;
    public OpenPlatforms() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.climber = Robot.climber;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	climber.setPlatforms(true);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return climber.isOpened();
    }

    // Called once after isFinished returns true
    protected void end() {
    	climber.setPlatforms(false);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	climber.setPlatforms(false);
    }
}
