import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;


public class PCTExam1 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String[] inputArray = sc.nextLine().split(" ");
		
		Integer totalSeats = Integer.parseInt(inputArray[0]);
		Integer totalPerson = Integer.parseInt(inputArray[1]);
		
		Integer[] seats = new Integer[totalSeats];
 		
		for (int i = 0; i < totalPerson; i++) {
			
			List<Integer> emptySeats = new LinkedList<Integer>();
			
			for (int j = 0; j < totalSeats; j++) {
				if(seats[j] ==  null){
					emptySeats.add(j);
				}
			}
			
			if(emptySeats.size() == seats.length){
				seats[0] = i+1;
			}
			
			else if(emptySeats.size() == (seats.length - 1)){
				seats[seats.length - 1] = i+1;
			}
			else if(emptySeats.size() == 1){
				seats[emptySeats.get(0)] = i+1;
			}
			else{
				
				Map<Integer, Integer> distanceMap = new HashMap<Integer, Integer>();
				
				for (int k = 0; k < emptySeats.size(); k++) {
					
					int left = 0;
					int right = 0;
					
					for (int j = emptySeats.get(k) - 1 ; j >= 0; j--) {
						if(seats[j] == null){
							left++;
						}
						else{
							//System.out.println("Left : " + left);
							break;
						}
						
					}
					
					for (int j = emptySeats.get(k) + 1 ; j < seats.length; j++) {
						if(seats[j] == null){
							right++;
						}
						else{
							//System.out.println("Right : " + right);
							break;
						}
						
					}
					
					distanceMap.put(emptySeats.get(k), left * right);
										
				}
				
				int max = 0;
				int maxNode = 0;
				for (Entry<Integer, Integer> entry : distanceMap.entrySet()) {
					
					if(max < entry.getValue()){
						max = entry.getValue();
						maxNode = entry.getKey();
					}
					
					else if(max == entry.getValue()){
						//System.out.println("Equal");
						if(maxNode > entry.getKey()){
							max = entry.getValue();
							maxNode = entry.getKey();
						}
					}
					
					
					
					//System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
				}
				//System.out.println("Max : " + max);
				//System.out.println("Max Node : " + maxNode);
				
				if(maxNode != 0)					
					seats[maxNode] = i+1;
				else
					seats[emptySeats.get(0)] = i+1;
				
				
			}
			
			
		}
		for (int i = 0; i < seats.length; i++) {
			System.out.print(seats[i] + " ");
			
		}
		System.out.println();
		for (int i = 0; i < seats.length; i++) {
			if(seats[i] == totalPerson){
				System.out.print(i+1);
			}
		}
		
		
		
		sc.close();
	}

}
