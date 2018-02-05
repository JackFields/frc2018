// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc5472.TrackerTest;

import org.usfirst.frc5472.TrackerTest.commands.AutonomousCommand;
import org.usfirst.frc5472.TrackerTest.commands.FeedCommand;
import org.usfirst.frc5472.TrackerTest.commands.IntakeCommand;
import org.usfirst.frc5472.TrackerTest.commands.LiftCommand;
import org.usfirst.frc5472.TrackerTest.subsystems.DriveSubsystem;
import org.usfirst.frc5472.TrackerTest.subsystems.IntakeSubsystem;
import org.usfirst.frc5472.TrackerTest.subsystems.LiftSubsystem;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends IterativeRobot {

	Command autonomousCommand;
	SendableChooser autoChooser;
	SendableChooser<Command> chooser = new SendableChooser<>();

	public static OI oi;

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	private DriveSubsystem drive;
	Joystick j = new Joystick(0);
	private static Robot instance;
	// private JeVois jevois;
	private IntakeSubsystem intake;
	private LiftSubsystem lift;

	private DigitalInput limitSwitch;

	// END AUTOGENERATED CODE, SOURCE=R OBOTBUILDER ID=DECLARATIONS

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		RobotMap.init();
		instance = this;

		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
		drive = new DriveSubsystem();
		intake = new IntakeSubsystem();
		lift = new LiftSubsystem();
		oi = new OI();
		limitSwitch = new DigitalInput(0);
		autoChooser = new SendableChooser();
		autoChooser.addDefault("Intake Command", new IntakeCommand());
		autoChooser.addObject("Feed Command", new FeedCommand());
		autoChooser.addObject("Lift Command", new LiftCommand());
		// jevois = new JeVois();

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
		// OI must be constructed after subsystems. If the OI creates Commands
		// (which it very likely will), subsystems are not guaranteed to be
		// constructed yet. Thus, their requires() statements may grab null
		// pointers. Bad news. Don't move it.

		// Add commands to Autonomous Sendable Chooser
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

		chooser.addDefault("Autonomous Command", new AutonomousCommand());

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS
		SmartDashboard.putData("Auto mode", chooser);

	}

	/**
	 * This function is called when the disabled button is hit. You can use it
	 * to reset subsystems before shutting down.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() {
		/*
		 * autonomousCommand = chooser.getSelected(); // schedule the autonomous
		 * command (example) if (autonomousCommand != null)
		 * autonomousCommand.start();
		 */
		autonomousCommand = (Command) autoChooser.getSelected();
		autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.

		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		/*
		 * SmartDashboard.putNumber("Jim", j.getY());
		 * SmartDashboard.putNumber("Jill",j.getX());
		 * SmartDashboard.putString("Grabber", IntakeSubsystem.solenoidState);
		 * SmartDashboard.putBoolean("GIBBLOCK", limitSwitch.get());
		 * SmartDashboard.putNumber("XBOX",
		 * oi.getXbox().getTriggerAxis(Hand.kLeft));
		 */
		SmartDashboard.putData(drive);
		SmartDashboard.putData("Feed Command", new FeedCommand());
		SmartDashboard.putData("Auto Command", new AutonomousCommand());
		SmartDashboard.putData(intake);
		SmartDashboard.putData("Intake Command", new IntakeCommand());
		SmartDashboard.putData(lift);
		SmartDashboard.putData("Lift Command", new LiftCommand());

		// SmartDashboard.putString("JeVois Target", jevois.read());

	}

	public static Robot getInstance() {
		return instance;
	}

	public DriveSubsystem getDriveSubsystem() {
		return drive;

	}

	public OI getOI() {
		return oi;
	}

	public IntakeSubsystem getIntakeSubsystem() {
		return intake;
	}

	public LiftSubsystem getLiftSubsystem() {
		return lift;
	}

}
