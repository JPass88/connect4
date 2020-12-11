/**
 *  This class is a single Column on the board, containing vertically stacked X and O tokens.
 * 
 *  CST8110 - Introduction to Computer Programming
 * 
 *  Section:               451
 *  Semester:              20S
 *  Professor:             Jangam
 *  Student ID:            040552420
 *  Student Email:         pass0011@algonquinlive.com
 * 
 *  @author  Jordan Passant
 *  @version 1.0
 *  @since   1.8
 *
 */

import java.util.Arrays;

public class Column {

    private static final int MAX_HEIGHT = 6;
    private static int height = 0;
    private char[] column; 
	
    /**
     *  Default constructor - initialize the column array and each element of the column array to contain a blank space.
     */
	
    public Column() {
		
        column = new char[MAX_HEIGHT];		
        Arrays.fill(column, ' ');
    }
	
    /**
     *  Return the value in the specified row.
     * 
     *  @param row The specified row. Valid values are 1 - 6. 
     *  @return The character in the specified row, or blank if an invalid row was requested.
     */
	
    public char get(int row) {
		
        return column[row];
	}
	
    /**  
     *  Put the specified token character at the top of the column, increments the height, and returns true.
     * 
     *  @param token Token character to place on the board, an X or an O.
     *  @return True if there is room in the column for the token, else false.
     */
	
    public boolean put(char token) {
		
        int nextRow = getHeight(); 
        column[nextRow] = token;		
		
        return true;		
    } 
	
    /**
     *  Check if the column contains a Nibble.
     *  Iterate through the single column looking for 4 consecutive same tokens
     *  
     *  @return True if the column contains 4 or more consecutive 'O' tokens, else false.
     */
	
    public boolean checkVictory(char token) {
		
        String tok = String.valueOf(token);
		
        /* Column Nibble */
		
        for (int i = 0; i < column.length-4; i++) {
			
            String r1 = String.valueOf(column[i  ]);
            String r2 = String.valueOf(column[i+1]);
            String r3 = String.valueOf(column[i+2]);
            String r4 = String.valueOf(column[i+3]);
		
            if(r1.equals(r2) && r2.equals(r3) && r3.equals(r4) && r4.equals(tok))
				
                return true;
        }		
		
        return false;
		
    } // End of checkVictory method
	
    /**
     *  Returns the current height of the Column.
     *  
     *  @return the height of the column
     */
	
    public int getHeight() {
		
        int col_height = 0;
		
        for (int i = 0; i < column.length; i++) {
			
            if(column[i] == 'O' || column[i] == 'X')			
                col_height++;							
        }
        height = col_height;
		
        return height;		
    } 
	
} // End of Column class
