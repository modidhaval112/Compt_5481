package com.leetcode;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Project2 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine().trim();
		Set<String> inputSet = new LinkedHashSet<>();
		
		if(input == null || input.isEmpty() || input.length() == 0 || input.trim().length() == 0){
			System.out.print("0");
		}
		else{
			String[] inputArray = input.toUpperCase().split("\\s+");
			
			for (int i = 0; i < inputArray.length; i++) {
				if(input != null && !input.isEmpty() && input.length() != 0 && input.trim().length() != 0)
				inputSet.add(inputArray[i].trim());
			}
			System.out.print(inputSet.size());
		}
		
		sc.close();
	}

}
