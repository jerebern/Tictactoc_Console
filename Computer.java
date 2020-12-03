package tictactoc;
import java.util.Random; 
public class Computer extends Player {

    public Computer(char piece){
        super(piece);
        System.out.print("Player 2 is a Computer \n ");
    }

    public String Play(){
        System.out.println("Computer " + this.Piece + " time to play!");
        String str;
        Random rand = new Random(); 
        int PosX  = rand.nextInt(3);
        int PosY = rand.nextInt(3);

        str = String.valueOf(PosX) + String.valueOf(PosY);
        return str;
        
    }



}