package _00_Intro_To_Arrays;

import java.util.Random;

import javax.swing.JOptionPane;

import org.jointheleague.graphical.robot.Robot;

public class _02_RobotRace {
	//1. make a main method
	public static void main(String[] args) {
		//2. create an array of 5 robots.
		Robot[] robots = {new Robot(), new Robot(),new Robot(),new Robot(),new Robot(), new Robot()};

		//3. use a for loop to initialize the robots.
		for (int i = 0; i<robots.length; i++) {
			robots[i] = new Robot(100 + 100*i, 700);
		}
		//4. make each robot start at the bottom of the screen, side by side, facing up

		//5. use another for loop to iterate through the array and make each robot move 
		//   a random amount less than 50.
		while(robots[0].getY() > 0 || robots[1].getY() > 0 || robots[2].getY() > 0 || robots[3].getY() > 0 || robots[4].getY() > 0 || robots[5].getY() > 0) {
			for (int i = 0; i<robots.length; i++) {
				try {
					robots[i].microMove(new Random().nextInt(49) + 1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		int firstPlace = 0;
		for (int i = 0; i < robots.length; i++) {
			if (robots[i].getY() < robots[firstPlace].getY()) {
				firstPlace = i;
			}
		}
		firstPlace++;
		JOptionPane.showMessageDialog(null, "Robot " + firstPlace + " has won! Great job, robot " + firstPlace + "!");
		//6. use a while loop to repeat step 5 until a robot has reached the top of the screen.

		//7. declare that robot the winner and throw it a party!

		//8. try different races with different amounts of robots.

		//9. make the robots race around a circular track.
	}
}
