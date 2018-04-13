package org.usfirst.frc.team5472.robot.autonomous.commands;

import org.usfirst.frc.team5472.robot.Constants;
import org.usfirst.frc.team5472.robot.Robot;
import org.usfirst.frc.team5472.robot.subsystems.DriveSubsystem;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Command;

/**
 * A Command used to turn the robot to a specified heading.
 */
public class Turn extends Command{
	
	private PIDSource angleSource;
	private PIDOutput turnOutput;
	private PIDController turnController;
	
	private double setpoint;
	private boolean wasHigh; // Whether the robot was in high gear before running the command
	
	private DriveSubsystem drive;
	
	/**
	 * Initializes local variables and PID controllers.
	 *
	 * @param target the desired heading.
	 */
	public Turn(double target) {
		setpoint = target;
		drive = Robot.drive;
		
		angleSource = new PIDSource() {
			public double pidGet() {
				return drive.getHeading();
			}
			public PIDSourceType getPIDSourceType() {return PIDSourceType.kDisplacement;}
			public void setPIDSourceType(PIDSourceType t) {}
		};
		
		turnOutput = (double output) -> {
			drive.drive(-output, output);
		};
		
		turnController = new PIDController(Constants.DRIVE_AUTO_TURN_P, Constants.DRIVE_AUTO_TURN_I, Constants.DRIVE_AUTO_TURN_D, angleSource, turnOutput);
		turnController.setInputRange(-180.0, 180.0);
		turnController.setContinuous(true);
		turnController.setOutputRange(-Constants.DRIVE_AUTO_OUTPUT_LIMIT, Constants.DRIVE_AUTO_OUTPUT_LIMIT);
		turnController.setAbsoluteTolerance(2);
	}
	
	/* (non-Javadoc)
	 * @see edu.wpi.first.wpilibj.command.Command#initialize()
	 */
	@Override
	public void initialize() {
		wasHigh = drive.isHighGear();
		drive.lowGear();
		turnController.reset();
		turnController.setSetpoint(setpoint);
		turnController.enable();
	}

	/* (non-Javadoc)
	 * @see edu.wpi.first.wpilibj.command.Command#execute()
	 */
	@Override
	public void execute() {
	}
	
	/* (non-Javadoc)
	 * @see edu.wpi.first.wpilibj.command.Command#isFinished()
	 */
	@Override
	public boolean isFinished() {
		return turnController.onTarget();
	}
	
	/* (non-Javadoc)
	 * @see edu.wpi.first.wpilibj.command.Command#end()
	 */
	@Override
	public void end() {
		turnController.reset();
		if(wasHigh)
			drive.highGear();
	}
}
