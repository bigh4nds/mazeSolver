/**
* Maze Solver 
* 9/17/2010
* This class creates the maze, & both robot objects as well as the main loop
*  *  @author Christopher Finn <cfinn@student.umass.edu> -- 23657096
*/

public class MazeProblem 
{
	public static void main(String[] args) 
	{
		Maze rMaze = new Maze();
		Robot robot1 = new Robot(0,0,7,0,rMaze);
		Robot robot2 = new Robot(9,9,8,-1,rMaze);
		while(!robot1.isOver() && !robot2.isOver())
		{
			int r = (int)(Math.round(Math.random())); // Randomly decides which robot will move
			if(r == 0)
				robot1.move();
			else
				robot2.move();
			if(robot1.xVal() == robot2.xVal() && robot1.yVal() == robot2.yVal()) // Checks if the robots crashed into each other
			{
				rMaze.setVal(robot1.xVal(), robot1.yVal(), 4); // Show crash cell with a 4
				rMaze.display();
				System.out.println("Mission completed");
				break;
			}
			rMaze.display();
		}
	}
}
