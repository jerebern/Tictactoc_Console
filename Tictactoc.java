 
import java.util.*;

import javax.swing.text.StyledEditorKit.BoldAction; 
 public class Tictactoc {
    private int Round;
    private Grid grid;
    private Player[] players;
    private GameState gameState;
    private enum GameState{
        WAITING,
        INGAME,
        FINISHED,
        PLAYER1_TURN,
        PLAYER2_TURN
    }
    public Tictactoc(){    
        this.gameState = GameState.WAITING; 
        this.players = new Player [2];
        this.players[0] = new Player('X');
        this.players[1] = new Player('O');
        this.grid = new Grid();
        this.Round = 0;
    };
    public Grid get_Grid(){
        return this.grid;
    }

    public void Play_all_round(){
        for(int nbround = 0; nbround < Round; nbround++){
            this.gameState = GameState.INGAME;
            this.grid = new Grid();
            Play();
        }

    }


   public void Play(){
        int turn = 0;
            this.gameState = GameState.PLAYER1_TURN;

        do{

            switch(gameState){

                case PLAYER1_TURN:
                this.grid.Place(this.players[0].Play() , this.players[0].Get_Piece()); 
                turn = 0;            
                gameState = GameState.PLAYER2_TURN;
                break;

                case PLAYER2_TURN:
                this.grid.Place(this.players[1].Play() , this.players[1].Get_Piece());
                turn = 1;
                gameState = GameState.PLAYER1_TURN;                
                break;
                
            }

            this.grid.Draw();
                ///Oublier les while 
        } while(!this.grid.CheckifWinner(this.players[turn].Get_Piece()));

        System.out.println("Game is finish");
        


    }

    //To do 
    public void Config_Game(){
        String choice;
        System.out.print("Enter number of player : \n");
        System.out.println("Enter numnber of round :");
        Round = 3;
     //   Scanner sc = new Scanner(System.in);  

        players[0] = new Computer('X');
        players[1] = new Computer('O');
 

    }

   public Boolean Ask_play_again(){
       this.gameState = GameState.FINISHED;
        System.out.print("Do you want to play again y/n ");
        char choice = 'Y';

        if(choice == 'Y')
            return true;
        else if(choice =='N')
            return false;    
        return false; //va pas compiler sinon :(
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
        Boolean finish = false;
        int turn = 0;
        Tictactoc tictactoc = new Tictactoc();
        while(!finish){
            tictactoc.Config_Game();
           // tictactoc.Play_all_round();
            tictactoc.set_GameState(GameState.PLAYER1_TURN);

                do{
        
                    switch(tictactoc.get_GameState()){
        
                        case PLAYER1_TURN:
                        tictactoc.get_Grid().Place(tictactoc.get_Player(0).Play() , tictactoc.get_Player(0).Get_Piece());             
                        tictactoc.set_GameState(GameState.PLAYER2_TURN);
                        turn = 1;
                        break;
        
                        case PLAYER2_TURN:
                        tictactoc.get_Grid().Place(tictactoc.get_Player(1).Play() , tictactoc.get_Player(1).Get_Piece());
                        tictactoc.set_GameState(GameState.PLAYER1_TURN); 
                        turn = 0 ;               
                        break;
                        
                    }
        
                    tictactoc.get_Grid().Draw();
                        ///Oublier les while 
                } while(!tictactoc.get_Grid().CheckifWinner(tictactoc.get_Player(turn).Get_Piece()));


            finish = tictactoc.Ask_play_again();

        }

    }

}