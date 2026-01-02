package dataStructuresAndAlgo.LinearDataStructures;

class SortedList<T extends Comparable<T>> extends SingleLinkedList<T> {

	private boolean isReversed() {
		return this.first.data.compareTo(this.last.data) > 0;
	}

	@Override
	public void put(T data) {
		SingleLinked<T> node = new SingleLinked<>(data);
		if (isEmpty()) {
			this.first = node;
			this.last = node;
			this.size++;
		} else {
			SingleLinked<T> current = this.first;
			while (current.next != null) {
				if (current.next.data.compareTo(node.data) < 0 && !isReversed())
					current = current.next;
				else if (current.next.data.compareTo(node.data) > 0 && isReversed())
					current = current.next;
				else
					break;
			}
			connect(current, node);
		}
	}

	public boolean isEmpty() {
		return (this.first == null);
	}

	public T deleteMin() {
		T data;
		if (isReversed()) {
			data = this.last.data;
			delete(size());
			return data;
		}
		data = this.first.data;
		delete(1);
		return data;

	}

	public T deleteMax() {
		T data;
		if (isReversed()) {
			data = this.first.data;
			delete(1);
			return data;
		}
		data = this.last.data;
		delete(size());
		return data;

	}

	private void connect(SingleLinked<T> current, SingleLinked<T> node) {
		if (current.data.compareTo(node.data) > 0 && current.equals(this.first) && !isReversed()) {
			node.next = this.first;
			this.first = node;
			this.size++;
		} else if (current.data.compareTo(node.data) < 0 && current.equals(this.first) && isReversed()) {
			node.next = this.first;
			this.first = node;
			this.size++;
		} else if (current.next == null) {
			current.next = node;
			this.last = node;
			this.size++;
		} else {
			node.next = current.next;
			current.next = node;
			this.size++;
		}
	}

}
