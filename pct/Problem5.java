package com.leetcode;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Problem5 {
	
	public static boolean flag = true;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Integer noOfInputs = Integer.parseInt(sc.nextLine());
		Map<Integer, List<Integer>> graph = new LinkedHashMap<Integer, List<Integer>>();

		for (int i = 0; i < noOfInputs; i++) {

			String[] values = sc.nextLine().split("\\s+");

			Integer resourceId = Integer.parseInt(values[0]);
			Integer hasResource = Integer.parseInt(values[1]);
			Integer wantResource = Integer.parseInt(values[2]);

			if (wantResource != -1) {
				if (!graph.keySet().contains(resourceId)) 
				{
					List<Integer> tempList = new LinkedList<Integer>();
					tempList.add(wantResource);
					graph.put(resourceId, tempList);

				} 
				else 
				{
					List<Integer> tempList = graph.get(resourceId);
					tempList.add(wantResource);
					graph.put(resourceId, tempList);

				}
			}

			if (hasResource != -1) {

				if (!graph.keySet().contains(hasResource)) 
				{
					List<Integer> tempList = new LinkedList<Integer>();
					tempList.add(resourceId);
					graph.put(hasResource, tempList);
				} 
				else
				{
					List<Integer> tempList = graph.get(hasResource);
					tempList.add(resourceId);
					graph.put(hasResource, tempList);
				}
			}

		}
		
		
		for (Entry<Integer, List<Integer>> entry : graph.entrySet()) {
			if(flag){
				LinkedList<Integer> visited = new LinkedList<>();
				findDeadLock(graph, entry.getKey(), visited);
			}
		}

/*		for (Entry<Integer, List<Integer>> entry : graph.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}*/
		
		if(flag){
			System.out.println("NO");
		}
		else{
			System.out.println("YES");
		}

		sc.close();

	}

	public static void findDeadLock(Map<Integer, List<Integer>> graph, Integer node, LinkedList<Integer> visited) {
		
		
		if(visited.contains(node)){
			flag = false;
			return;
		}
		visited.add(node);
		//System.out.println(visited);

				
		if(graph.keySet().contains(node)){
			
			List<Integer> neighbourList = graph.get(node);
			
			for (Integer neighbour : neighbourList) {
				findDeadLock(graph, neighbour, visited);
			}
			
		}
		
	}

}
