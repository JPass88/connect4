/**
 *  This class implements a simple version of Connect Four, called NibbleNabble.
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
 */

import java.util.Scanner;
import java.util.Random;

public class NibbleNabble {

    private Player  currentPlayer;         
    private Player  computer;
    private Player  user;
    private Board   board;
    private Scanner input;
    private String  name; 
	
    /**  
     *  Outputs a welcome message. 
     *  Prompts the user for their name, and instantiates a new Player with the name.
     *  Initializes the Scanner, Board, user and computer variables.
     */
	
    public NibbleNabble() {
		
        System.out.print("Welcome to NibbleNabble (Connect4)\n");
        System.out.print("Please enter your name: ");		
		
        // Initialize: Scanner
        input = new Scanner(System.in);
		
        // Receive name input
        String resp = input.nextLine();
				
        // Initializes player with given name
        user = new Player(resp);		
		
        // Initializes board and computer
        board = new Board();
        computer = new Player();
    }
	
    /**  
     *   This is the engine of NibbleNabble 
     *   It loops through for each player, receiving column input
     *   and checking for end-game conditions (victory or full-board)
     */
	
    public boolean playGame() {
		
        while (true) {
			
            int column = 0;
			
            board.display(); // Print current board state			
            currentPlayer = togglePlayer(); // Switch players for each turn

            System.out.print(currentPlayer.getName() + " (" + 
                    currentPlayer.getPlayerToken() + "'s) > ");
			
            // Grab input and make a move
			
            while (column == 0) {
				
                // Gets the desired column to drop a token in from computer/user
                // ..if user, controls for proper input
				
                if (currentPlayer == computer) {
					
                    column = new Random().nextInt(7) + 1;					
                }				
                else {
					
                    do {
						
                       while (!input.hasNextInt()) {
							
                            System.out.print(currentPlayer.getName() + " (" + 
                                    currentPlayer.getPlayerToken() + "'s) > ");
                            input.next();
                        }
                        column = input.nextInt();
                    } 
                    while (column < 1 || column > 7);
                }
				
                if (!board.makeMove(column, currentPlayer.getPlayerToken())) 
					
                    column = 0;
				
                else {
					
                    if (currentPlayer == computer)
                        System.out.print(column + "\n");
                }				
            } // Input/MakeMove loop
			
            // If game has a victor, print outcome  
			
            if(board.checkVictory(currentPlayer.getPlayerToken())) {
				
                if (currentPlayer == computer) {
					
                    System.out.print("Oh no! The computer won! ");
                }
                else {
					
                    System.out.printf("%s Wins!!! ", user.getName());
                }
				
                return false;
            }
            
			 
            // Fullboard?
			
            if (board.boardFull()) {
				
                System.out.println("\nOh no! Draw!!!");	
                board.display();
				
                return false;				
            }
        }	
    } // End of playGame method
	
    /*	UNUSED
     * 
     *  Re-initializes the board variable with a new Board object.
     *  Outputs prompt to user: Enter Q to quit, or any key to keep playing:
     *  If the user enters any variation of Q, q, Quit, quit, quits the game.
     *  @return True if the user wants to quit, false otherwise.
     */
	
    /*
    public boolean quit() 
    {
		
        System.out.println("\nEnter 'Q or q' to quit or any key to keep playing: ");
        String resp2 = input.nextLine();
		
        switch(resp2)
        {
            case "Q":
                return true;
            case "q":
                return true;
            case "quit":
                return true;
            case "Quit":
               return true;
            default:
               return false;
        }
    }*/

    /**
     *  If the currentPlayer is the user, returns computer. Otherwise, returns the user.
     *
     *  @return computer if currentPlayer is user, otherwise user.
     */
	
    private Player togglePlayer() {
		
        if(currentPlayer == user) {
			
            return computer;
        }		
        else
			
            return user;		
    } 
	
} // End of NibbleNabble class
