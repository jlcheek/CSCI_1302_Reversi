package cs1302.p2;

public class IntelligentComputerPlayer extends ComputerPlayer{
    
    /**
     * This method returns the best place that awards the most
     * flipped pieces.
     * 
     * @param userGuessArray the 2D array that makes up the game board
     * @param isDark boolean that determines which players turn it is
     * 
     * @return int[] an int array that contains 2 integers of the computers guess
     */
    public int[] guess(String[][] userGuessArray, boolean isDark){

	int[] guess = new int[2];
	int[][] bestMove = new int[8][8];
	int iCount = 0;
	
	for(int x = 0; x < 8; x++){
	    for(int y = 0; y < 8; y++){
		bestMove[x][y] = 0;
	    }//for y

	}//for x

	String player;
	String opponent;

	if(isDark){
	    player = "X";
	    opponent = "O";
	}//if
	else{
	    player = "O";
	    opponent = "X";
	}//else
	
	boolean[] isTrue = new boolean[8];
	for(int x = 0; x < 8; x++){
	    isTrue[x] = true;
	}//for
	
	for(int row = 0; row < 8; row++){
	    for(int col = 0; col < 8; col++){
		if(userGuessArray[row][col].equals("_")){
		int count = 0;
		boolean isRunning = true;
		while(isRunning){
		    //right
		    if((col + 1) < 7){
			if(userGuessArray[row][col + 1] == opponent && isTrue[0]){
			    int n = 1;
			    while((col + n) < 7){
				n++;
				if(userGuessArray[row][col + n] == "."){
				    isTrue[0] = false;
				    break;
				}//if
				else if(userGuessArray[row][col + n] == player){
				    break;
				}//else if
				
			    }//while
			    n = 1;
			    while((col + n) < 7 && userGuessArray[row][col + n] == opponent && isTrue[0]){
				iCount++;
				n++;
			    }//while
			    
			    isTrue[0] = false;
			    
			}//if
			else{
			    isTrue[0] = false;
			}//else
		    }//if
		    else{
			isTrue[0] = false;
		    }//else
		    
		    //left
		    if((col - 1) > 0){
			if(userGuessArray[row][col - 1] == opponent && isTrue[1]){
			    int n = 1;
			    while((col - n) > 0){
				n++;
				if(userGuessArray[row][col - n] == "."){
				    isTrue[1] = false;
				    break;
				}//if
				else if(userGuessArray[row][col - n] == player){
				    break;
				}//else if
				
			    }//while
			    n = 1;
			    while((col- n) > 0 && userGuessArray[row][col - n] == opponent && isTrue[1]){
				iCount++;
				n++;
			    }//while
			    
			    isTrue[1] = false;
			    
			}//if
			else{
			    isTrue[1] = false;
			}//else
		    }//if
		    else{
			isTrue[1] = false;
		    }//else
		    
		    //up
		    if((row - 1) > 0){
			if(userGuessArray[row - 1][col] == opponent && isTrue[2]){
			    int n = 1;
			    while((row - n) > 0){
				n++;
				if(userGuessArray[row - n][col] == "."){
				    isTrue[2] = false;
				    break;
				}//if
				else if(userGuessArray[row - n][col] == player){
				    break;
				}//else if
				
			    }//while
			    n = 1;
			    while((row - n) > 0 && userGuessArray[row - n][col] == opponent && isTrue[2]){
				iCount++;
				n++;
			    }//while
			    
			    isTrue[2] = false;
			    
			}//if
			else{
			    isTrue[2] = false;
			}//else
		    }//if
		    else{
			isTrue[2] = false;
		    }//else
		    
		    //down
		    if((row + 1) < 7){
			if(userGuessArray[row + 1][col] == opponent && isTrue[3]){
			    int n = 1;
			    while((row + n) < 7){
				n++;
				if(userGuessArray[row + n][col] == "."){
				    isTrue[3] = false;
				    break;
				}//if
				else if(userGuessArray[row + n][col] == player){
				    break;
				}//else if
				
			    }//while
			    n = 1;
			    while((row + n) < 7 &&  userGuessArray[row + n][col] == opponent && isTrue[3]){
				iCount++;
				n++;
			    }//while
			    
			    isTrue[3] = false;
			    
			}//if
			else{
			    isTrue[3] = false;
			}//else
		    }//if
		    else{
			isTrue[3] = false;
		    }//else
		    
		    //upRight
		    if((col + 1) < 7 && (row - 1) > 0){
			if(userGuessArray[row - 1][col + 1] == opponent && isTrue[4]){
			    int n = 1;
			    while((col + n) < 7 && (row - n) > 0){
				n++;
				if(userGuessArray[row - n][col + n] == "."){
				    isTrue[4] = false;
				    break;
				}//if
				else if(userGuessArray[row - n][col + n] == player){
				    break;
				}//else if
				
			    }//while
			    n = 1;
			    while((col + n) < 7 && userGuessArray[row - n][col + n] == opponent && isTrue[4]){
				iCount++;
				n++;
			    }//while
			    
			    isTrue[4] = false;
			    
			}//if
			else{
			    isTrue[4] = false;
			}//else
		    }//if
		    else{
			isTrue[4] = false;
		    }//else
		    
		    //upLeft
		    if((col - 1) > 0 && (row - 1) > 0){
			if(userGuessArray[row - 1][col - 1] == opponent && isTrue[5]){
			    int n = 1;
			    while((col - n) > 0 && (row - n) > 0){
				n++;
				if(userGuessArray[row - n][col - n] == "."){
				    isTrue[5] = false;
				    break;
				}//if
				else if(userGuessArray[row - n][col - n] == player){
				    break;
				}//else if
				
			    }//while
			    n = 1;
			    while((col - n) > 0 && (row - n) > 0 && userGuessArray[row - n][col - n] == opponent && isTrue[5]){
				iCount++;
				n++;
			    }//while
			    
			    isTrue[5] = false;
			    
			}//if
			else{
			    isTrue[5] = false;
			}//else
		    }//if
		    else{
			isTrue[5] = false;
		    }//else
		    
		    //downLeft
		    if((col - 1) > 0 && (row + 1) < 7){
			if(userGuessArray[row + 1][col - 1] == opponent && isTrue[6]){
			    int n = 1;
			    while((col - n) > 0 && (row + n) < 7){
				n++;
				if(userGuessArray[row + n][col - n] == "."){
				    isTrue[6] = false;
				    break;
				}//if
				else if(userGuessArray[row + n][col - n] == player){
				    break;
				}//else if
				
			    }//while
			    n = 1;
			    while((col - n) > 0 && (row + n) < 8 && userGuessArray[row + n][col - n] == opponent && isTrue[6]){
				iCount++;
				n++;
			    }//while
			    
			    isTrue[6] = false;
			    
			}//if
			else{
			    isTrue[6] = false;
			}//else
		    }//if
		    else{
			isTrue[6] = false;
		    }//else
		    
		    //downRight
		    if((col + 1) < 7 && (row + 1) < 7){
			if(userGuessArray[row + 1][col + 1] == opponent && isTrue[7]){
			    int n = 1;
			    while((col + n) < 7 && (row + n) < 7){
				n++;
				if(userGuessArray[row + n][col + n] == "."){
				    isTrue[7] = false;
				    break;
				}//if
				else if(userGuessArray[row + n][col + n] == player){
				    break;
				}//else if
				
			    }//while
			    n = 1;
			    while((col + n) < 7 && (row + n) < 7 && userGuessArray[row + n][col + n] == opponent && isTrue[7]){
				iCount++;
				n++;
			    }//while
			    
			    isTrue[7] = false;
			    
			}//if
			else{
			    isTrue[7] = false;
			}//else
		    }//if
		    else{
			isTrue[7] = false;
		    }//else
		    
		    if(isTrue[0] == false && isTrue[1] == false && isTrue[2] == false && isTrue[3] == false && isTrue[4] == false && isTrue[5] == false && isTrue[6] == false && isTrue[7] == false){
			bestMove[row][col] = iCount;
			iCount = 0;
			isRunning = false;
		    }
		    
		    count++;
		    if(count == 1000){
			for(int x = 0; x < 8; x++){
			    isTrue[x] = false;
			    //System.out.println("isTrue[" + x + "] = " + isTrue[x]);
			}//for
			
		    }//if
		    
		}//while

		    }//if

	    }//for col

	}//for row

	int highestCount = 0;
	int iRow = 0;
	int iCol = 0;
	
	for(int x = 0; x < 8; x++){
	    for(int y = 0; y < 8; y++){
		if(bestMove[x][y] != 0){
		    if(bestMove[x][y] > highestCount){
			highestCount = bestMove[x][y];
			iRow = x;
			iCol = y;
		    }//if
		    
		}//if
		
	    }//for y
	    
	}//for x
	guess[0] = iRow;
	guess[1] = iCol;
	
	return guess;


    }//guess

}//IntelligentComputerPlayer