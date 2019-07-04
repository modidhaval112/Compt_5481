import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class Lab6 {

	Set<Integer> visitedSet = new HashSet<Integer>();

	public static void main(String[] args) {

		Lab6 obj = new Lab6();

		Scanner sc = new Scanner(System.in);
		Integer noOfVetices = Integer.parseInt(sc.nextLine());
		Integer noOfEdges = Integer.parseInt(sc.nextLine());
		Map<Integer, Set<Integer>> graph = new LinkedHashMap<Integer, Set<Integer>>();

		for (int i = 0; i < noOfVetices; i++) {
			graph.put(i+1, null);
		}

		for (int i = 0; i < noOfEdges; i++) {
			String[] edge = sc.nextLine().split(" ");

			Integer startNode = Integer.parseInt(edge[0].trim());
			Integer endNode = Integer.parseInt(edge[1].trim());

			for (Entry<Integer, Set<Integer>> entry : graph.entrySet()) {
				if (entry.getKey() == startNode) {
					Set<Integer> tempList = entry.getValue();
					if (tempList == null) {
						tempList = new HashSet<Integer>();
						tempList.add(endNode);
					} else
						tempList.add(endNode);
					graph.put(entry.getKey(), tempList);

				} else if (entry.getKey() == endNode) {
					Set<Integer> tempList = entry.getValue();
					if (tempList == null) {
						tempList = new HashSet<Integer>();
						tempList.add(startNode);
					} else
						tempList.add(startNode);
					graph.put(entry.getKey(), tempList);

				}
			}

		}

		boolean flag = false;
		Set<String> disconnectedComp = new HashSet<String>();

		for (Entry<Integer, Set<Integer>> entry : graph.entrySet()) {
			obj.visitedSet = checkCOnnectedGraph(graph, obj.visitedSet, entry);
			String temp = "";
			
			for (Integer setEntry : obj.visitedSet) {
				//System.out.println("Set Value : for " + entry.getKey() + " is " + setEntry);
				temp = temp + setEntry;
			}
			disconnectedComp.add(temp);
			
			if(obj.visitedSet.size() == graph.size()){
				System.out.print("1");
				flag = true;
				break;
				
			}
			
			if(flag){
				break;
			}
			
			obj.visitedSet = new HashSet<Integer>();
			
		}
		if(!flag)
		System.out.print("0 " + disconnectedComp.size());

		

		//System.out.println("Size : " + obj.visitedSet.size());

		sc.close();

	}

	public static Set<Integer> checkCOnnectedGraph(
			Map<Integer, Set<Integer>> graph, Set<Integer> visitedSet,
			Entry<Integer, Set<Integer>> entry) {

		visitedSet.add(entry.getKey());

		if (entry.getValue() != null) {

			for (Integer neighbour : entry.getValue()) {
				if (!visitedSet.contains(neighbour)) {
					for (Entry<Integer, Set<Integer>> tempEntry : graph
							.entrySet()) {
						if (neighbour == tempEntry.getKey()) {
							checkCOnnectedGraph(graph, visitedSet, tempEntry);
							break;
						}

					}
				}
			}
		}

		return visitedSet;

	}

}
