package tictactoc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TictactocTest {
    private Tictactoc tictactoc;

    @Test
    public void testInvalidePositionReturnFalse(){
        tictactoc = new Tictactoc();

        assertEquals(tictactoc.get_Grid().Place("33", 'X'),false);
        
    }
    @Test
    public void testAlereadyusePositionReturnFalse(){
        tictactoc = new Tictactoc();
        tictactoc.get_Grid().Place("00", 'O');
        assertEquals(tictactoc.get_Grid().Place("00",'X'),false);	
        
    }
    @Test
    public void testReturnFalseWhenNoWinner() {
        tictactoc = new Tictactoc();
        tictactoc.get_Grid().Place("00", 'X');
        tictactoc.get_Grid().Place("01", '0');
        tictactoc.get_Grid().Place("02", 'X');
        tictactoc.get_Grid().Place("10", 'X');
        tictactoc.get_Grid().Place("11", 'O');
        tictactoc.get_Grid().Place("12", 'O');   
        tictactoc.get_Grid().Place("20", 'O');
        tictactoc.get_Grid().Place("21", 'X');
        tictactoc.get_Grid().Place("22", 'X');
        assertEquals(tictactoc.get_Grid().CheckifWinner('O') ,false);        	
    }

    @Test
    public void testReturnTrueWhenHorizontalFirstRow() {
        tictactoc = new Tictactoc();
        tictactoc.get_Grid().Place("00", 'O');
        tictactoc.get_Grid().Place("01", 'O');
        tictactoc.get_Grid().Place("02", 'O');
        assertEquals(tictactoc.get_Grid().CheckifWinner('O'),true);         
        
    }
    
    @Test
    public void testReturnTrueWhenHorizontalSecondRow() {
        tictactoc = new Tictactoc();
        tictactoc.get_Grid().Place("10", 'O');
        tictactoc.get_Grid().Place("11", 'O');
        tictactoc.get_Grid().Place("12", 'O');
        assertEquals(tictactoc.get_Grid().CheckifWinner('O') ,true);         
        
    }
    @Test
    public void testReturnTrueWhenHorizontalThirdRow() {
        tictactoc = new Tictactoc();
        tictactoc.get_Grid().Place("20", 'O');
        tictactoc.get_Grid().Place("21", 'O');
        tictactoc.get_Grid().Place("22", 'O');
        assertEquals(tictactoc.get_Grid().CheckifWinner('O') ,true);         
        
    }
    @Test
    public void testReturnTrueWhenVerticalFirstRow() {
        tictactoc = new Tictactoc();
        tictactoc.get_Grid().Place("00", 'O');
        tictactoc.get_Grid().Place("10", 'O');
        tictactoc.get_Grid().Place("20", 'O');
        assertEquals(tictactoc.get_Grid().CheckifWinner('O') ,true);         
        
    }
    @Test
    public void testReturnTrueWhenVerticalSecondRow(){
        tictactoc = new Tictactoc();
        tictactoc.get_Grid().Place("01", 'O');
        tictactoc.get_Grid().Place("11", 'O');
        tictactoc.get_Grid().Place("21", 'O');
        assertEquals(tictactoc.get_Grid().CheckifWinner('O') ,true);         
        
    }
    @Test
    public void testReturnTrueWhenVerticalThirdRow() {
        tictactoc = new Tictactoc();
        tictactoc.get_Grid().Place("02", 'O');
        tictactoc.get_Grid().Place("12", 'O');
        tictactoc.get_Grid().Place("22", 'O');
        assertEquals(tictactoc.get_Grid().CheckifWinner('O') ,true);         
        
    }
    @Test
    public void testReturnTrueWhenDiagonalTopLeftToBottomRight(){
        tictactoc = new Tictactoc();
        tictactoc.get_Grid().Place("00", 'O');
        tictactoc.get_Grid().Place("11", 'O');
        tictactoc.get_Grid().Place("22", 'O');
        assertEquals(tictactoc.get_Grid().CheckifWinner('O') ,true);         
        
    }
    @Test
    public void testReturnTrueWhenDiagonalBottomLeftTopRight() {
        tictactoc = new Tictactoc();
        tictactoc.get_Grid().Place("20", 'O');
        tictactoc.get_Grid().Place("11", 'O');
        tictactoc.get_Grid().Place("02", 'O');
        assertEquals(tictactoc.get_Grid().CheckifWinner('O') ,true);         
    }  
    @Test
    public void testIfGameStartAtturn0() {
        tictactoc = new Tictactoc();
        assertEquals(tictactoc.get_turn(),0);  
    }
    

}
