package dataStructuresAndAlgo.LinearDataStructures;


public class SingleLinkedList<T> extends singleLinkedStructures<T> {

	public SingleLinked<T> first, last;
	protected int size;
	private class SingleLinked<T> {
		public T data; // data item
		public SingleLinked<T> next; // next link in list

		public SingleLinked(T data) {
			this.data = data;
		}
	}

	@Override
	public void reverse() {
		SingleLinked<T> head = this.first, current = head.next, temp = current;
		head.next = null;
		this.last = head;
		while (current != null) {
			current = current.next;
			temp.next = head;
			head = temp;
			temp = current;
		}

		this.first = head;
	}

	@Override
	public void put(T data) {
		SingleLinked<T> node = new SingleLinked<>(data);
		if (this.first == null) {
			this.first = node;
			this.last = node;
			this.size++;
		} else {
			SingleLinked<T> current = this.first;
			while (current.next != null) {
				current = current.next;
			}
			current.next = node;
			this.last = node;
			this.size++;
		}

	}

	void makeCycle() {
		SingleLinked<T> head = this.first;
		int count = 1;
		while (count < 4) {
			head = head.next;
			count++;
		}
		this.last.next = head;
	}

	public boolean hasCycle() {// My algorithm(to detect a cycle) is not yet validated to work for all cases
								// given its conditions are satisfied
		SingleLinked<T> slow = this.first;// moves one step
		// SingleLinked<T> fast = this.first ;//moves 2 steps
		while (slow != null) {
//			fast = fast.next.next;
			if (slow == this.last.next)
				return true;
			slow = slow.next;
		}
		return false;

	}

	@Override
	public void display() {
		SingleLinked<T> current = this.first;// note "this/calling object" is a dummy node

		while (current != null) {
			if (current == this.first)
				System.out.print("\u001B[32m" + current.data + "\u001B[0m ---> ");
			else if (current.next == null)
				System.out.print("\u001B[31m" + current.data + "\u001B[0m ---> ");

			else
				System.out.print("\u001B[33m" + current.data + "\u001B[0m ---> ");
			current = current.next;
		}
		System.out.print("null\n"); //$NON-NLS-1$
	}

	@Override
	public void insert(T data, int position) {
		SingleLinked<T> node = new SingleLinked<>(data);
		if (position > this.size + 1) {
			System.out.println("\nInsertion at position - " + position + " Failed(positionNotFound!)."); //$NON-NLS-1$ //$NON-NLS-2$
		} else {
			if (position == 1) {
				node.next = this.first;
				this.first = node;
				this.size++;
			} else if (position == this.size + 1) {
				this.last.next = node;
				this.last = node;
				this.size++;

			} else {
				int count = 1;
				SingleLinked<T> current = this.first;
				while (count < position - 1) {
					current = current.next;
					count++;
				}
				SingleLinked<T> nextNode = current.next;
				current.next = node;
				node.next = nextNode;
				this.size++;
			}
		}
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public void delete(int position) {
		SingleLinked<T> node;
		if (position > this.size + 1 || position < 0) {
			System.out.println("\nDeletion at position - " + position + " Failed(positionNotFound!).");

		}
		if (position == 1) {
			node = this.first;
			this.first = this.first.next;
			this.size--;

		}
		int count = 1;
		SingleLinked<T> current = this.first;
		while (count < position - 1) {
			current = current.next;
			count++;
		}
		if (current.next.equals(this.last)) {
			node = current.next;
			current.next = current.next.next;
			this.last = current;
			this.size--;

		}
		node = current.next;
		current.next = current.next.next;
		this.size--;

	}

	public T getDataAt(int position) {
		if (position > this.size + 1 || position < 0) {
			System.out.println("\nDeletion at position - " + position + " Failed(positionNotFound!).");
			return null;
		}
		SingleLinked<T> current = first;
		while (--position > 0)
			current = current.next;
		return current.data;

	}

	public SingleLinked<T> get(T data) {
		// TODO Auto-generated method stub
		return null;
	}

}
