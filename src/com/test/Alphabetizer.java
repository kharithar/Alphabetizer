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
		// Remove non alphabetical characters from input
		for(int i=0; i<words.size();i++){
			words.set(i, words.get(i).replaceAll("[^a-zA-Z]", ""));
			if(words.get(i).length() <= 0) {
				return;
			}
			Character[] word = new Character[words.get(i).length()];
			for(int j=0;j<words.get(i).length();j++) {
				word[j] = words.get(i).charAt(j);
			}
			// Sorts each word ignoring case
			Arrays.sort(word,new Comparator<Character>(){
				@Override
				public int compare(Character c1, Character c2) {
					return Character.compare(Character.toLowerCase(c1),Character.toLowerCase(c2));
				}
				
			});
			// print the sorted word
			for(Character c:word) {
				System.out.print(c);
			}
			System.out.println("");
		}
		sc.close();
	}

}
