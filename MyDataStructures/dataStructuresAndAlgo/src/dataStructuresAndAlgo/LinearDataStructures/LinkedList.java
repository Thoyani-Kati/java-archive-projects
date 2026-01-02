package dataStructuresAndAlgo.LinearDataStructures;

import java.util.Random;

public class LinkedList {
	public static void main(String[] args) {
		Random rand = new Random();
		// Create nodes
		// SortedList<Integer> head = new SortedList<>();
		LinearDataStructures.DoubleLinkedList<Integer> head = new LinearDataStructures.DoubleLinkedList<>();
		// circularLinkedList <Integer> head = new circularLinkedList<>();

		double st, end;
		st = System.currentTimeMillis() / 1000;
		for (int i = 0; i < 10; i++) {
			int n = rand.nextInt(0, 10);
			head.put(n);
		}
		head.display();
		head.put(1);
		head.put(0);
		head.put(7);
		head.put(2);
		head.put(8);
		head.put(4);
		head.put(9);
		head.put(3);
		head.put(5);
		head.put(6);

		System.out.println(head.size());
		head.display();
//			
		head.reverse();
		head.delete(1);
		// head.delete(head.size());
//			head.delete(head.size());
		head.display();
		head.reverse();
		// System.out.println();
		head.put(12);

//			head.insert(66,head.size()+1);
		// head.displayBackward();
//
		// head.reverse();
		// head.makeCycle();
		// System.out.println("It is '"+head.hasCycle()+"' that it has a cyle");

		head.display();

//	       
	}
}