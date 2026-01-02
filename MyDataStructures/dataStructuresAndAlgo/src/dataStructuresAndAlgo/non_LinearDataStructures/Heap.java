package dataStructuresAndAlgo.non_LinearDataStructures;

public class Heap<T extends Comparable<T>> extends binarySearchTree<T> {
	public static enum HeapType {
		MIN_HEAP, MAX_HEAP
	}

	private HeapType type;

	public Heap(HeapType type) {
		this.type = type;
	}

	// @Override
	private treeNode<T> insertRecursively(treeNode<T> current, T data) {
		if (current == null)
			return new treeNode<>(data);
		if (current.right != null)
			current.left = insertRecursively(current.left, data);
		else if (current.left != null)
			current.right = insertRecursively(current.right, data);
		else
			current.left = insertRecursively(current.left, data);
		return Heapify(current);
	}

	@Override
	public void insert(T data) {
		this.root = insertRecursively(this.root, data);

	}

	private treeNode<T> Heapify(treeNode<T> current) {
		if (current != null) {
			T temp = null;
			if (this.type.equals(HeapType.MAX_HEAP)) {
				if (current.left != null ? current.left.data.compareTo(current.data) > 0 : false) {
					temp = current.data;
					current.data = current.left.data;
					current.left.data = temp;

				}

				if (current.right != null ? current.right.data.compareTo(current.data) > 0 : false) {
					temp = current.data;
					current.data = current.right.data;
					current.right.data = temp;

				}
			} else if (this.type.equals(HeapType.MIN_HEAP)) {

				if (current.left != null ? current.left.data.compareTo(current.data) < 0 : false) {
					temp = current.data;
					current.data = current.left.data;
					current.left.data = temp;

				}

				if (current.right != null ? current.right.data.compareTo(current.data) < 0 : false) {
					temp = current.data;
					current.data = current.right.data;
					current.right.data = temp;

				}
			}

		}
		return current;

	}

}
