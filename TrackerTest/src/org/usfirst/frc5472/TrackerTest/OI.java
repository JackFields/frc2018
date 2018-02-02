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

import org.usfirst.frc5472.TrackerTest.commands.FeedCommand;
import org.usfirst.frc5472.TrackerTest.commands.IntakeCommand;
import org.usfirst.frc5472.TrackerTest.commands.TestCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	public Joystick joystick1;
	public JoystickButton test;
	private JoystickButton button1;
	private JoystickButton button2;
	private XboxController xbox;
	private JoystickButton intakeButton, feedInButton, feedOutButton;
	private JoystickButton liftButton, lowerButton;
	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

	public OI() {
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

		joystick1 = new Joystick(0);
		xbox = new XboxController(2);

		button1 = new JoystickButton(joystick1, 2);
		button2 = new JoystickButton(joystick1, 3);
		intakeButton = new JoystickButton(xbox, 1);
		feedInButton = new JoystickButton(xbox, 5);
		feedOutButton = new JoystickButton(xbox, 6);
		liftButton = new JoystickButton(xbox, 4);
		lowerButton = new JoystickButton(xbox, 3);

		button2.whenPressed(new TestCommand());
		intakeButton.whenPressed(new IntakeCommand());
		feedInButton.whileHeld(new FeedCommand());
		feedOutButton.whileHeld(new FeedCommand());
		// SmartDashboard Buttons

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

	}

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
	public Joystick getJoystick1() {
		return joystick1;
	}

	public XboxController getXbox() {
		return xbox;
	}

	public JoystickButton getIntakeButton() {
		return intakeButton;
	}

	public JoystickButton getFeedInButton() {
		return feedInButton;
	}

	public JoystickButton getFeedOutButton() {
		return feedOutButton;
	}

	public JoystickButton getLiftButton() {
		return liftButton;
	}

	public JoystickButton getLowerButton() {
		return lowerButton;
	}
	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}
