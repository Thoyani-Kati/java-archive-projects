package dataStructuresAndAlgo.LinearDataStructures;

abstract class singleLinkedStructures<T> {
	abstract void display();

	abstract void reverse();

	abstract int size();

	abstract void put(T data);

	abstract void delete(int position);

	abstract void insert(T data, int position);
}