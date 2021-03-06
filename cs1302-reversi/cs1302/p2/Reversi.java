package cs1302.p2;

public class Reversi{
    
    private static final String HUMAN = "Human";
    private static final String COMPUTER_PLAYER = "ComputerPlayer";
    private static final String RANDOM_COMPUTER_PLAYER = "RandomComputerPlayer";
    private static final String INTELLIGENT_COMPUTER_PLAYER = "IntelligentComputerPlayer";
    public static Player darkPlayer;
    public static Player lightPlayer;
    private static int playerXSetting;
    private static boolean isXIntelligent = false;
    private static boolean isOIntelligent = false;

    /** 
     * This is the constructor of Reversi in which it finalizes
     * the last few steps taken to creat the Reversi game based
     * on specific guidlines from the user.
     *
     * @param option1 A string that dictates player 1
     * @param option2 A string that dictates player 2
     *
     */
    public Reversi(String option1, String option2){
	
	if(option1.equalsIgnoreCase(HUMAN)){
	    darkPlayer = new HumanPlayer();
	    darkPlayer.setPlayer("X");
	}//else if
	else if(option1.equalsIgnoreCase(COMPUTER_PLAYER)){
	    darkPlayer = new ComputerPlayer();
	    darkPlayer.setPlayer("X");
	}//else if
	else if(option1.equalsIgnoreCase(RANDOM_COMPUTER_PLAYER)){
	    darkPlayer = new RandomComputerPlayer();
	    darkPlayer.setPlayer("X");
	}//else if
	else if(option1.equalsIgnoreCase(INTELLIGENT_COMPUTER_PLAYER)){
	    darkPlayer = new IntelligentComputerPlayer();
	    darkPlayer.setPlayer("X");
	    isXIntelligent = true;
	}//else
	else{
	    
	}//else

	if(option2.equalsIgnoreCase(HUMAN)){
	    lightPlayer = new HumanPlayer();
	    lightPlayer.setPlayer("O");
	}//if
	else if(option2.equalsIgnoreCase(COMPUTER_PLAYER)){
	    lightPlayer = new ComputerPlayer();
	    lightPlayer.setPlayer("O");
	}//else if
	else if(option2.equalsIgnoreCase(RANDOM_COMPUTER_PLAYER)){
	    lightPlayer = new RandomComputerPlayer();
	    lightPlayer.setPlayer("O");
	}//else if
	else if(option2.equalsIgnoreCase(INTELLIGENT_COMPUTER_PLAYER)){
	    lightPlayer = new IntelligentComputerPlayer();
	    lightPlayer.setPlayer("O");
	    isOIntelligent = true;
	}//else if
	else{
	    
	}//else
	
	System.out.println();
	System.out.println("Welcome to Reversi! Moves should be entered in \"[row] [col]\" format");
	System.out.println();
	
	run();

    }//Constructor

    /**
     * This is the main method where the game is setup based on
     * the users specification when running the program
     * 
     *
     * @param args
     */
    public static void main(String[] args){

	Reversi game = null;

	if(args.length == 2) {
	    
	    String option1;
	    String option2;

	    // try to parse the arguments and create a game
	    try {
		
		option1 = args[0];
		option2 = args[1];
		game = new Reversi(option1, option2);
		
	    } catch (NumberFormatException nfe) { 
		// line intentionally left blank
	    } // try
	}//if
	else if(args.length == 0){
	    
	    System.out.println();
	    System.out.println("Usage: java Reversi [WHO] [WHO]");
	    System.out.println("WHO: Human, ComputerPlayer, RandomComputerPlayer, or IntelligentComputerPlayer");
	    System.out.println();
	    System.exit(0);

	}//else if
	else{
	    //Error message
	}//else

    }//Main

    /**
     * This method is what runs the game and iterates through all the
     * scenarios until the board has filled up and no more moves are
     * made
     *
     */
    public void run(){
	Board board = new ReversiBoard();
	String[][] userGuessArray = new String[8][8];
	boolean running = true;
	boolean playerXTurn = true;
	int row;
	int col;
	
	for(int x = 0; x < 8; x++){
	    for(int y = 0; y < 8; y++){
		userGuessArray[x][y] = ".";
		
	    }//for y

	}//for x

	userGuessArray[3][3] = "X";
	userGuessArray[3][4] = "O";
	userGuessArray[4][3] = "O";
	userGuessArray[4][4] = "X";
	
	userGuessArray = board.findAvailableSlots(userGuessArray, true);
	board.printGrid(userGuessArray);
	
	while(running){
	    int[] guess;
	    if(playerXTurn){
		System.out.println();
		System.out.print("Enter your move, X player: ");
	       	guess = darkPlayer.guess(userGuessArray);
		userGuessArray[guess[0]][guess[1]] = "X";
		board.clearGrid(userGuessArray);
		userGuessArray = board.swapPieces(userGuessArray, guess[0], guess[1], true);
		userGuessArray = board.findAvailableSlots(userGuessArray, false);
		playerXTurn = false;
	    }//if
	    else{
		System.out.println();
		System.out.print("Enter your move, O player: ");
		guess = lightPlayer.guess(userGuessArray);
		userGuessArray[guess[0]][guess[1]] = "O";
		board.clearGrid(userGuessArray);
		userGuessArray = board.swapPieces(userGuessArray, guess[0], guess[1], false);
		userGuessArray = board.findAvailableSlots(userGuessArray, true);
		playerXTurn = true;
	    }//else
	    
	    board.printGrid(userGuessArray);
	    
	    int xCount = 0;
	    int oCount = 0;
	    int spaceCount = 0;
	    for(int x = 0; x < 8; x++){
		for(int y = 0; y < 8; y++){
		    if(userGuessArray[x][y] == "_"){
			spaceCount++;
		    }//if
		    if(userGuessArray[x][y] == "X"){
			xCount++;
		    }//if
		    if(userGuessArray[x][y] == "O"){
			oCount++;
		    }//if
		}//for y

	    }//for x
	    if(spaceCount == 0){
		if(xCount > oCount){
		    System.out.println();
		    System.out.println("Congratulations! Player X wins!");
		    System.out.println("Goodbye!");
		}//if
		if(oCount > xCount){
		    System.out.println();
		    System.out.println("Congratulations! Player O wins!");
		    System.out.println("Goodbye!");
		}//if
		if(oCount == xCount){
		    System.out.println();
		    System.out.println("It's a tie!");
		    System.out.println("Please play again!");
		    System.out.println("Otherwise, goodbye!");
		}//if
		System.exit(0);
	    }//if
	    
	}//while

    }//run
    
}//Reversi