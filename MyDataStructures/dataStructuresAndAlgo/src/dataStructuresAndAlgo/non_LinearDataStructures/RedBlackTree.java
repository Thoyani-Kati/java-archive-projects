package dataStructuresAndAlgo.non_LinearDataStructures;

import java.io.IOException;

public class RedBlackTree<T extends Comparable<T>> {
	public RBTNode<T> root;

	private class RBTNode<T> {
		public RBTNode<T> left, right;
		public T data;
		public boolean isRed;

		public RBTNode(T data, boolean isRed) {
			this.data = data;
			this.isRed = isRed;
		}
	}
	private RBTNode<T> recolor(RBTNode<T> current) {

		if (current != null) {
			if (current.left != null ? current.left.isRed == true && redChildPresent(current.left) : false) {
				if (current.right != null) {
					current.left.isRed = current.right.isRed = false;
					current.isRed = !current.equals(this.root);
				} else {
					current.left.isRed = false;
					current.isRed = true;
					current = rotate(current);
				}
			} else if (current.right != null ? current.right.isRed == true && redChildPresent(current.right) : false) {
				if (current.left != null) {
					current.left.isRed = current.right.isRed = false;
					current.isRed = !current.equals(this.root);
				} else {
					current.right.isRed = false;
					current.isRed = true;
					current = rotate(current);
				}
			}
		}

		return current;
	}

	protected int height(RBTNode<T> current) {
		return current != null ? Math.max(height(current.left), height(current.right)) + 1 : 0;
	}

	private int balanceFactor(RBTNode<T> node) {
		return node != null ? height(node.left) - height(node.right) : 0;
	}

	public boolean redChildPresent(RBTNode<T> current) {
		return current != null
				? (current.left != null ? current.left.isRed == true : false)
						|| (current.right != null ? current.right.isRed == true : false)
				: false;
	}

	public boolean isBalanced(RBTNode<T> node) {
		return node != null ? Math.abs(balanceFactor(node)) <= 1 : false;
	}

	public void insert(T data) {
		this.root = insertRecursively(this.root, data);
	}

	private RBTNode<T> insertRecursively(RBTNode<T> current, T data) {
		if (current == null)
			return this.root == null ? new RBTNode<>(data, false) : new RBTNode<>(data, true);

		else if (data.compareTo(current.data) < 0)
			current.left = insertRecursively(current.left, data);

		else if (data.compareTo(current.data) > 0)
			current.right = insertRecursively(current.right, data);
		return recolor(current);
	}

	public RBTNode<T> rotate(RBTNode<T> node) {
		if (node != null ? !isBalanced(node) : false) {
			if (balanceFactor(node) > 0) {
				if (node.left.left != null)
					node = right(node);
				else
					node.left = left(node.left);

			} else if (balanceFactor(node) < 0) {
				if (node.right.right != null)
					node = left(node);
				else
					node.right = right(node.right);
			}
			node = rotate(node);
		}
		return node;
	}

	public RBTNode<T> right(RBTNode<T> node) {
		RBTNode<T> temp = null;
		if (node != null) {
			temp = node.left;
			node.left = temp.right;
			temp.right = node;
		}
		return temp;
	}

	public RBTNode<T> left(RBTNode<T> node) {
		RBTNode<T> temp = null;
		if (node != null) {
			temp = node.right;
			node.right = temp.left;
			temp.left = node;
		}
		return temp;
	}

	public void inOrderDisplay() throws IOException {// wrapper for inOrder (private method)
		inOrder(this.root);
	}

	private void inOrder(RBTNode<T> current) throws IOException {
		if (current != null) {
			inOrder(current.left);
			printData(current);
			inOrder(current.right);
		}
	}

	public void printData(RBTNode<T> current) {
		if (current == null)
			System.out.print("\u001B[4m\u001B[3m\u001B[36m" + "None" + "\u001B[0m ");
		else if (current == this.root)
			System.out.print("\u001B[31m\u001B[40m" + current.data + "\u001B[0m ");
		else if (isRoot(current) && !current.equals(this.root))
			if (current.isRed == true)
				System.out.print("\u001B[32m\u001B[41m" + current.data + "\u001B[0m ");
			else
				System.out.print("\u001B[32m\u001B[40m" + current.data + "\u001B[0m ");
		else if (current.isRed == true)
			System.out.print("\u001B[33m\u001B[41m" + current.data + "\u001B[0m ");
		else
			System.out.print("\u001B[33m\u001B[40m" + current.data + "\u001B[0m ");
	}

	private boolean isRoot(RBTNode<T> node) {
		return node != null ? (node.left != null || node.right != null) : false;

	}

	private RBTNode<T> getMin(RBTNode<T> current) throws IOException {
		return current != null ? current.left != null ? getMin(current.left) : current : current;
	}

	private RBTNode<T> getMax(RBTNode<T> current) throws IOException {
		return current != null ? current.right != null ? getMax(current.right) : current : current;
	}

	protected RBTNode<T> findSuccessor(RBTNode<T> current, T data) throws IOException {
		RBTNode<T> node = find(current, data);
		return node != null ? getMin(node.right) : node;
	}

	protected RBTNode<T> find(RBTNode<T> current, T data) {
		if (current != null && current.data != data)
			current = data.compareTo(current.data) < 0 ? find(current.left, data) : find(current.right, data);
		return current;

	}

	protected RBTNode<T> swap(RBTNode<T> node, RBTNode<T> successor) {
		successor.left = node.left;
		successor.right = node.right;
		return successor;
	}

	private RBTNode<T> delete(RBTNode<T> current, T data) throws IOException {
		RBTNode<T> successor = null;
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
		return recolor(current);
	}

	public void remove(T data) throws IOException {
		System.out.print(find(this.root, data) != null ? "\u001B[3m\u001B[4m" + data + "\u001B[0m was Deleted"
				: ("\u001B[31m\u001B[4m" + data + "\u001B[0m was not found! ,henced Not Deleted"));
		delete(this.root, data);
	}
}
