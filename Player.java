/**
 *  This class implements a simple Player of the game NibbleNabble.
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

public class Player {
	
    private String name;
    private char token;
	
    /**
     *  No-args constructor initializes the name to Computer and token to the letter O.
     */
		
    public Player() {
		
        name = "Computer";
        token = 'O';
    }

    /**
     *  Initial constructor initializes the name to the specified parameter and token to the letter X.
     * 
     *  @param name The Player's name.
     */
	
    public Player(String name) {
		
        this.name = name;
        this.token = 'X';
    }	
	
    /**
     *  Getter method that returns the Player's name.
     *  
     *  @return the Player's name
     */
	
    public String getName() {
		
        return name;
    }	
	
    /**
     *  Returns the Player's token (X or O).
     *  
     *  @return X if the Player is the end user, or O if the Player is the computer.
     */
	
    public char getPlayerToken() {
		
        if (getName() == "Computer") {
			
            return 'X';
        }
        else
            return 'O';		
    } 
	
} // End Player class
