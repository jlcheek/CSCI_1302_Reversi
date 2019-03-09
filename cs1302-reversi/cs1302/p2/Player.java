package cs1302.p2;

public abstract class Player{
    
    public String getPlayer(){
	return player;
    }//getPlayer

    public void setPlayer(String p){
	player = p;
    }//setPlayer

    public String player;
    public abstract int[] guess(String[][] userGuessArray);

}//Player