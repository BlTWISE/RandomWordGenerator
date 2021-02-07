package main;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
	
	static Table table = new Table();

	public static void main(String[] args) {
		
		for (int i = 0; i < 100; i++) {
			//Generate a random word of 3-5 characters with length
			String randomWord = generateWord(3, 5);
			print(randomWord);
		}
		
		for (int i = 0; i < 100; i++) {
			//Generate a random word that starts with v and is 3-5 characters in length
			String randomWordWithDesignatedPrefixLetter = generateWord(3, 5, 'v');
			print(randomWordWithDesignatedPrefixLetter);
		}

	}
	
	/**
	   * This method generates a table of letter-pairing frequencies (for instance, n-a=28%) by reading data
	   * from a .txt file that contains the data. The data is structured in a row format with each row containing
	   * a new letter of the alphabet and a list of tuples. The tuples are structured in letter-frequency format.
	   */
	private static void createTable() {
		
		String fileName = "letter_combo_frequencies.txt";

		try {
			final List<String> lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
			
			for (String line : lines) {
				
				ArrayList<Letter> letterList = new ArrayList<Letter>();
				
				String[] tokens = line.split(" ");
				for (String token : tokens) {
					if (token.length() == 2) {
						continue; //first token
					}
					String substring = token.substring(2, token.length()-1);
					StringBuilder sb = new StringBuilder(substring);
					String noPeriod = sb.deleteCharAt(sb.indexOf(".")).toString();
					letterList.add(new Letter(token.charAt(0), Integer.parseInt(noPeriod)));
				}
				
				table.dataHashmap.put(line.charAt(0), letterList);
				table.calcLowerBounds(line.charAt(0));
				
			}
			
		} catch (IOException e) {
			
		}
		 
  
		
	}
	
	static boolean tableCreated = false;
	/**
	   * This method is used to generate random, likely-pronouncable English words based off frequency of letter pairings.
	   * It uses a sample data set from StackOverflow to gather frequency data.
	   * 
	   * @param min The minimum length of the random word.
	   * @param max The maximum length of the random word.
	   * @param firstLetter An optional parameter that specifies the first letter of the word.
	   * @return String This returns the random word.
	   */
	public static String generateWord(int min, int max) {
		
		if (!tableCreated) {
			createTable();
			tableCreated = true;
		}
		
		//Based off https://english.stackexchange.com/questions/110576/what-are-the-most-common-letters-used-in-pairs-after-others-in-the-english-alpha
		int lengthOfWord = randomInt(min, max);
		String word = "";
		String alphabet = "qwertyuiopasdfghjklzxcvbnm";
		char nextLetter = alphabet.charAt(randomInt(0, alphabet.length()-1));
		word += nextLetter;
		
		for (int i = 0; i < lengthOfWord-1; i++) {
			
			nextLetter = returnNextLetter(nextLetter);
			word += nextLetter;
			
		}
		
		return word;
		
	}
	
	/**
	   * This method is used to generate random, likely-pronouncable English words based off frequency of letter pairings.
	   * It uses a sample data set from StackOverflow to gather frequency data.
	   * 
	   * @param min The minimum length of the random word.
	   * @param max The maximum length of the random word.
	   * @param firstLetter An optional parameter that specifies the first letter of the word.
	   * @return String This returns the random word.
	   */
	public static String generateWord(int min, int max, char firstLetter) {
		
		if (!tableCreated) {
			createTable();
			tableCreated = true;
		}
		
		//Based off https://english.stackexchange.com/questions/110576/what-are-the-most-common-letters-used-in-pairs-after-others-in-the-english-alpha
		int lengthOfWord = randomInt(min-1, max-1);
		String word = "";
		char nextLetter = firstLetter;
		word += nextLetter;
		
		for (int i = 0; i < lengthOfWord; i++) {
			
			nextLetter = returnNextLetter(nextLetter);
			word += nextLetter;
			
		}
		
		return word;
		
	}
	
	/**
	   * This method is used to generate the next letter of a word based off the previous letter and frequencies of letter pairings.
	   * It is used in conjunction with the randomWord_FromData method.
	   * 
	   * @param letter The previous letter in the sequence.
	   * @return char This returns the next letter.
	   */
	public static char returnNextLetter(char letter) {
		
		
		int n = randomInt( 0, 100_000 ); //generate random number
		ArrayList<Letter> letters = table.dataHashmap.get(letter);
		
		for (int i = 0; i < letters.size(); i++) {
			
			Letter currentLetter = letters.get(i);
			
			if (i == 0) {
				
				if (n < letters.get(i+1).lowerBound) {
					return currentLetter.getLetter();
				}
				
			}else if (i == letters.size() - 1) {
				
				if (n > letters.get(letters.size() - 1).lowerBound) {
					return currentLetter.getLetter();
				}
				
			}else {
				
				if (n < letters.get(i+1).lowerBound && n > letters.get(i-1).lowerBound) {
					return currentLetter.getLetter();
				}
				
			}
			
		}
		
		return 'a';
		
	}
	
	public static int randomInt(int min, int max) {
		Random random = new Random();
		return random.nextInt(max + 1 - min) + min;
	}
	
	
	public static void print(String s) {
		System.out.println(s);
	}

}
