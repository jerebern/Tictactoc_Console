public class Grid {
    private char[][] sqarre;
    private int playTurn;
    public Grid(){
        //init grid with white space
        this.sqarre = new char [3][3]; 
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
             this.sqarre[i][j] = ' ';                 
            }
           
        }
    }

    public void Draw(){
        System.out.println("===================");   
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
            System.out.print(this.sqarre[i][j]);   
            System.out.print('|');                            
            }
            System.out.println(); //'/n'
           
        }
        
    }

    public boolean Place(String XY, char carToPlace){
        int X = XY.charAt(0) - '0';
        int Y = XY.charAt(1) - '0';
        if((X > 0 || X < 3) && (Y > 0 || Y < 3)){
            if(this.sqarre[X][Y] == ' ' ){
                this.sqarre[X][Y] = carToPlace;
                    playTurn ++;
                   return true;
               }
               else{
                   return false;
               }

        }

        return false;
    }

    public boolean CheckifWinner(char PlayerToCheck){
        //horizontale
        if(this.sqarre[0][0] == PlayerToCheck && this.sqarre[0][1] == PlayerToCheck && this.sqarre[0][2] == PlayerToCheck){
            System.out.println("Condition 1");
            return true;            
        }
        else if(this.sqarre[1][0] == PlayerToCheck && this.sqarre[1][1] == PlayerToCheck && this.sqarre[1][2] == PlayerToCheck){
            System.out.println("Condition 2");
    
            return true;
        }
        else if(this.sqarre[2][0] == PlayerToCheck && this.sqarre[2][1] == PlayerToCheck && this.sqarre[2][2] == PlayerToCheck){
            System.out.println("Condition 3");
    
            return true;
        }
/////////////VERTICAL
        else if(this.sqarre[0][0] == PlayerToCheck && this.sqarre[1][0] == PlayerToCheck && this.sqarre[2][0] == PlayerToCheck){
            System.out.println("Condition 4");
    
            return true;
        }
        else if(this.sqarre[1][0] == PlayerToCheck && this.sqarre[1][1] == PlayerToCheck && this.sqarre[1][2] == PlayerToCheck){
            System.out.println("Condition 5");
    
            return true;
        }
        else if(this.sqarre[2][0] == PlayerToCheck && this.sqarre[2][1] == PlayerToCheck && this.sqarre[2][2] == PlayerToCheck){
            System.out.println("Condition 6");
    
            return true;  
        }
     ///// HORRIZONTAl   
        else if(this.sqarre[0][0] == PlayerToCheck && this.sqarre[1][1] == PlayerToCheck && this.sqarre[2][2] == PlayerToCheck){
            System.out.println("Condition 7");
    
            return true;
        }
        else if(this.sqarre[2][0] == PlayerToCheck && this.sqarre[1][1] == PlayerToCheck && this.sqarre[0][2] == PlayerToCheck){
            System.out.println("Condition 8");

            return true;  
        }

        System.out.println("Condition False");

        return false ;
    }
}
