package dataStructuresAndAlgo.LinearDataStructures;

public class LinkedQueue<T> extends DoubleLinkedList<T> {
	public DoubleLinked<T> dequeue() {
		DoubleLinked<T> node = super.first;
		super.delete(1);
		return node;
	}

}
