import java.util.*;
import java.text.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class DateDemo {

	protected static HashMap<String, Integer> wordsMap = new HashMap<>();
	private static List<String> lines = new LinkedList<>();

	public static void main(String args[]) {

		Date dNow = new Date();// Instantiate a Date object
		SimpleDateFormat ft = new SimpleDateFormat("E yyyy.MM.dd 'Time:' hh:mm:ss");// display time and date using toString()
																					// 

		System.out.println("Current Date: " + ft.format(dNow));
	}

	public void setVisible(boolean b) {

	}


	public static void readFile(File fileName) {
		Scanner sc = null;

		try {
			sc = new Scanner(fileName, "windows-1251");

			while (sc.hasNext()) {
				addToMap(removeSigns(sc.next()));
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error! File " + fileName + " can't open for reading.");
		} finally {
			if (sc != null) {
				sc.close();
			}
		}
	}

	static String removeSigns(String word) {

		StringBuilder newWord = new StringBuilder(word);

		char firstChar = word.charAt(0);
		char lastChar = word.charAt(word.length() - 1);

		if (isSign(firstChar)) {
			newWord.deleteCharAt(0);
		}

		if (isSign(lastChar)) {
			newWord.deleteCharAt(newWord.length() - 1);
		}

		return newWord.toString();

	}

	private static boolean isSign(char ch) {

		switch (ch) {
		case '"':
		case ',':
		case '!':
		case '?':
		case '.':
		case '(':
		case ')':
		case ':':
			return true;
		default:
			return false;
		}
	}

	public static void addToMap(String string) {
		if (string.length() > 2) {
			int counter = wordsMap.containsKey(string) ? wordsMap.get(string) : 0;
			wordsMap.put(string.toString(), counter + 1);
		}
	}

	public static String getMostCommonWord() {

		int max = 0;
		String word = "";

		for (String s : wordsMap.keySet()) {

			if (wordsMap.get(s) > max) {
				max = wordsMap.get(s); // max gets number of repeatings of the
										// word
				word = s;
			}
		}

		System.out.printf("Most common word in text is: %s - (%d times).\n", word, max);
		return word;
	}

}
	

	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

			
	


