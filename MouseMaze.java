/*
// Description: This file takes in user input such as the width and height of the maze
//				and the maze itself. It calls methods from other classes. It is also   
//				responsible for outputting the maze before and after it is traversed 
//				well as if any pieces of cheese were found and how many. 
*/


public class MouseMaze {

	public static void main(String[] args) {
		MazeSolver mazeSolver = new MazeSolver();
		mazeSolver.readMaze();

		System.out.println("Original maze: ");
		mazeSolver.printMaze();

		mazeSolver.depthFirstSearch();

		System.out.println("Maze after the mouse traversed it: ");
		mazeSolver.printMaze();

		if (mazeSolver.getCheeseFound() == 0)
			System.out.println("The mouse is hungry because it found no cheese!");
		else
			System.out.println("The mouse found " + mazeSolver.getCheeseFound() + " piece(s) of cheese!");
	}
}