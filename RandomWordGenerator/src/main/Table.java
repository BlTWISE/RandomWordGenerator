package main;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A table of each character in the alphabet (a-z) and all of the probabilities of the letter pairings for each character in the alphabet. I.e., for the character 'a', we'd store each pairing (a-b, a-c, a-d, etc.) and the frequency of each 
 * pairing as they appear in the English language.
 * 
 * @author BlTWISE
 * @version 1.0
 *
 */
public class Table {

	/**
	 * The character is the key. The value is an ArrayList of Letters, which contains the percent chance of it appearing.
	 */
	HashMap<Character, ArrayList<Letter>> dataHashmap = new HashMap<Character, ArrayList<Letter>>();
		
	public Table() {
		
	}
		
	/**
	 * Initializes and calculates the lower bound value for each letter in the pairings.
	 * @param c The dataHashmap key.
	 */
	public void calcLowerBounds(char c) {
			
		ArrayList<Letter> letters = dataHashmap.get(c);
		int sum = 0;
			
		for (Letter letter : letters) {
				
			letter.setLowerBound(sum);
			sum += letter.getChance();
				
		}
			
	}
	
}
