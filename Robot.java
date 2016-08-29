/**
* Maze Solver 
* 9/17/2010
* This is the robot object class
*  *  @author Christopher Finn <cfinn@student.umass.edu> -- 23657096
*/

public class Robot 
{
	private int x;
	private int y;
	private int id; // Trail number of robot
	private int tp; // Target portal
	private int oppId; // Trail number of other robot
	private boolean over;
	private Maze rMaze;
	CellStorage stack;
	
	public Robot(int a, int b, int i, int t, Maze c)
	{
		x = a;
		y = b;
		id = i;
		tp = t;
		rMaze = c;
		over = false;
		stack = new CellStorage(200);
		if(id == 7)
			oppId = 8;
		else
			oppId = 7;
	}
	
	/**
	* Returns robot's x value
	*/
	public int xVal()
	{
		return x;
	}
	
	/**
	* Returns robot's y value
	*/
	public int yVal()
	{
		return y;
	}
	
	/**
	* Starts robot's move
	*/
	public void move()
	{
		checkArea();
	}
	
	/**
	* Checks if the boxes left, up, right, & down of the robot's position are valid moves.
	* It then calls updateLoc(i), moving the robot & then updates previous spot 
	*/
	private void checkArea()
	{
		int[] Box = {rMaze.getVal(y, x-1),rMaze.getVal(y+1, x),rMaze.getVal(y, x+1),rMaze.getVal(y-1, x)};
		for(int i=0; i<4; i++)
		{		
			if(Box[i] == 1 || Box[i] == oppId || Box[i] == tp)
			{
				stack.push(y);
				stack.push(x);
				updateLoc(i);
				if(Box[i] == 1)
					rMaze.setVal(x, y, id);
				if(Box[i] == oppId)
					rMaze.setVal(x, y, 9);
				if(Box[i] == tp)
					rMaze.setVal(x, y, id);
				over=atPortal();
				return;
			}
		}
		backTrack(); // If dead end is it
	}
	
	/**
	* Moves robot to next valid location
	*/
	private void updateLoc(int i)
	{
		switch(i)
		{
		case(0):
			x = x-1;
			break;
		case(1):
			y = y+1;
			break;
		case(2):
			x = x+1;
			break;
		case(3):
			y = y-1;
			break;
		}
	}
	
	/**
	* Pops robot's previous move off the stack & backtracks
	*/
	private void backTrack()
	{
		if(!stack.isEmpty())
		{
			x = stack.pop();
			y = stack.pop();
		}
		else
		{
			System.out.println("No route found!"); //No more moves too make
			over = true;
		}
	}
	
	/**
	* Checks & returns if robot reached target portal
	*/
	private boolean atPortal()
	{
		if(rMaze.getVal(y, x) == tp)
		{
			System.out.println("Mission completed");
			return(true);
		}
		return false;
	}
	
	/**
	* Returns if the robot reached a reason to end application
	*/
	public boolean isOver()
	{
		return over;
	}
}















