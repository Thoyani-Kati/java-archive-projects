package dataStructuresAndAlgo.non_LinearDataStructures;

import javax.swing.*;
import java.io.IOException;

public class MainTree {
	public static void main(String[] args) {
		// RedBlackTree<Integer> tree2 = new RedBlackTree<>();
		binarySearchTree<Integer> tree2 = new Heap<>(Heap.HeapType.MAX_HEAP);

		try {
//    	    for(int i = 0 ; i<10;i++) {
//    	    	tree.insert(10-i);
//    	    }
			tree2.insert(54);
			tree2.insert(23);
			tree2.insert(89);
			tree2.insert(67);
			tree2.insert(65);
			tree2.insert(93);
			tree2.insert(21);
			tree2.insert(33);
			// tree2.insert(60,false);//tree2.insert();
			System.out.println();
			tree2.inOrderDisplay();
			System.out.println("\n");
			// tree2.remove(54);
			// System.out.println("\n" + tree2.getKthSmall(9).data);

		} catch (IOException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "This is your error :" + e.getMessage());
		}
		;
	}
}
