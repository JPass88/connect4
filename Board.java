/**
 *  This class simulates a NibbleNabble game board.
 *  
 *  CST8110 - Introduction to Computer Programming
 * 
 *  Section:               451
 *  Semester:              20S
 *  Professor:             Jangam
 *  Student ID:            040552420
 *  Student Email:         pass0011@algonquinlive.com
 * 
 *  @author Jordan Passant
 *  @version 1.0
 *  @since 1.8
 *
 */

import java.util.Arrays;

public class Board {
	
    /** Number of rows on the board */
    private final static int NUM_ROWS = 6;
	
    /** Number of columns on the board */
    private final static int NUM_COLS = 7;
	
    /** Array of Column objects, which contain token values */
    Column[] board = new Column[NUM_COLS]; // was private
	
    /**
     *  Loop through the board array, to instantiate and initialize each element as a new Column.
     */
	
    public Board() {
		
        for(int i = 0; i < NUM_COLS; i++) {
			
            board[i] = new Column();  // Each element is a new Column
        }	
    } // End of Board method
	
    /**
     *  Validate the column number, output an error message and return false if its invalid.
     *  Try to put the token in the specified column of the board. Output an error message and return false if it does not work.
     * 
     *  @param column The column in which to place the token, valid values are 1 - 7.
     *  @param token Token character to place on the board, an X or an O.
     *  @return True if putting the token on the column is successful, else false.
     */
	
    public boolean makeMove(int col, char token) {
		
        if (col > 0 && col < 8) {
			
            if (board[col-1].getHeight() == 6)
				
                return false;
            else {
                board[col-1].put(token);
				
                return true;
            }
        }
        else
            return false;	
    }
	
    /**
     * Checks for a victory by looking for complete vertical and horizontal nibbles.
     * 
     * @param token Token character check for nibbles of
     * @return True if any nibbles are found on the board, otherwise false.
     */
	
    public boolean checkVictory(char token) {
		
        String tok = String.valueOf(token);
		
        // Loop through each column to check for victory.
		
        for (int c = 0; c < 7; c++) {
			
            if(board[c].checkVictory(token)) {
				
                display();
                return true;
            }
        }
		
        // Loop through each row to look for horizontal nibbles..
        // ..For each row, if a set of 4 values are the same -> Nibble
		
        int count = 0;
		
        for (int i = 0; i < 6; i++) {
			
            for (int j = 0; j < 3; j++) { // A Row
						
                String p1 = String.valueOf(board[j  ].get(i));
                String p2 = String.valueOf(board[j+1].get(i));
                String p3 = String.valueOf(board[j+2].get(i));
                String p4 = String.valueOf(board[j+3].get(i));
				
                if(p1.equals(p2) && p2.equals(p3) && p3.equals(p4) && p4.equals(tok)) {
				
                    display();
					
                    return true;
                } // End if
            } // End for(j)
        } // End for(i)
        
        // Hard-coded 1st line (last 4 column) detection
        
        String q1 = String.valueOf(board[3].get(0));
        String q2 = String.valueOf(board[4].get(0));
        String q3 = String.valueOf(board[5].get(0));
        String q4 = String.valueOf(board[6].get(0));
		
        if(q1.equals(q2) && q2.equals(q3) && q3.equals(q4) && q4.equals(tok)) {
        {	
            display();
			
            return true;
        	}
        }
        
        return false;
    } // End checkVictory method
	
    /**
     * Checks all columns to see if there is room for a token
     * @return True if there is a move left, else return false
     */
	
    public boolean boardFull() {
		
        for (int i = 0; i < 7; i++) {
			
            if(board[i].getHeight() == 6)
                continue;
            else
                return false;
        }
		
		return true;
	} // End of boardFull method
	 
	/**
	 *  Displays each column number, divided by spaces.
	 *  Displays, in a grid, the contained in each column of each row.
	 *  Displays the column numbers again at the bottom.
	 *  Example:
	 *
	 *  1 2 3 4 5 6 7 
	 *  ---------------
	 *  | | | | | | | |  6
	 *  | | | | | | | |  5
	 *  | | | | | | | |  4
	 *  | | | | | | | |  3
	 *  | |X| | | |O| |  2
	 *  |O|O|X| |X|O| |	 1
	 *  ---------------
	 *  1 2 3 4 5 6 7 
	 *
	 */
	
    public void display() {
		
        System.out.print("\n   1 2 3 4 5 6 7\n");
		
		//System.out.print(board[0].get(0)); // Prints the MF element of the column
	
        int count = 6;
		
        for (int j = 0; j < 6; ++j) {     // ROWS: 0-->5
					
			System.out.print("|*|");
			
		    for (int i = 0; i < 7; ++i) { // COLUMN: 0-->6 (one row)
			
		        System.out.print(board[i].get(count-1));
				
		        if (i == 6)
		            System.out.print("|*|");
		        else
		            System.out.print("|");
            }
            System.out.print(" " + (count) + "\n");	
            count--;
        }	
		
        System.out.print("   1 2 3 4 5 6 7\n\n");
    } // End of display method
	
} // End of Board class
