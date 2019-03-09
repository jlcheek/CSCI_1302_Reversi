package cs1302.p2;
import java.util.Scanner;

public class HumanPlayer extends Player{
    
    /**
     * this is the method where the human player uses scanner to input
     * the players game piece onto the board
     * 
     * @param userGuessArray is the 2D array of the game board
     *
     * @return returns and int array of size 2 for the row and col
     *
     */    
    public int[] guess(String[][] userGuessArray){
	int[] n = new int[2];
	Scanner r = new Scanner(System.in);
	boolean running = true;

	while(running){
	    if(r.hasNextInt()){
		int row = r.nextInt() - 1;
		int col = r.nextInt() - 1;
		if(!(userGuessArray[row][col] == "_")){
		    System.out.println();
		    System.out.println("That is not a valid move, try again.");
		    System.out.println();
		    System.out.print("Enter your move, " + getPlayer() + " player: ");
		}//if
		else{
		    n[0] = row;
		    n[1] = col;
		    running = false;
		}//else
	    }//if
	    else{
		String keyboard = r.nextLine();
		if(keyboard.equalsIgnoreCase("quit") || keyboard.equalsIgnoreCase("q")){
		    System.out.println();
		    System.out.println("Goodbye!");
		    System.out.println();
		    System.exit(0);
		}//if
		else if(keyboard.equalsIgnoreCase("help") || keyboard.equalsIgnoreCase("h")){
		    System.out.println();
		    System.out.println("Quit  =  [\"quit\"]/[\"q\"]");
		    System.out.println("Help  =  [\"help\"]/[\"h\"]");
		    System.out.println();
		    System.out.println("USAGE: [row][col]");
		    System.out.println();
		    System.out.print("Enter your move, " + getPlayer() + " player: ");
		}//else if
		else{
		    System.out.println();
		    System.out.println("Cannot recognize your commacd. Use \"help\"/\"h\" for a list of commands."); 
		}//else
		
	    }//else

	}//while

	return n;

    }//guess

}//HumanPlayer