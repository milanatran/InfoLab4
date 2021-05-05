package lab4;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class FileWriter {

	public static void main(String[] args) throws IOException {
		PrintWriter out = new PrintWriter("frequency.txt");
		String str = "Hello World!";
		Integer i = 456;
		int a = 123;
		
		//out.print(str + " " + i + " " + a);
		//out.println();
		//out.close();
		
		char[] characters = ReadFile.listCharacters();
		int[] frequencies = ReadFile.countLetters(ReadFile.textArray(), characters);
		//printHistogram(characters, frequencies);
		printHistogramAdjusted(characters, frequencies);

	}
	
	public static void printHistogram(char[] c, int[] frequencies) throws FileNotFoundException {
		PrintWriter out = new PrintWriter("frequency.txt");
		for (int i = 0; i < c.length; i++) {
			out.print(c[i] + " : ");
			System.out.print(c[i] + " : ");
			int frequency = frequencies[i];
			for (int j = 0; j < frequency; j++) {
				System.out.print("*");
				out.print("*");
			}
			out.println();
			System.out.println();
		}
		out.close();
	}
	
	
	public static void printHistogramAdjusted(char[] c, int[] frequencies) throws FileNotFoundException {
		PrintWriter out = new PrintWriter("frequency.txt");
		int maxFrequency = getLargestFrequency(frequencies);
		for (int i = 0; i < c.length; i++) {
			out.print(c[i] + " : ");
			System.out.print(c[i] + " : ");
			int stars = calculateStars(frequencies[i], maxFrequency);
			for (int j = 0; j < stars; j++) {
				out.print("*");
				if (j > 0 && j % 10 == 0) {
					out.print("|");
					System.out.print("|");
				}
				System.out.print("*");
			}
			out.println();
			System.out.println();
		}
		out.close();
	}
	
	// Returns the largest value in the frequency array
	public static int getLargestFrequency(int[] frequencies) {
		int max = frequencies[0];
		for (int i = 0; i < frequencies.length; i++) {
			if(frequencies[i] >= max) {
				max = frequencies[i];
			}
		}
		return max;
	}
	
	// Calculates how many stars to print. 100 stars for the most frequent character
	public static int calculateStars(int frequency, int maxFrequency) {
		if (frequency == maxFrequency) {
			return 100;
		}else {
			return frequency * 100 / maxFrequency;
		}
	}

}
