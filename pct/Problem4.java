package com.leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

public class Problem4 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String[] noOfInputs = sc.nextLine().split("\\s+");
		
		Integer noOfVerticals = Integer.parseInt(noOfInputs[0]);
		Integer noOfhorizontals = Integer.parseInt(noOfInputs[1]);
		
		Map<Map<Integer, Integer>, Map<Integer, Integer>> verticalPairs = new LinkedHashMap<Map<Integer, Integer>, Map<Integer, Integer>>();
		Map<Map<Integer, Integer>, Map<Integer, Integer>> horizontalPairs = new LinkedHashMap<Map<Integer, Integer>, Map<Integer, Integer>>();
		
		for (int i = 0; i < noOfVerticals; i++) {
			
			String[] coOrdinates = sc.nextLine().split("\\s+");
			
			Map<Integer, Integer> firstCoORdinate = new HashMap<Integer, Integer>();
			Map<Integer, Integer> secondCoORdinate = new HashMap<Integer, Integer>();
			
			firstCoORdinate.put(Integer.parseInt(coOrdinates[0]), Integer.parseInt(coOrdinates[1]));
			secondCoORdinate.put(Integer.parseInt(coOrdinates[0]), Integer.parseInt(coOrdinates[2]));
			
			verticalPairs.put(firstCoORdinate, secondCoORdinate);
			
			
		}

		for (int i = 0; i < noOfhorizontals; i++) {
			
			String[] coOrdinates = sc.nextLine().split("\\s+");
			
			Map<Integer, Integer> firstCoORdinate = new HashMap<Integer, Integer>();
			Map<Integer, Integer> secondCoORdinate = new HashMap<Integer, Integer>();
			
			firstCoORdinate.put(Integer.parseInt(coOrdinates[1]), Integer.parseInt(coOrdinates[0]));
			secondCoORdinate.put(Integer.parseInt(coOrdinates[2]), Integer.parseInt(coOrdinates[0]));
			
			horizontalPairs.put(firstCoORdinate, secondCoORdinate);
			
		}
		
		int noOfIntersections = 0;
		
		for (Entry<Map<Integer, Integer>, Map<Integer, Integer>> vEntry : verticalPairs.entrySet()) {
			
			Map<Integer, Integer> vFirst = vEntry.getKey();
			Map<Integer, Integer> vSecond = vEntry.getValue();
			
			int vfirstx = vFirst.entrySet().iterator().next().getKey();
			int vfirsty = vFirst.entrySet().iterator().next().getValue();
			
			int vsecondx = vSecond.entrySet().iterator().next().getKey();
			int vsecondy = vSecond.entrySet().iterator().next().getValue();
			
						
			for (Entry<Map<Integer, Integer>, Map<Integer, Integer>> hEntry : horizontalPairs.entrySet()) {
								
				Map<Integer, Integer> hFirst = hEntry.getKey();
				Map<Integer, Integer> hSecond = hEntry.getValue();
				
				int hfirstx = hFirst.entrySet().iterator().next().getKey();
				int hfirsty = hFirst.entrySet().iterator().next().getValue();
				
				int hsecondx = hSecond.entrySet().iterator().next().getKey();
				int hsecondy = hSecond.entrySet().iterator().next().getValue();
							
				
				if((vfirstx >= Math.min(hfirstx, hsecondx)) && (vsecondx <= Math.max(hfirstx, hsecondx))
						&& (hfirsty >= Math.min(vfirsty, vsecondy)) && (hsecondy <= Math.max(vfirsty, vsecondy))){
					noOfIntersections++;
				}
				
				
			}
			
			
		}
		
		System.out.println(noOfIntersections);
		
		sc.close();
		
	}
	
}
