/**
* Maze Solver 
* 9/17/2010
* This is the CellStorage object class 
*  *  @author Christopher Finn <cfinn@student.umass.edu> -- 23657096
*/


public class CellStorage
{
   private int maxSize;      // The default size of the stack
   private int stackArray[];     // The array that implements the stack
   private int topOfStack;          // Variable that stores the index of the top item on the stack
 
   /**
	* Initialize object
	*/
   public CellStorage (int n)
   {
	  maxSize = n;
      stackArray = new int[maxSize];
      topOfStack = -1;
   }
   
   /**
	* Checks & returns if empty
	*/
   public boolean isEmpty()
   {
      return (topOfStack == -1);
   }
   
   /**
	* Checks & returns if full
	*/
   public boolean isFull()
   {
      return size() == stackArray.length;
   }
   
   /**
	* Returns top value without deleting it
	*/
   public int peek()
   {
      if (isEmpty())
         throw new IllegalArgumentException("ArrayStack peek");
      return stackArray[topOfStack];
   }
   
   /**
	* Returns top value & removes it from the stack
	*/
   public int pop()
   {
      if (isEmpty())
    	  throw new IllegalArgumentException("ArrayStack pop");
      int topItem = stackArray[topOfStack];
      stackArray[topOfStack] = 0;
      topOfStack--;
      return topItem;
   }
   
   /**
	* Pushes new item into stack
	*/
   public void push(int item)
   {
      if (isFull())
    	  throw new IllegalArgumentException("ArrayStack push");
      topOfStack++; 
      stackArray[topOfStack] = item;
   }
   
   /**
	* Returns the size of the stack
	*/
   public int size()
   {
      return topOfStack + 1;
   }
   
}