package com.test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/* Sorts series of input words in alphabetical order ignoring case
 * and non alphabetical characters.
 */
public class Alphabetizer {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of words : ");
		int numOfWords = Integer.parseInt(sc.nextLine());
		//Add input words to list
		List<String> words = new ArrayList<>();
		for(int i=0; i< numOfWords; i++) {
			words.add(sc.nextLine());
		}
		// Remove non alphabetical characters from input and sort
		System.out.println("Result after sorting..");
		for(String word: words){
			Character[] result = sortWords(word);
			// print the sorted word
			Arrays.stream(result).forEach(System.out::print);
			System.out.println("");
		}
		sc.close();
	}

	private static Character[] sortWords(String word) {
		word = word.replaceAll("[^a-zA-Z]", "");
		if(word.length() <= 0) {
			return new Character[0];
		}else if (word.length() == 1) {
			return new Character[]{word.charAt(0)};
		}
		Character[] wordChar = 
				word.chars().mapToObj(c -> (char)c).toArray(Character[]::new); 
		// Sorts each word ignoring case
		Arrays.sort(wordChar,new Comparator<Character>(){
			@Override
			public int compare(Character c1, Character c2) {
				return Character.compare(Character.toLowerCase(c1),Character.toLowerCase(c2));
			}
			
		});
		return wordChar;
	}

}
