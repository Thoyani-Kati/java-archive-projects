package dataStructuresAndAlgo.LinearDataStructures;

public class DoubleLinkedList<T> {

	public DoubleLinked<T> first;
	public DoubleLinked<T> last;

	public void put(T data) {
		DoubleLinked<T> node = new DoubleLinked<>(data);
		if (this.first == null) {
			this.first = node;
			this.last = node;
		} else {
			DoubleLinked<T> current = this.first;
			while (current.right != null) {
				current = current.right;
			}
			current.right = node;
			node.left = current;
			this.last = node;
		}

	}

	public void insertRight(T data) {
		DoubleLinked<T> node = new DoubleLinked<>(data);
		this.last.right = node;
		node.left = this.last;
		this.last = node;
	}

	public void insertLeft(T data) {
		DoubleLinked<T> node = new DoubleLinked<>(data);
		this.first.left = node;
		node.right = this.first;
		this.first = node;
	}

	public void delete(T data) {
		DoubleLinked<T> node = get(data);
		if (node == null) {
			System.out.println("\nDeletion of - " + data + " Failed(Does not exist In the List!).");
			return;
		}
		node.left.right = node.right;
		node.right.left = node.left;
		node.right = node.left = null;// cut it off the list completely

	}

	public void delete(int position) {
		DoubleLinked<T> head = this.first;
		if (position > size()) {
			System.out.println("\nDeletion at position - " + position + " Failed(positionNotFound!)."); //$NON-NLS-1$ //$NON-NLS-2$
		} else {

			if (position == 1) {
				this.first = this.first.right;
				if (this.first != null)
					this.first.left = null;
			} else if (position == size()) {
				DoubleLinked<T> node = this.last.left;
				this.last.left = null;
				this.last = node;
				this.last.right = null;
			} else {
				int count = 1;
				while (count < position - 1) {
					head = head.right;
					count++;
				}
				head.right = head.right.right;
				head.right.left = head;
			}

		}

	}

	public int size() {
		DoubleLinked<T> head = this.first;
		int count = 0;
		if (head == null)
			return count;
		while (head != null) {
			head = head.right;
			count++;
		}
		return count;
	}

	public void display() {
		DoubleLinked<T> current = this.first;
		while (current != null) {
			if (current == this.first)
				System.out.print("\u001B[32m" + current.data + "\u001B[0m <---> ");
			else if (current.right == null)
				System.out.print("\u001B[31m" + current.data + "\u001B[0m ");

			else
				System.out.print("\u001B[33m" + current.data + "\u001B[0m <---> ");
			current = current.right;
		}
		System.out.println();
	}

	public void displayBackward() {
		DoubleLinked<T> current = this.last;
		while (current != null) {
			if (current == this.last)
				System.out.print("\u001B[32m" + current.data + "\u001B[0m <---> ");
			else if (current.left == null)
				System.out.print("\u001B[31m" + current.data + "\u001B[0m ");

			else
				System.out.print("\u001B[33m" + current.data + "\u001B[0m <---> ");
			current = current.left;
		}
		System.out.println();
	}

	public void reverse() {
		DoubleLinked<T> head = this.first, current = head.right, temp = current;
		head.right = null;
		this.last = this.first;
		while (current != null) {
			current = current.right;
			temp.right = head;
			head.left = temp;
			head = temp;
			temp = current;
		}
		this.first = head;

	}

	public DoubleLinked<T> get(T data) {
		DoubleLinked<T> startOfList = this.first, endOfList = last, node = null;
		while (startOfList != null && endOfList != null ? startOfList != endOfList : false) {
			if (startOfList.data.equals(data)) {
				node = startOfList;
				break;
			} else if (endOfList.data.equals(data)) {
				node = endOfList;
				break;
			}
			startOfList = startOfList.right;
			endOfList = endOfList.left;
		}
		return node;

	}

	public boolean isEmpty() {
		return this.first == null;
	}

}
