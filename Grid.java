public class Grid {
    private char[][] sqarre;
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
        if(this.sqarre[X][Y] == ' ' ){
         this.sqarre[X][Y] = carToPlace;
            return true;
        }
        else{
            return false;
        }
    }

    public boolean CheckifWinner(char PlayerToCheck){
        int Found = 0;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
             if(this.sqarre[i][j] == PlayerToCheck){
                Found++;
                if(Found == 2 ) return true;
             }
             Found = 0;       // No winner found     
            }
           
        }    
        //imaginer du code de verification ici
        return false;
    }
}
