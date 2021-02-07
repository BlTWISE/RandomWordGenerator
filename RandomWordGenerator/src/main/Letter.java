package main;

/**
 * A randomized letter that contains the letter character and a chance variable that represents the probability of the letter appearing in a particular pairing with another letter.
 * 
 * @author BlTWISE
 * @version 1.0
 *
 */
public class Letter {

	/**
	 * The character of this letter. Ranges from a-z.
	 */
	char letter = 'a';
	/**
	 * An integer that represents the percent chance (1-99) of a letter pairing.
	 */
	int chance = 0;
	/**
	 * The lower bound value for this letter, used in the random letter decider algorithm.
	 */
	int lowerBound = 0;
	
	public Letter() {
		
	}
	
	/**
	 * Initializes a letter.
	 * @param letter The character of this letter. Ranges from a-z.
	 * @param chance The percent chance of this letter appearing. Based off frequency data of letter pairings.
	 */
	public Letter(char letter, int chance) {
		
		this.letter = letter;
		this.chance = chance;
		
	}
	
	/**
	 * Gets the percent chance of this letter.
	 * @return The integer chance value.
	 */
	public int getChance() {
		return chance;
	}
	
	/**
	 * Gets the character this letter represents.
	 * @return The character letter.
	 */
	public char getLetter() {
		return letter;
	}
	
	/**
	 * Sets the lower bound value for this letter.
	 * @param n The lower bound value.
	 */
	public void setLowerBound(int n) {
		lowerBound = n;
	}
	
}
