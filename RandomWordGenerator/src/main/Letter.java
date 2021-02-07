package main;

public class Letter {

	/*
	 * @letter 
	 * @chance
	 */
	char letter = 'a';
	int chance = 0;
	int lowerBound = 0;
	
	public Letter() {
		
	}
	
	public Letter(char letter, int chance) {
		
		this.letter = letter;
		this.chance = chance;
		
	}
	
	public int getChance() {
		return chance;
	}
	
	public char getLetter() {
		return letter;
	}
	
	public void setLowerBound(int n) {
		lowerBound = n;
	}
	
}
