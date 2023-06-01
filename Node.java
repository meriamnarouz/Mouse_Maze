/*
// Description: This file keeps track of the location of the nodes and returns location if called. 
*/

public class Node 
{
	//instance variable
	private int x;
	private int y;
	
	//constructor
	public Node(int x, int y)
	{
		this.x = x; //x equals x
		this.y = y; //y equals y
	}//end of constructor
	
	//method to return x coordinate of node
	public int getX()
	{
		return x;
	}//end of getX
	
	//method to return y coordinate of node
	public int getY()
	{
		return y;
	}//end of getY
	
}//end of class
