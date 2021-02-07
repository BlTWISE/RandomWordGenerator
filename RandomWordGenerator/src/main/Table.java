package main;

import java.util.ArrayList;
import java.util.HashMap;

public class Table {

	//Contains frequencies of each letter
	
		HashMap<Character, ArrayList<Letter>> dataHashmap = new HashMap<Character, ArrayList<Letter>>();
		
		public Table() {
			
		}
		
		public void calcLowerBounds(char c) {
			
			ArrayList<Letter> letters = dataHashmap.get(c);
			int sum = 0;
			
			for (Letter letter : letters) {
				
				letter.setLowerBound(sum);
				sum += letter.getChance();
				
			}
			
		}
	
}
