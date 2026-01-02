package dataStructuresAndAlgo.non_LinearDataStructures;

import LinearDataStructures.DoubleLinked;
import LinearDataStructures.DoubleLinkedList;
import LinearDataStructures.LinkedQueue;

public class UndirectedGraph<T> {
	public DoubleLinkedList<Vertex<T>> vList;

	public UndirectedGraph() {
		this.vList = new DoubleLinkedList<>();
	}

	public void connectVertex(Vertex<T> v1, Vertex<T> v2, T data) {

		if (v1 == null) {
			v1 = new Vertex<>(data);
			this.vList.put(v1);
		}
		v1.neighbors.put(v2);
		v2.neighbors.put(v1);
	}

	public void addEdge(T data1, T data2) {
		Vertex<T> v1 = get(this.vList, data1), v2 = get(this.vList, data2);
		if (v1 != null) {

			if (get(v1.neighbors, data2) == null) {
				connectVertex(v2, v1, data2);

			} else
				System.out.println("DuplicateException : Duplicates are not allowed ( " + data1 + " , " + data2 + " )");

		} else if (v2 != null) {
			if (get(v2.neighbors, data1) == null) {
				connectVertex(v1, v2, data1);

			} else
				System.out.println("DuplicateException : Duplicates are not allowed ( " + data1 + " , " + data2 + " )");
		} else {
			v1 = new Vertex<>(data1);
			v2 = new Vertex<>(data2);
			this.vList.put(v1);
			this.vList.put(v2);
			v1.neighbors.put(v2);
			v2.neighbors.put(v1);

		}
	}

	private void DFS(DoubleLinked<Vertex<T>> current) {
		if (current != null) {
			if (!current.data.isVisited) {
				System.out.println(" Vertex [ " + current.data.value + " ] has deg(" + current.data.value + ") = "
						+ current.data.neighbors.size());
				current.data.isVisited = true;
				DFS(current.data.neighbors.first);
			}
			DFS(current.right);

		}
		return;// Note this is for readability ,otherwise it is not necessary as it can be done
				// implicitly

	}

	private void BFS(Vertex<T> vertex) {// O(V+E)
		LinkedQueue<Vertex<T>> vertexes = new LinkedQueue<>();
		DoubleLinked<Vertex<T>> current = null;
		vertexes.put(vertex);
		while (true) {

			if (!vertex.isVisited) {
				System.out.println(
						" Vertex [ " + vertex.value + " ] has deg(" + vertex.value + ") = " + vertex.neighbors.size());
				vertex.isVisited = true;
				current = vertex.neighbors.first;
			}

			if (current != null) {
				if (!current.data.isVisited)// only queue unvisited nodes only
					vertexes.put(current.data);
				current = current.right;
			} else {
				if (vertexes.isEmpty())
					break;
				vertex = vertexes.dequeue().data;
			}

		}

	}

	public void BFSTraversal() {
		BFS(vList.first.data);
	}

	public void DFSTraversal() {
		DFS(vList.first);
	}

	public Vertex<T> get(DoubleLinkedList<Vertex<T>> vList, T data) {
		DoubleLinked<Vertex<T>> startOfList = vList.first, endOfList = vList.last;
		Vertex<T> node = null;
		while (startOfList != null && endOfList != null ? startOfList != endOfList : false) {

			if ((startOfList.data).value.equals(data)) {
				node = startOfList.data;
				break;
			} else if ((endOfList.data).value.equals(data)) {
				node = endOfList.data;
				break;
			}
			startOfList = startOfList.right;
			endOfList = endOfList.left;
		}
		return node;

	}

}
