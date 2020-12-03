

import java.util.*; 
public class Player {
   protected char Piece;  
    public Player(){}
    public Player(char Piece){
        this.Piece = Piece;
     }
   public String Play(){
       Scanner sc = new Scanner(System.in);
        System.out.println("Player " + this.Piece + " time to play!");
            return sc.nextLine();
   }

   public void Win(){
    System.out.println("Player " + this.Piece + " Win");

   }

   public void Loose(){
    System.out.println("Player " + this.Piece + " loose");
   }

   public char Get_Piece(){
       return Piece;
   }

}
