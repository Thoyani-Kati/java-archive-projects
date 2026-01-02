package dataStructuresAndAlgo.non_LinearDataStructures;

import java.io.IOException;
import java.util.Scanner;

class calculator {
	String str;
	public AVLTree<String> tree = new AVLTree<>() {

		@Override
		public void insert(String str) {
			this.root = insertRec(this.root, str);
		}

		private treeNode<String> insertRec(treeNode<String> current, String data) {
			if (current == null)
				return new treeNode<>(data);
			current.left = insertRec(current.left, data);
			return isBalanced(current) ? current : rotate(current);
		}

	};

	private void getEquation(Scanner inputScn) {

		System.out.print("To convect to -POSTINFIX-Notation-\nEnter your -INFIX-Notation- : ");
		this.str = inputScn.nextLine();
		String[] arr = this.str.split("");

		String str1 = "";
		int n = arr.length;
		for (int i = n - 1; i >= 0; i--) {
			str1 += arr[i];
			if ("*+/-".contains(arr[i != 0 ? i - 1 : i])) {
				this.tree.insert(str1);
				str1 = "";
			}
		}

	}

	public void calculate(Scanner scn) {
		try {
			getEquation(scn);
			readEquation(this.tree.root);
			System.out.println(this.str + " = " + this.tree.root.data);
			tree.root = null;
			System.out.println("Continue ? : ");
			String ans = scn.nextLine();
			if (ans.equalsIgnoreCase("n"))
				return;
			calculate(scn);
		} catch (IOException e) {
			e.getStackTrace();
		}

	}

	private void readEquation(treeNode<String> current) throws IOException {

		if (current != null) {
			readEquation(current.left);// Traverse left subtree first
			readEquation(current.right);// then traverse right subtree as you return from the left subtree
			if (tree.isRoot(current))
				performCalculation(current);
			// process the data <of course you will start with left's data followed by
			// right's,then root's>

		}
	}

	private treeNode<String> performCalculation(treeNode<String> current) throws IOException {
		int leftChild = Integer.parseInt(current.left.data);
		int rightChild = Integer.parseInt(current.right.data);

		switch (current.data) {
		case "+":
			current.data = (leftChild + rightChild) + "";

			return current;
		case "*":
			current.data = (leftChild * rightChild) + "";

			return current;
		case "/":
			current.data = (leftChild / rightChild) + "";

			return current;
		case "-":
			current.data = (leftChild - rightChild) + "";

			return current;
		default:
			System.out.println("InvalidnOperation!");

		}
		return current;

	}

	public void ToPostInfix() throws IOException {
		this.tree.postOrderDisplay();

	}
}

public class Application {
	public static void main(String[] args) {
		calculator Calculator = new calculator();
		Scanner scn = new Scanner(System.in);
		try {
			Calculator.ToPostInfix();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Calculator.calculate(scn);
		scn.close();
	}

}
