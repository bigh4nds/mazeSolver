/**
* Maze Solver 
* 9/17/2010
* This is the Maze object class
*  *  @author Christopher Finn <cfinn@student.umass.edu> -- 23657096
*/

public class Maze 
{
	private int[][] rMaze;
	
	public Maze()
	{
		rMaze= new int[][]         // Initializing the Maze
		  {{-1,1,2,1,1,1,1,2,1,2}, // -1 = Portal 1
	      {2,1,2,2,2,1,2,1,1,1},   //  0 = Portal 2
	      {1,1,1,1,1,1,2,1,2,1},   //  1 = Path
	      {1,2,2,2,1,2,1,1,2,1,},  //  2 = Wall
	      {1,2,1,2,1,2,2,1,2,1,},
	      {2,1,1,1,1,2,2,1,2,1},
	      {2,1,2,2,2,2,2,1,2,1},
	      {2,1,2,1,1,1,1,1,2,1,},
	      {2,1,2,2,2,2,1,2,2,1},
	      {1,1,1,1,1,1,1,1,2,0}};
	}
	
	/**
	* Returns Maze value at [y,x] if in maze dimensions
	*/
	public int getVal(int y, int x)       
	{
		if(x>=0 && x<=9 && y>=0 && y<=9)
			return(rMaze[y][x]);
		else
			return 3;
	}
	
	/**
	* Sets Maze value at [y,x] with id unless [y,x] is a portal
	*/
	public void setVal(int x, int y, int id)
	{
		if((x == 0 && y == 0)||(x == 9 && y == 9))
		{}
		else
			rMaze[y][x] = id; 
	}
	
	/**
	* Displays Maze
	*/
	public void display()
	{
		for(int i=0; i<10; i++)
		{
			for(int k=0; k<10; k++)
			{
				if(rMaze[i][k]==-1)
					System.out.print(rMaze[i][k]+" ");
				else					
					System.out.print(" "+rMaze[i][k]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
