package java_programs.java_programs;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 
 * Instructions: if input is required from variable then please comment line 21
 *  
 *  input data can be changed by updating variable in line 18
 *
 */
public class Solutions {

	public static void main(String[] args) throws IOException {
		
		String testData = "abcabcbb";

		Scanner stringScanner = new Scanner(System.in);
		testData = stringScanner.next();
		stringScanner.close();
		
		
		Solutions objSolutions = new Solutions();
		int length = objSolutions.getLongestSubStringLength(testData);
		System.out.println("Longest substring of: " + testData + " and length is: " + length);

	}

	public int getLongestSubStringLength(String input) {

		int MAX = 0;

		if (input.length() > 0) {

			char[] inputArray = input.toCharArray();
			boolean[] checked = new boolean[256];
			int j = 0, i = 0;
			while (i < inputArray.length && j < inputArray.length) {

				// if character is not already checked then set, checked to true
				if (checked[inputArray[j]] == false) {
					MAX = Math.max(MAX, j - i + 1);
					checked[inputArray[j]] = true;
					j++;
				} else {
					checked[inputArray[i]] = false;
					i++;
				}

			}

		} else {
			System.err.println("Test String is not valid: " + input);
		}

		return MAX;

	}

	public int getLargestSubStringLength(String input) {

		int MAX = 0;
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();

		if (input.length() > 0) {

			char[] inputArray = input.toCharArray();
			int j = 0, i = 0;
			while (i < inputArray.length && j < inputArray.length) {

				if (hm.containsKey(inputArray[j])) {
					i = hm.get(inputArray[j]) + 1;
				}
				hm.put(inputArray[j], j);
				MAX = Math.max(MAX, j - i + 1);
				j++;

			}

		} else {
			System.err.println("Test String is not valid: " + input);
		}
		return MAX;

	}

}
