package dataStructuresAndAlgo.non_LinearDataStructures;

import java.io.IOException;

public class binarySearchTree<T extends Comparable<T>> {
	public treeNode<T> root;

	private int k;

	private treeNode<T> findParent(treeNode<T> current, treeNode<T> node) {
		if (current != null) {
			if (current.left != null ? current.left.data.compareTo(node.data) == 0 : false)
				return current;
			else if (current.right != null ? current.right.data.compareTo(node.data) == 0 : false)
				return current;
			current = node.data.compareTo(current.data) < 0 ? findParent(current.left, node)
					: findParent(current.right, node);
		}
		return current;
	}

	public int depth(treeNode<T> current, treeNode<T> node) {
		return (current.data.compareTo(node.data) == 0) ? 0
				: ((node.data.compareTo(current.data) < 0) ? depth(current.left, node) : depth(current.right, node))
						+ 1;

	}

	public int getDepth(T data) {
		treeNode<T> node = find(this.root, data);
		return node != null && this.root != null ? depth(this.root, node) : 0;
	}

	public void insert(T data) {
		this.root = insertRecursively(this.root, data);
	}

	public int getHeight() {
		return height(this.root);
	}

	private treeNode<T> insertRecursively(treeNode<T> current, T data) {
		if (current == null)
			return new treeNode<>(data);
		else if (data.compareTo(current.data) < 0)
			current.left = insertRecursively(current.left, data);
		else if (data.compareTo(current.data) > 0)
			current.right = insertRecursively(current.right, data);
		return current;
	}

	protected int height(treeNode<T> current) {
		return current != null ? Math.max(height(current.left), height(current.right)) + 1 : 0;
	}

	public treeNode<T> getLCA(T data1, T data2) throws IOException {
		return findLCA(this.root, min(data1, data2), max(data1, data2));
	}

	private treeNode<T> findLCA(treeNode<T> current, T minData, T maxData) throws IOException {
		if (current != null) {

			if (current.left != null && current.right != null
					? (find(current.left, minData) != null || find(current.left, maxData) != null)
							&& (find(current.right, minData) != null || find(current.right, maxData) != null)
					: false)
				return current;
			else if (current.data.compareTo(maxData) == 0 ? find(current.left, minData) != null : false)
				return current;

			else if (current.data.compareTo(minData) == 0 ? find(current.right, maxData) != null : false)
				return current;

			current = minData.compareTo(current.data) < 0 && maxData.compareTo(current.data) < 0
					? findLCA(current.left, minData, maxData)
					: findLCA(current.right, minData, maxData);

		}
		return current;
	}

	public boolean isRoot(treeNode<T> current) {
		return current != null ? (current.left != null || current.right != null) : false;

	}

	public void inOrderDisplay() throws IOException {// wrapper for inOrder (private method)
		(new Display()).inOrder(this.root);
	}

	public class Display<T> {

		public void printData(treeNode<?> current) {
			if (current == null)
				System.out.print("\u001B[4m\u001B[3m\u001B[36m" + "None" + "\u001B[0m ");
			else if (current == root)
				System.out.print("\u001B[31m" + current.data + "\u001B[0m ");
			else if (current != null ? (current.left != null || current.right != null) : false && !current.equals(root))
				System.out.print("\u001B[32m" + current.data + "\u001B[0m ");
			else
				System.out.print("\u001B[33m" + current.data + "\u001B[0m ");
		}

		public void inOrder(treeNode<?> current) throws IOException {
			if (current != null) {
				inOrder(current.left);
				printData(current);
				inOrder(current.right);
			}
		}

		public void preOrder(treeNode<?> current) throws IOException {
			if (current != null) {
				printData(current);
				preOrder(current.left);
				preOrder(current.right);
			}

		}

		public void postOrder(treeNode<?> current) throws IOException {
			if (current != null) {
				postOrder(current.left);// Traverse left subtree first
				postOrder(current.right);// then traverse right subtree as you return from the left subtree
				printData(current);// process the data <of course you will start with left's data followed by
									// right's,then root's>
			}
		}
	}
//	public boolean isAVL(treeNode<T> current) {
//		return isBalanced(treeNode<T> current) ;
//	}

	public boolean isBST() {
		return this.root != null
				? this.root.left != null ? this.root.left.data.compareTo(this.root.data) < 0
						: false || this.root.right != null ? this.root.right.data.compareTo(this.root.data) > 0 : false
				: false;
	}

	public treeNode<T> getKthSmall(int k) {

		return this.root != null && ((this.k = k) > 0 && k <= numOfNodes(this.root)) ? kthSmall(this.root) : null;
	}

	private int numOfNodes(treeNode<T> current) {
		return current != null ? (numOfNodes(current.left) + numOfNodes(current.right)) + 1 : 0;
	}

	public treeNode<T> kthSmall(treeNode<T> current) {
		treeNode<T> node = null;
		if (current.left != null && this.k != 0)
			node = kthSmall(current.left);
		if (this.k != 0 ? --this.k == 0 : false)
			return current;
		if (current.right != null && this.k != 0)
			node = kthSmall(current.right);
		return node;
	}

	public void preOrderDisplay() throws IOException {// wrapper for preOrder (private method)
		(new Display()).preOrder(this.root);
	}

	public void postOrderDisplay() throws IOException {// wrapper for postOrder (private method)
		(new Display()).postOrder(this.root);
	}

	public void printSuccessor(T data) throws IOException {
		System.out.print("\nSuccessor of \u001B[3m" + data + "\u001B[0m is ");
		(new Display()).printData(findSuccessor(this.root, data));
	}

	public void printPredecessor(T data) throws IOException {
		System.out.print("\nPredecessor of \u001B[3m" + data + "\u001B[0m is ");
		(new Display()).printData(findPredecessor(this.root, data));
	}

	public treeNode<T> getSuccessor(T data) throws IOException {
		return findSuccessor(this.root, data);
	}

	protected treeNode<T> findSuccessor(treeNode<T> current, T data) throws IOException {
		treeNode<T> node = find(current, data);
		return node != null ? getMin(node.right) : node;
	}

	private treeNode<T> findPredecessor(treeNode<T> current, T data) throws IOException {
		return getMax(find(current, data).left);
	}

	private treeNode<T> getMin(treeNode<T> current) throws IOException {
		return current != null ? current.left != null ? getMax(current.left) : current : current;
	}

	protected treeNode<T> find(treeNode<T> current, T data) {
		if (current != null && current.data != data)
			current = data.compareTo(current.data) < 0 ? find(current.left, data) : find(current.right, data);
		return current;

	}

	private treeNode<T> getMax(treeNode<T> current) throws IOException {
		return current != null ? current.right != null ? getMax(current.right) : current : current;
	}

	protected treeNode<T> swap(treeNode<T> node, treeNode<T> successor) {
		successor.left = node.left;
		successor.right = node.right;
		return successor;
	}

	private treeNode<T> delete(treeNode<T> current, T data) throws IOException {
		treeNode<T> successor = null;
		if (current != null) {
			if (data.equals(this.root.data)) {
				successor = findSuccessor(current, data);
				if (successor != null) {
					delete(current, successor.data);
					current = this.root = swap(current, successor);
				} else
					current = this.root = current.left;

			} else if (current.left != null ? current.left.data.compareTo(data) == 0 : false) {
				successor = findSuccessor(current.left, data);
				if (successor != null) {
					delete(current, successor.data);
					current.left = swap(current.left, successor);

				} else
					current.left = current.left.left;

			} else if (current.right != null ? current.right.data.compareTo(data) == 0 : false) {
				successor = findSuccessor(current.right, data);
				if (successor != null) {
					delete(current, successor.data);
					current.right = swap(current.right, successor);

				} else
					current.right = current.right.left;
			} else
				current = data.compareTo(current.data) < 0 ? delete(current.left, data) : delete(current.right, data);
		}
		return current;
	}

	public void remove(T data) throws IOException {
		System.out.print(find(this.root, data) != null ? "\u001B[3m\u001B[4m" + data + "\u001B[0m was Deleted"
				: ("\u001B[31m\u001B[4m" + data + "\u001B[0m was not found! ,henced Not Deleted"));
		delete(this.root, data);
	}

	private boolean isLeaf(treeNode<T> node) {
		return (node.left == null && node.right == null);
	}

	protected T min(T val1, T val2) {
		return val1.compareTo(val2) > 0 ? val2 : val1;
	}

	protected T max(T val1, T val2) {
		return val1.compareTo(val2) > 0 ? val1 : val2;
	}

	public void minValue() throws IOException {
		System.out.print("\nMin value of this Tree is ");
		(new Display()).printData(getMin(this.root));

	}

	public void maxValue() throws IOException {
		System.out.print("\nMax value of this Tree is ");
		(new Display()).printData(getMax(this.root));

	}
}