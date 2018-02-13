package org.usfirst.frc.team5472.robot.autonomous.commands;

import org.usfirst.frc.team5472.robot.Constants;

import com.team5472.robot.pathfinder.Pathfinder;
import com.team5472.robot.pathfinder.Segment;
import com.team5472.robot.pathfinder.Waypoint;
import com.team5472.robot.pathfinder.modifiers.TankModifier;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class PassAutoLine extends CommandGroup {

	 private Segment[] left;
	 private Segment[] right;

	public PassAutoLine() {
		 Waypoint[] points = {
				 new Waypoint(0, 0, 90),
				 new Waypoint(0, 2, 135),
				 new Waypoint(1, 2, 180)
		 };
		 Segment[] trajectory = Pathfinder.generate(points, Constants.TRAJECTORY_CONFIG);
		 TankModifier modifier = new TankModifier(trajectory);
		 modifier.modify(Constants.ROBOT_WHEELBASE_WIDTH);
		 left = modifier.getLeft();
		 right = modifier.getRight();
		 addSequential(new FollowPath(left, right));
	}
}