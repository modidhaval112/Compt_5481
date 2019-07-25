package com.leetcode;

import java.util.Scanner;
import java.util.Stack;

public class Problem3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Integer noOfInputs = Integer.parseInt(sc.nextLine());

		for (int j = 0; j < noOfInputs; j++) {

			String input = sc.nextLine();
			Stack<Character> st = new Stack<>();

			char[] inputArray = input.toCharArray();
			boolean flag = true;

			for (int i = 0; i < inputArray.length; i++) {
				if (inputArray[i] == '{' || inputArray[i] == '['
						|| inputArray[i] == '(') {
					st.push(inputArray[i]);
				} 
				else if (inputArray[i] == '}') {

					Character temp = st.peek();

					if (temp != '{') {
						flag = false;
						break;
					}
					else{
						st.pop();
					}
				} 
				else if (inputArray[i] == ')') {

					Character temp = st.peek();

					if (temp != '(') {
						flag = false;
						break;
					}
					else{
						st.pop();
					}
				} 
				else if (inputArray[i] == ']') {

					Character temp = st.peek();

					if (temp != '[') {
						flag = false;
						break;
					}
					else{
						st.pop();
					}
				}
			}

			if (flag && st.size() == 0) {
				System.out.println("TRUE");
			} else {
				System.out.println("FALSE");
			}
		}
	}
}
