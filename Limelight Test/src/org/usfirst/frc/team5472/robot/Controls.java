package org.usfirst.frc.team5472.robot;

import org.usfirst.frc.team5472.robot.autonomous.Recorder;
import org.usfirst.frc.team5472.robot.autonomous.commands.StartRecording;
import org.usfirst.frc.team5472.robot.autonomous.commands.StopRecording;
import org.usfirst.frc.team5472.robot.commands.GripToggle;
import org.usfirst.frc.team5472.robot.commands.HighGear;
import org.usfirst.frc.team5472.robot.commands.IntakePull;
import org.usfirst.frc.team5472.robot.commands.IntakePush;
import org.usfirst.frc.team5472.robot.commands.IntakeStop;
import org.usfirst.frc.team5472.robot.commands.LiftCoast;
import org.usfirst.frc.team5472.robot.commands.LiftStop;
import org.usfirst.frc.team5472.robot.commands.ShiftGear;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class Controls {

	private Joystick playerOne = new Joystick(0);
	private Joystick playerTwo = new Joystick(1);

//	private JoystickButton toggleLights = new JoystickButton(stick, 2);
//	private JoystickButton enableVision = new JoystickButton(stick, 10);
//	private JoystickButton disableVision = new JoystickButton(stick, 9);
//	private JoystickButton switchPipeline = new JoystickButton(stick, 11);
//	private JoystickButton boxPipeline = new JoystickButton(stick, 12);
//	private JoystickButton flashLights = new JoystickButton(stick, 6);
	private JoystickButton shiftGear = new JoystickButton(playerOne, 3);

	private JoystickButton intakeIn = new JoystickButton(playerOne, 5);
	private JoystickButton intakeOut = new JoystickButton(playerOne, 6);
	private JoystickButton toggleGrip = new JoystickButton(playerOne, 1);
	
	private JoystickButton highButton = new JoystickButton(playerOne, 4);
	
	private JoystickButton liftDown = new JoystickButton(playerTwo, 1);
	
	public LimitSwitch highLimit = new LimitSwitch(0);

	
	public Controls() {
//		toggleLights.whenReleased(new ToggleLights());
//		enableVision.whenReleased(new EnableVision());
//		disableVision.whenReleased(new DisableVision());
//		switchPipeline.whenReleased(new SwitchPipeline());
//		boxPipeline.whenReleased(new BoxPipeline());
		shiftGear.whenPressed(new ShiftGear());
		shiftGear.whenReleased(new ShiftGear());
		highButton.whenPressed(new HighGear());
		
		intakeIn.whenPressed(new IntakePull());
		intakeIn.whenReleased(new IntakeStop());
		intakeOut.whenPressed(new IntakePush());
		intakeOut.whenReleased(new IntakeStop());

		toggleGrip.whenPressed(new GripToggle());
		
//		highLimit.whenPressed(new LowGear());
		highLimit.whileActive(new LiftStop());

		
		liftDown.whenPressed(new LiftCoast());
		
		JoystickButton startRecording = new JoystickButton(playerTwo, 10);
		JoystickButton stopRecording = new JoystickButton(playerTwo, 9);
		
		Recorder record = new Recorder();
		startRecording.whenPressed(new StartRecording(record));
		stopRecording.whenPressed(new StopRecording(record));
	}

	public Joystick getPlayerOne() {
		return playerOne;
	}
	
	public Joystick getPlayerTwo() {
		return playerTwo;
	}
	
	public double getLiftUpAxis() {
		return playerTwo.getRawAxis(3);
	}
	
	public double getLiftDownAxis() {
		return playerTwo.getRawAxis(2);
	}
	
	public double getDriveVerticalAxis() {
		return playerOne.getRawAxis(1);
	}
	
	public double getDriveHorizontalAxis() {
		return playerOne.getRawAxis(0);
	}
}
