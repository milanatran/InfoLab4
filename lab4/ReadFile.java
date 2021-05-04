package lab4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

public class ReadFile {

	public static void main(String[] args) throws IOException {
		
		System.out.println(textArray());
		countLetters(textArray());
		
		
		
	}
	
	public static char[] textArray() throws IOException {
		/*String inputFileName = "/Users/milanatran/Documents/coding/GitProjects/InfoLab4/Text.txt";
		File inputFile = new File(inputFileName);
		Scanner in = new Scanner(inputFile); */
		
		/*char[] txt = new char[(int) inputFile.length()];
		char ch = 0;
		while(in.hasNext()) {
			String str = in.next().toLowerCase();
			
			for(int j = 0; j < txt.length; j++) {
			for(int i = 0; i < str.length(); i++) {
				ch = str.charAt(i);
				txt[j] = ch;
				j++;
			}
				
			}
		} */
		String inputFileName = "/Users/milanatran/Documents/coding/GitProjects/InfoLab4/Text.txt";
		File inputFile = new File(inputFileName);
		FileReader input = new FileReader(inputFile);
		BufferedReader in = new BufferedReader(input);
		char[] txt = new char[(int) inputFile.length()];
		while(in.ready()) {
			for(int i = 0; i < txt.length; i++) {
				char a = (char) in.read();
				txt[i] = Character.toLowerCase(a);
			}
		}
		return txt;
	}
	
	public static void countLetters(char[] text) throws FileNotFoundException {
		char[] alphabet = new char[26];
		for(int i = 0; i < 26; i++) {
			alphabet[i] = (char) (97 + i);
		}
		
		
		int[] frequency = new int[alphabet.length];
		for(char c : alphabet) {
			int count = 0;
			for(char t : text) {
				if(t == c) {
					count++;
				}
			} frequency[c - 'a'] = count;
		}
		
		for (int i = 0; i < frequency.length; i++) {
			char a = (char) (i + 'a');
			String letter = Character.toString(a);
			System.out.println(letter + ": " + + frequency[i]);
		}
	}
	
	

}
