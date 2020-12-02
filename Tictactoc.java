 
import java.util.*;

import javax.swing.text.StyledEditorKit.BoldAction; 
 public class Tictactoc {
    private Grid grid;
    private Player[] players;
    private GameState gameState;
    private enum GameState{
        PLAYER1_TURN,
        PLAYER2_TURN
    }
    public Tictactoc(){    
        this.players = new Player [2];
        this.players[0] = new Player('X');
        this.players[1] = new Player('O');
        this.grid = new Grid();
    };
    public Grid get_Grid(){
        return this.grid;
    }

    //To do 
    public void Config_Game(){
        String choice;
        System.out.print("Enter number of player : \n");
        System.out.println("Enter numnber of round :");
     //   Scanner sc = new Scanner(System.in);  

        players[0] = new Computer('X');
        players[1] = new Computer('O');
 
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
        int turn = 0;
        Tictactoc tictactoc = new Tictactoc();
            tictactoc.Config_Game();
           // tictactoc.Play_all_round();
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
                    turn++;
                    System.out.println(turn);
                    tictactoc.get_Grid().Draw();
                } while(!tictactoc.get_Grid().CheckifWinner(tictactoc.get_Player(turnToCheck).Get_Piece()) && turn < 9);

                if(turn == 9){

                    System.out.println("Tie");
                }
                else{
                   System.out.println("Player : " + tictactoc.get_Player(turnToCheck).Get_Piece() + " Win");
                }
  

        

    }

}