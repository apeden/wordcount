package wordcount;
import java.util.Scanner;
import java.util.Formatter;
import java.io.File;
import java.io.FileNotFoundException;


public class Wordcount {
	public Wordcount(String file) {
		filename = new String(file);
		arr = new char[20][100];
	}
	
	//function that creates a file object and passes it to a Scanner	
	public void setFileScanner() {
		try {
			lear = new File (filename);
		}catch (Exception e){
			System.out.println("cannot find file");
		}
		
		try {
			sc = new Scanner(lear);
		}catch (Exception e){
			System.out.println("Cannot find file object");
		}
		
	}	
	
	public Scanner getFileScanner() {
		return sc;
	}
	
	//function that reads chars from a file objegct and puts them in a 2d array
	
	public void setArray() {
		for (int i = 0; i < 20; i++) {
			if (sc.hasNextLine()) {
				line = sc.nextLine();
				arr[i] = line.toCharArray(); 
			}
		}
	}
	public char[][] getArray() {
		return arr;
	}
	
	public int getNumberOfLine() {
		number_of_lines = 0;
		for (int i = 0; i < 20; i++) {
			if (Character.isLetterOrDigit(arr[i][0])) {
				number_of_lines += 1;
			}
		}return number_of_lines;
	}
	public int getNumberOfChars() {
		number_of_chars = 1;
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 100; j++) {
				try {
					System.out.println(Integer.toString(number_of_chars) + arr[i][j]);
					if ((Character.isLetterOrDigit(arr[i][j])||Character.isWhitespace(arr[i][j]))) {
						number_of_chars += 1;
					}
				} catch (IndexOutOfBoundsException e) {
					break;
				}
			}
		}
		return number_of_chars;
	}
	public int getNumberOfWords() {
		number_of_words = 0;
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 100; j++) {
				try {
					System.out.println(Integer.toString(number_of_chars) + arr[i][j]);
					if ((Character.isWhitespace(arr[i][j]) && Character.isLetterOrDigit(arr[i][j+1]))) {
						number_of_words += 1;
					}
				} catch (IndexOutOfBoundsException e) {
					break;
				}
			}
		}number_of_words += number_of_lines;
		return number_of_words;
	}
	/*private instance variables*/
	public String filename;
	private File lear;
	private Scanner sc;
	private String line;
	private char[][] arr;
	private int number_of_chars;
	private int number_of_lines;
	private int number_of_words;
}
	
	
	
	

	
