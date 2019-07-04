import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

class Node {
	String value;
	Node left, right;

	Node(String value) {
		this.value = value;
		left = null;
		right = null;

	}
}

public class Lab7 {
	private static Node root, foundNode = null, parentNode = null;
	private static Map<String, String> listOfNotFound = new LinkedHashMap<String, String>();
	private static String output = "";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Integer noOfDataSets = Integer.parseInt(sc.nextLine());

		for (int i = 0; i < noOfDataSets; i++) {
			String[] inputArray = sc.nextLine().split(" ");
			createTree(inputArray);

		}

		Iterator<Map.Entry<String, String>> it = listOfNotFound.entrySet()
				.iterator();

		while (it.hasNext()) {

			Map.Entry<String, String> pair = it.next();
			String[] inputArray = new String[2];
			inputArray[0] = pair.getKey();
			inputArray[1] = pair.getValue();
			createTree(inputArray);
			
			if(foundNode != null){
				it.remove();
			}
		}

		//printInline(root);

		Integer noOfRelation = Integer.parseInt(sc.nextLine());

		for (int i = 0; i < noOfRelation; i++) {
			String[] inputArray = sc.nextLine().split(" ");
			String node1 = inputArray[0];
			String relation = inputArray[1];
			String node2 = inputArray[2];
			checkRelation(node1, relation, node2, root);
		}

		System.out.println(output.trim());

		sc.close();

	}

	public static void checkRelation(String node1, String relation,
			String node2, Node root) {

		if (relation.trim().equalsIgnoreCase("child")) {
			foundNode = null;
			Node parentNode = searchNode(node2, root);

			if ((parentNode.left != null && parentNode.left.value
					.equalsIgnoreCase(node1))
					|| (parentNode.right != null && parentNode.right.value
							.equalsIgnoreCase(node1))) {
				output = output + "T ";
			} else {
				output = output + "F ";
			}
		}

		else if (relation.trim().equalsIgnoreCase("descendant")) {
			foundNode = null;
			parentNode = null;

			Node found1Node = searchNode(node2, root);
			foundNode = null;
			parentNode = null;

			Node isDescendantNode = searchNode(node1, found1Node);
			
			if (isDescendantNode != null) {
				output = output + "T ";
			} else {
				output = output + "F ";
			}

		}

		else if (relation.trim().equalsIgnoreCase("ancestor")) {
			
			foundNode = null;
			parentNode = null;

			Node found1Node = searchNode(node1, root);
			foundNode = null;
			parentNode = null;

			Node isDescendantNode = searchNode(node2, found1Node);

			if (isDescendantNode != null) {
				output = output + "T ";
			} else {
				output = output + "F ";
			}
		}

		else if (relation.trim().equalsIgnoreCase("sibling")) {

			foundNode = null;
			parentNode = null;
			Node parentNode1 = findParentNode(node1, root);
			foundNode = null;
			parentNode = null;
			Node parentNode2 = findParentNode(node2, root);


			if (parentNode1.value.equalsIgnoreCase(parentNode2.value)) {
				output = output + "T ";
			} else {
				output = output + "F ";
			}
		}
		else if(relation.trim().equalsIgnoreCase("parent")){
			
			foundNode = null;
			parentNode = null;
			Node parentNode1 = findParentNode(node2, root);
			
			if(node1.equalsIgnoreCase(parentNode1.value)){
				output = output + "T ";
			} else {
				output = output + "F ";
			}
			
		}

	}

	public static Node findParentNode(String node, Node root) {

		if (node.equals(root.value)) {
			foundNode = root;
			return foundNode;
		}

		if (root.left != null && foundNode == null) {
			findParentNode(node, root.left);

			if (foundNode != null && parentNode == null) {
				//System.out.println("root !!" + root.value);
				parentNode = root;
			}
		}
		if (root.right != null && foundNode == null) {
			findParentNode(node, root.right);

			if (foundNode != null && parentNode == null) {
				//System.out.println("root !!" + root.value);
				parentNode = root;
			}
		}
		return parentNode;
	}

	public static void createTree(String[] inputArray) {
		foundNode = null;

		if (root == null) {
			root = new Node(inputArray[0].trim());
			root.left = new Node(inputArray[1].trim());
			return;

		}

		Node tempNode = searchNode(inputArray[0].trim(), root);

		if (tempNode == null) {
			listOfNotFound.put(inputArray[0].trim(), inputArray[1].trim());
		}

		else {
			if (tempNode.left == null) {
				tempNode.left = new Node(inputArray[1].trim());
			} else if (tempNode.right == null) {
				tempNode.right = new Node(inputArray[1].trim());
			}
		}

	}

	public static Node searchNode(String searchNode, Node root) {

		if (searchNode.equals(root.value)) {
			foundNode = root;
			return foundNode;
		}

		if (root.left != null && foundNode == null) {
			searchNode(searchNode, root.left);
		}
		if (root.right != null && foundNode == null) {
			searchNode(searchNode, root.right);
		}
		return foundNode;
	}

	public static void printInline(Node root) {

		if (root == null) {
			return;
		}

		printInline(root.left);
		System.out.print(root.value + " ");
		printInline(root.right);

	}

}
