package dataStructuresAndAlgo.LinearDataStructures;

public class Stacks {
	public static void main(String[] args) {

		TwoStack<Integer> stack = new TwoStack<>(10);
		// LinkedStack<Integer> stack = new LinkedStack<>();

		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		stack.push(7);
		stack.push(8);
		stack.push(9);
		stack.push(0);

		stack.display();
		System.out.println();
		System.out.println(stack.pop(1) + " was popped off stack!");

		stack.display();

	}

}
