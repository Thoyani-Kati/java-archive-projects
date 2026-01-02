package dataStructuresAndAlgo.LinearDataStructures;

public class LinkedPriorityQueue<T extends Comparable<T>> extends SortedList<T> {

	public void remove() {
		if (!isEmpty())
			delete(1);

	}

}