package dataStructuresAndAlgo.LinearDataStructures;
public class DoubleLinked<T> {
	public DoubleLinked<T> left;
	public DoubleLinked<T> right;
	public T data;

	public DoubleLinked(T data) {
		this.data = data;
	}
}
