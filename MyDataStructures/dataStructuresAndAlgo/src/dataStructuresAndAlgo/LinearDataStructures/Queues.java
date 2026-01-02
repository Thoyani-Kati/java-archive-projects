package dataStructuresAndAlgo.LinearDataStructures;

import java.util.Random;

public class Queues {
	public static void main(String[] args) {
		Random rand = new Random();
		LinkedPriorityQueue<Integer> queue = new LinkedPriorityQueue<>();
		for (int i = 0; i < 10; i++) {
			int n = rand.nextInt(0, 100);
			queue.put(n);
		}

		queue.display();
		queue.remove();
		queue.display();
		queue.reverse();
		queue.display();
		queue.remove();

		queue.display();

	}
}
