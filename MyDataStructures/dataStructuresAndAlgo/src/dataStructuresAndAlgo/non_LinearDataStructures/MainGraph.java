package dataStructuresAndAlgo.non_LinearDataStructures;

public class MainGraph {

	public static void main(String[] args) {
		UndirectedGraph<Character> graph = new UndirectedGraph<>();

		graph.addEdge('A', 'B');
		graph.addEdge('C', 'B');
		graph.addEdge('C', 'D');
		graph.addEdge('C', 'E');
		graph.addEdge('E', 'F');
		graph.addEdge('E', 'G');
		graph.addEdge('H', 'E');
		graph.addEdge('B', 'H');

		DirectedAcyclicGraph<Character> graph2 = new DirectedAcyclicGraph<>();
		graph2.addEdge('A', 'B');
		graph2.addEdge('C', 'B');
		graph2.addEdge('C', 'D');
		graph2.addEdge('C', 'E');
		graph2.addEdge('E', 'F');
		graph2.addEdge('E', 'G');
		graph2.addEdge('H', 'E');
		graph2.addEdge('B', 'H');
		graph2.addEdge('D', 'D');

		System.out.println("\n" + (char) (9964) + " \u001B[4mDEPTH-FIRST TRAVERSAL\u001B[0m\n");
		graph2.DFSTraversal();

		// System.out.println("\n" + (char) (9964) + " \u001B[4mBREATH-FIRST
		// TRAVERSAL\u001B[0m\n");
		// graph2.BFSTraversal();

	}

}
