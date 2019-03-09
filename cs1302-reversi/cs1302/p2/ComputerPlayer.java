package cs1302.p2;

import java.util.Random;

public class ComputerPlayer extends Player{

    /**
     * This method is the computers guess that is not as randomized 
     * as the RandomComputerPlayer to make the strategy a little
     * harder.
     *
     * @param userGuessArray the 2D array of the game board
     *
     * @return returns an int array of size 2 containing the coordinates
     * to the computers next play
     *
     */
    public int[] guess(String[][] userGuessArray){
	int[] n = new int[2];
	//int[] 
	int count = 0;
	Random r = new Random();
	for(int x = 0; x < 8; x++){
	    for( int y = 0; y < 8; y++){
		if(userGuessArray[x][y].equals("_")){
		    count++;
		}//if

	    }//for y

	}//for x
	int randomR = 0;
	try{
	    randomR = r.nextInt(count);
	}
	catch(Exception e){
	    //left open
	}
	count = 0;

	for(int x = 0; x < 8; x++){
	    for(int y = 0; y < 8; y++){
		if(userGuessArray[x][y] == "_"){
		    if(count == randomR){
			n[0] = x;
			n[1] = y;
		    }//if
		    else{
			count++;
		    }//else
		    
		}//if

	    }//for y
	    
	}//for x

	System.out.print((n[0] + 1) + " " + (n[1] + 1));
	System.out.println();

	boolean running = true;
	long lastTime = System.nanoTime();
	final double amountOfTicks = 60D;
	double ns = 1000000000 / amountOfTicks;
	double delta = 0;

	while(running){
	    long now = System.nanoTime();
	    delta += (now - lastTime) / ns;
	    lastTime = now;
		if(delta >= 1){
		    if(delta > 100){
			break;
		    }//if

		}//if

	}//while

	return n;

    }//guess

}//ComputerPlayer