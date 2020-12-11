/**
 *  This class kicks off the game NibbleNabble and continues playing until the user quits.
 *
 *  CST8110 - Introduction to Computer Programming
 * 
 *  Section:               451
 *  Semester:              20S
 *  Professor:             Jangam
 *  Student ID:            040552420
 *  Student Email:         pass0011@algonquinlive.com
 * 
 *  Practical Assignment 2
 *  
 *  @author  Jordan Passant
 *  @version 1.0
 *  @since   1.8
 *
 */

public class Main {
	
    /**
     *  The main method declares a new instance of the game NibbleNabble.
     *  Execute the playGame method while the quit method continues to return false.
     *  If the playGame method returns false, exit the loop.
     * 
     *  @param args UNUSED
     */
	
     public static void main(String[] args) {
		
        // New instance of NibbleNabble
        NibbleNabble game = new NibbleNabble();
		
        // Run the game 
        game.playGame();
		
        System.out.print("\nThanks for playing 'NibbleNabble' //xoxo ");
    }	

} // End of Main class