/*
// Description: This file uses a stack of type node, a char[][] maze, and integers cheeseFound,
//				mHeight, and mWidth. It also calls the node class to know which char is next
//				to it in any direction in order to decide where to go. It goes through the 
//				whole maze looking for cheese but it cannot cross the walls. It then
//				prints the final maze when called. 
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class MazeSolver 
{
	//instance variables
	private Stack<Node> stack; //the stack
	private char[][] maze; //the maze
	private int cheeseFound; //cheese found in maze
	private int mHeight; //height of maze
	private int mWidth; //width of maze
	
	//constructor
	public MazeSolver()
	{
		//initialize variables
		stack = new Stack<Node>();
		maze = null;
		cheeseFound = 0;
		mHeight = 0;
		mWidth = 0;
	}//end of constructor
	
	//method to search maze for cheese
	public void depthFirstSearch()
	{
		Node current = new Node(0, 0); //get first coordinate
		stack.push(current); //push it to the top
		
		//if statement to make sure first coordinate is visited
		if(maze[current.getX()][current.getY()] == 'B')
		{
			//if visited, change it to x to indicate visitation
			maze[current.getX()][current.getY()] = 'x';
		}//end of if statement
		
		//while loop to run while stack is not empty
		while(!stack.isEmpty())
		{		
			current = stack.pop(); //pop it and get value 
			
			//save the char of specific location in maze as variable 'character'
			char character = maze[current.getX()][current.getY()]; 
			
			//check if there is an cheese
			if(character == 'C') //if character is an cheese
			{
				cheeseFound++; //up the count of found cheese
				maze[current.getX()][current.getY()] = 'x'; //save it as visited
			}
			else if(character == '.') //if character is an unexplored path
			{
				maze[current.getX()][current.getY()] = 'x'; //save it as visited
			}//end of if else statement
			
			//check west 
			//check if the cell to the left is in bounds
			boolean left = ((current.getX() - 1) < mHeight) && ((current.getX() - 1) >= 0);
			
			if(left) //if left is in bounds
			{
				//get char in cell on the left
				char west = maze[current.getX() - 1][current.getY()]; 
				
				if((west != 'x') && (west != '#')) //if west is not visited and not a wall
				{
					//create new node with coordinates of west
					Node new1 = new Node((current.getX() - 1), (current.getY()));
					stack.push(new1); //push it to the top
				}//end of inner if statement
				
			}//end of outer if statement checking west
			
			//check east
			//check if the cell to the right is in bounds
			boolean right = ((current.getX() + 1) < mHeight) && ((current.getX() + 1) >= 0);
			
			if(right) //if right is in bounds
			{
				//get char in cell on the right
				char east = maze[current.getX() + 1][current.getY()];
				
				if((east != 'x') && (east != '#')) //if east is not visited and not a wall
				{
					//create new node with coordinates of east
					Node new2 = new Node((current.getX() + 1), (current.getY()));
					stack.push(new2); //push it to the top
				}//end of inner if statement
				
			}//end of outer if statement checking east
			
			//check north
			//check if the cell above is in bounds
			boolean above = ((current.getY() + 1) < mWidth) && ((current.getY() + 1) >= 0);
			
			if(above) //if above is in bounds
			{
				//get char in cell above
				char north = maze[current.getX()][current.getY() + 1];
				
				if((north != 'x') && (north != '#')) //if north is not visited and not a wall
				{
					//create new node with coordinates of north
					Node new3 = new Node((current.getX()), (current.getY() + 1));
					stack.push(new3); //push it to the top
				}//end of inner if statement
				
			}//end of outer if statement checking north	
			
			//check south
			//check if the cell below is in bounds
			boolean below = ((current.getY() - 1) < mWidth) && ((current.getY() - 1) >= 0);
			
			if(below) //if below is in bounds
			{
				//get char in cell below
				char south = maze[current.getX()][current.getY() - 1];
				
				if((south != 'x') && (south != '#')) //if south is not visited and not a wall
				{
					//create new node with coordinates of south
					Node new4 = new Node((current.getX()), (current.getY() - 1));
					stack.push(new4); //push it to the top
				}//end of inner if statement
				
			}//end of outer if statement checking south		
			
		}//end of while loop
		
	}//end of depthFirstSearch
	
	
	//getCheeseFound returns the number of found cheese in maze
	public int getCheeseFound()
	{
		return cheeseFound;
	}//end of getCheeseFound
	
	//printMaze outputs the maze after traversing
	public void printMaze()
	{
		//for loop to print maze
		for(int i = 0; i < mHeight; i++) //outer loop checking height
		{			
			for(int j = 0; j < mWidth; j++) //inner loop checking width
			{
				//print maze
				System.out.print(maze[i][j]);
			}//end of inner for loop
			
			System.out.println(); //print empty line			
		}//end of outer for loop
		
		System.out.println(); //print empty line
	}//end of printMaze

	//reads the maze from user
	public void readMaze() 
	{

		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			
			//get the height of the maze
			System.out.println("Height of the maze: ");
			String line = reader.readLine();
			mHeight = Integer.parseInt(line);

			//get the width and set up the maze
			System.out.println("Width of the maze: ");
			line = reader.readLine();
			mWidth = Integer.parseInt(line);
			maze = new char[mHeight][mWidth];
			
			//read in the actual maze
			System.out.println("Enter the maze: ");
			for (int i = 0; i < mHeight; i++) {
				line = reader.readLine();
				for (int j = 0; j < mWidth; j++) {
					maze[i][j] = line.charAt(j);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}//end of readMaze
	
}//end of class
