package dataStructuresAndAlgo.non_LinearDataStructures;


public class DirectedAcyclicGraph<T> extends UndirectedGraph<T> {
	@Override
	public void connectVertex(Vertex<T> v1, Vertex<T> v2, T data2) {
		if (v2 == null) {
			v2 = new Vertex<>(data2);
			this.vList.put(v2);
		}
		v1.neighbors.put(v2);
	}

	@Override
	public void addEdge(T data1, T data2) {
		Vertex<T> v1 = get(this.vList, data1), v2 = get(this.vList, data2);
		if (v1 != null) {
			if (get(v1.neighbors, data2) == null) {
				this.vList.put(v1);
				connectVertex(v1, v2, data2);
			} else
				System.out.println("DuplicateException : Duplicates are not allowed ( " + data1 + " , " + data2 + " )");
		} else {
			v1 = new Vertex<>(data1);
			this.vList.put(v1);
			connectVertex(v1, v2, data2);

		}
	}


}
