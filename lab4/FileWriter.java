package lab4;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class FileWriter {

	public static void main(String[] args) throws FileNotFoundException {
		PrintWriter out = new PrintWriter("frequency.txt");
		String str = "Hello World!";
		Integer i = 456;
		int a = 123;
		
		out.print(str + " " + i + " " + a);
		out.close();
	}

}
