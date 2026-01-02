package dataStructuresAndAlgo.non_LinearDataStructures;

import LinearDataStructures.DoubleLinkedList;

public class Vertex<T> {
	public T value;
	public boolean isVisited;
	public DoubleLinkedList<Vertex<T>> neighbors;

	public Vertex(T data) {
		this.value = data;
		this.neighbors = new DoubleLinkedList<>();
	}
}
