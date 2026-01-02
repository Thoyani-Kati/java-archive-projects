package dataStructuresAndAlgo.non_LinearDataStructures;

import java.io.IOException;

public class AVLTree<T extends Comparable<T>> extends binarySearchTree<T> {

	private int balanceFactor(treeNode<T> node) {
		return node != null ? height(node.left) - height(node.right) : 0;
	}

	private treeNode<T> insertRecursively(treeNode<T> current, T data) {
		if (current == null)
			return new treeNode<>(data);
		else if (data.compareTo(current.data) < 0)
			current.left = insertRecursively(current.left, data);
		else if (data.compareTo(current.data) > 0)
			current.right = insertRecursively(current.right, data);
		return isBalanced(current) ? current : rotate(current);
	}

	@Override
	public void insert(T data) {
		this.root = insertRecursively(this.root, data);
	}

	public treeNode<T> rotate(treeNode<T> node) {
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

	public boolean isBalanced(treeNode<T> node) {
		return node != null ? Math.abs(balanceFactor(node)) <= 1 : false;
	}

	public treeNode<T> right(treeNode<T> node) {
		treeNode<T> temp = null;
		if (node != null) {
			temp = node.left;
			node.left = temp.right;
			temp.right = node;
		}
		return temp;
	}

	public treeNode<T> left(treeNode<T> node) {
		treeNode<T> temp = null;
		if (node != null) {
			temp = node.right;
			node.right = temp.left;
			temp.left = node;
		}
		return temp;
	}

	public treeNode<T> delete(treeNode<T> current, T data) throws IOException {
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

				} else // ArrayList<>()
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
		return isBalanced(current) ? current : rotate(current);
	}

	@Override
	public void remove(T data) throws IOException {
		System.out.print(find(this.root, data) != null ? "\u001B[3m\u001B[4m" + data + "\u001B[0m was Deleted"
				: "\u001B[31m\u001B[4m" + data + "\u001B[0m was not found! ,henced Not Deleted");
		delete(this.root, data);
	}
}
