import java.util.Scanner;

class NodeLab4 {
	NodeLab4 left, right;
	Integer value;

	NodeLab4(Integer value) {
		this.value = value;
	}
}

public class Lab4 {

	NodeLab4 root;
	public static boolean avlFlag = true;

	public static void main(String[] args) {
		Lab4 tree = new Lab4();
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine().trim().replace("-1", "").trim();
		String[] inputArrayOld = input.split(" ");

		Integer[] inputArray = new Integer[inputArrayOld.length];

		for (int i = 0; i < inputArrayOld.length; i++) {
			inputArray[i] = Integer.parseInt(inputArrayOld[i]);
		}

		for (int i = 0; i < inputArray.length; i++) {
			tree.root = createBinaryTree(tree.root, inputArray[i]);
		}


		checkAvl(tree.root);
		
		if(avlFlag){
			printPreOrder(tree.root);
		}
		else{
			System.out.print("NOT");
		}
		
		sc.close();

	}

	public static void checkAvl(NodeLab4 root) {
		int leftHeight = 0, rightHeight = 0;
		if(root.left != null && avlFlag){
			leftHeight = findHeight(root.left);
		}
		if(root.right != null && avlFlag){
			rightHeight = findHeight(root.right);
		}
		
		if(Math.abs(leftHeight - rightHeight) > 1){
			avlFlag = false;
			return;
		}
		
		if(root.left != null && avlFlag){
			checkAvl(root.left);
		}
		if(root.right != null && avlFlag){
			checkAvl(root.right);
		}

	}

	public static int findHeight(NodeLab4 root) {
		
		if(root == null){
			return -1;
		}
		
		int leftHeight = findHeight(root.left) + 1;
		int rightHeight = findHeight(root.right) + 1;
		
		if(leftHeight > rightHeight){
			return leftHeight;
		}
		else {		
			return rightHeight;
		}
		
	}

	public static NodeLab4 createBinaryTree(NodeLab4 root, Integer value) {

		if (root == null) {
			root = new NodeLab4(value);
			return root;
		}

		if (value < root.value) {

			if (root.left == null) {
				root.left = createBinaryTree(root.left, value);
			} else {
				createBinaryTree(root.left, value);
			}

		}
		if (value >= root.value) {

			if (root.right == null) {
				root.right = createBinaryTree(root.right, value);
			} else {
				createBinaryTree(root.right, value);
			}

		}
		return root;

	}

	public static void printPreOrder(NodeLab4 root) {
		if (root == null) {
			return;
		}
		System.out.print(root.value + " ");
		printPreOrder(root.left);
		printPreOrder(root.right);

	}

}
