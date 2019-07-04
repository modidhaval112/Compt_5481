import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


class NodeLab3 {
	char value; 
	NodeLab3 left, right;
	
	NodeLab3(char value){
		this.value = value;
	}
	
}

public class Lab3 {
	
	NodeLab3 root;
	private static NodeLab3 foundNode = null;
	private static int index = 0;
	private static Queue<NodeLab3> treeQueue = new LinkedList<NodeLab3>();
		
		
	
	
	public static void main(String[] args) {
		Lab3 tree = new Lab3();
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
				
		tree.root = createTree(tree.root, input);
		//printInline(tree.root);
		
		printLevelOrder(tree.root);
		
		sc.close();
		
	}


	public static void printLevelOrder(NodeLab3 root) {
		
		treeQueue.add(root);
				
		while(true){
			
			int nodeCount = treeQueue.size();
			if(nodeCount == 0){
				break;
			}
			
			while(nodeCount > 0){
				NodeLab3 node = treeQueue.peek();
				System.out.print(node.value + " ");
				treeQueue.remove();
				
				if(node.left != null){
					treeQueue.add(node.left);
				}
				if(node.right != null){
					treeQueue.add(node.right);
				}
				nodeCount--;
				
			}
		}
		
	}





	public static NodeLab3 searchNode(NodeLab3 root, char inputChar) {
		
		if(root.value == inputChar){
			foundNode = root;
			return foundNode;
		}
		
		if(root.left != null && foundNode == null){
			searchNode(root.left, inputChar);
		}
		if(root.right != null && foundNode == null){
			searchNode(root.right, inputChar);
		}
		
		
		return foundNode;
		
	}


	public static NodeLab3 createTree(NodeLab3 root, String input) {
		
		index++;
		
		if(root == null && input.charAt(index) != '(' &&input.charAt(index) != ')'){
			root = new NodeLab3(input.charAt(index));
			index++;
		}
		
		if(input.charAt(index) == ')'){
			index++;
			return root;
		}
		
		if(index <= input.length() && input.charAt(index) == '(' && root.left == null){
			root.left = createTree(root.left, input);
		}
		
		if(index <= input.length() && input.charAt(index) == '(' && root.right == null){
			root.right = createTree(root.right, input);
		}
		index++;
		return root;
		
	}
	

	public static void printInline(NodeLab3 root) {
		
		if(root == null){
			return;
		}
		
		printInline(root.left);
		System.out.print(root.value + " ");
		printInline(root.right);

		
		
	}

}
