package com.leetcode;

import java.util.Scanner;

public class Problem1 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String[] inputArray = sc.nextLine().trim().split(" ");

		if (inputArray.length == 1) {
			System.out.print(inputArray[0]);
		} 
		else if (inputArray.length == 2) {
			
			if(inputArray[1].charAt(inputArray[1].length() - 1) == 'a' ||
					inputArray[1].charAt(inputArray[1].length() - 1) == 'A' ||
					inputArray[1].charAt(inputArray[1].length() - 1) == 'e' ||
					inputArray[1].charAt(inputArray[1].length() - 1) == 'E' ||
					inputArray[1].charAt(inputArray[1].length() - 1) == 'i' ||
					inputArray[1].charAt(inputArray[1].length() - 1) == 'I' ||
					inputArray[1].charAt(inputArray[1].length() - 1) == 'o' ||
					inputArray[1].charAt(inputArray[1].length() - 1) == 'O' ||
					inputArray[1].charAt(inputArray[1].length() - 1) == 'u' ||
					inputArray[1].charAt(inputArray[1].length() - 1) == 'U'){
				
				System.out.print(inputArray[1] + " " + inputArray[0]);
				
			}
			else{
				System.out.print(inputArray[0] + " " + inputArray[1]);
			}

		} 
		else if (inputArray.length == 3) {
			System.out.print(inputArray[2] + " " + inputArray[0] + " " + inputArray[1]);
		}

	}
}
