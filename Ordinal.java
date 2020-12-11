/**
 * This class serves as a utility class containing only static methods about ordinal numbers.
 * @author Your Name Here
 * @version 1.0
 * @since 1.8
 *
 */

// Optional Class

public class Ordinal {

	/**
	 * Returns the ordinal value of the specified integer value.
	 * 
	 * @param integer A cardinal integer value.
	 * @return The ordinal value of the cardinal integer value.
	 */
	
	public static String getOrdinal(int integer) {
		
		// TODO: implement getOrdinal
		// hint: use modulus division and a switch statement
		
		switch (integer)
		{
			case 1: 
				return "first";
				
			case 2: 
				return "second";
			
			case 3: 
				return "third";
			
			case 4: 
				return "fourth";
			
			case 5: 
				return "fifth";
			
			case 6: 
				return "sixth";
				
			case 7: 
				return "seventh";
				
			case 8: 
				return "eight";
			
			default:
					return "";
			
		}		
	}	
}
