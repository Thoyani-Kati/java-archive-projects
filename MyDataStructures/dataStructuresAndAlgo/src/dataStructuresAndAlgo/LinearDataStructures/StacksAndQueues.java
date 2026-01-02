package dataStructuresAndAlgo.LinearDataStructures;

public class StacksAndQueues {
	public static void main(String[]args) {
		QueueArray<Integer> queue = new QueueArray<>(10);
		
		queue.insert(4);
		queue.insert(8);
		queue.insert(1);
		queue.insert(9);
		queue.insert(5);
		queue.insert(2);
		queue.insert(7);
		queue.insert(1);
		queue.insert(3);
		queue.insert(6);
		queue.insert(30);
		queue.insert(61);
		
		System.out.println("A Queue :\n");
		queue.display();
		System.out.println("\n");
		
		StackArray<Integer> stack = new StackArray<>(10);
		stack.push(4);
		stack.push(8);
		stack.push(1);
		stack.push(9);
		stack.push(5);
		stack.push(2);
		stack.push(7);
		stack.push(1);
		stack.push(3);
		stack.push(6);
		stack.push(21);
		stack.push(72);
		stack.push(11);
		System.out.println("A Stack :\n");
		stack.display();
		System.out.println();
		queue.remove();
		System.out.println(stack.pop()+" & "+stack.pop()+" we popped off stack respectively");queue.remove();
		queue.remove();
//		stack.pop();queue.remove();
//		stack.pop();queue.remove();queue.remove();queue.remove();queue.remove();queue.remove();
		queue.insert(7);
		queue.insert(97);
		queue.insert(90);
		
		System.out.println("\u001B[3m\u001B[4mA Queue :\u001B[0m\n");
		queue.display();
		System.out.println("\n");
		System.out.println("\u001B[3m\u001B[4mA Stack :\u001B[0m\n");
		stack.display();
//		System.out.println(stack.isEmpty()+" "+stack.getMaxSize()+" "+stack.find(1)+"\nLast In was "+stack.peek()+"\n-----------------------------------------------------------------------");
//		stack.pop();stack.pop();stack.pop();stack.pop();stack.pop();stack.pop();
//		System.out.println("Stack after removing 6 items");
//		//stack.push(3);
		//stack.display();
		
	}

}
