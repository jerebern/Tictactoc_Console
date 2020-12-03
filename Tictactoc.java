

import java.util.*;

 public class Tictactoc {
    private Grid grid;
    private Player[] players;
    private GameState gameState;
    private int turn;
    private enum GameState{
        PLAYER1_TURN,
        PLAYER2_TURN
    }
    public Tictactoc(){    
        this.players = new Player [2];
        players[0] = new Computer('X');
        players[1] = new Computer('O');
        this.players[0] = new Computer('X');
        this.players[1] = new Computer('O');
        this.grid = new Grid();
        this.turn = 0 ; 
    };
    public Grid get_Grid(){
        return this.grid;
    }
    public void inc_turn() {
    	turn++;
    }
    public int get_turn() {
    	return turn;
    }
    public Boolean check_tie() {
    	if(this.turn < 9) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }


    public Player get_Player(int number) {
         return this.players[number];
        
    }

    public GameState get_GameState(){
        return this.gameState; 
    }
    public void set_GameState(GameState gamestate){
        this.gameState = gamestate;
    }


     public static void main(String[] args) {
        int turnToCheck = 0;
        Tictactoc tictactoc = new Tictactoc();
            tictactoc.set_GameState(GameState.PLAYER1_TURN);

                do{
                    switch(tictactoc.get_GameState()){
        
                        case PLAYER1_TURN:
                        while(!tictactoc.get_Grid().Place(tictactoc.get_Player(0).Play() , tictactoc.get_Player(0).Get_Piece()));             
                        tictactoc.set_GameState(GameState.PLAYER2_TURN);
                        turnToCheck = 0;
                        break;
        
                        case PLAYER2_TURN:
                        while(!tictactoc.get_Grid().Place(tictactoc.get_Player(1).Play() , tictactoc.get_Player(1).Get_Piece()));
                        tictactoc.set_GameState(GameState.PLAYER1_TURN); 
                        turnToCheck = 1 ;               
                        break;
                    }
                    tictactoc.inc_turn();
                    //System.out.println(turn);
                    tictactoc.get_Grid().Draw();
                } while(!tictactoc.get_Grid().CheckifWinner(tictactoc.get_Player(turnToCheck).Get_Piece()) && tictactoc.check_tie());

                if(!tictactoc.check_tie()) {
                    System.out.println("Tie");
                }
                else{
                   System.out.println("Player : " + tictactoc.get_Player(turnToCheck).Get_Piece() + " Win");
                }

    }

}