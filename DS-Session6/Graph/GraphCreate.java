package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Class to perform operations on graph
 */
public class GraphCreate implements Graph {

	private int numberOfVertices;
	private LinkedList<EdgeAndVertices> listOfEdges[];
	private EdgeAndVertices edge;
	private List<EdgeAndVertices> edges;

	public LinkedList<EdgeAndVertices>[] getListOfEdges() {
		return listOfEdges;
	}

	/**
	 * Constructor to initialize graph with number of vertices and list of edges
	 * 
	 * @param numberOfVertices
	 */
	@SuppressWarnings("unchecked")
	public GraphCreate(int numberOfVertices) {
		this.numberOfVertices = numberOfVertices;

		listOfEdges = new LinkedList[numberOfVertices];

		// Initializing the list of vertices
		for (int i = 0; i < this.numberOfVertices; i++) {
			listOfEdges[i] = new LinkedList<>();
		}
	}

	/**
	 * Function to add edges in graph in case of weighted undirected graph
	 * 
	 * @param source
	 * @param destination
	 * @param weight
	 */
	public void addEdge(int source, int destination, int weight) {
		// source is connected to destination
		edge = new EdgeAndVertices(source, destination, weight);
		listOfEdges[source].addFirst(edge);

		// destination is also connected to source
		edge = new EdgeAndVertices(destination, source, weight);
		listOfEdges[destination].addFirst(edge);
	}

	/**
	 * Function to display the graph
	 */
	public void printGraph() {
		for (int i = 0; i < numberOfVertices; i++) {
			edges = listOfEdges[i];
			edges.forEach(edges -> System.out.println("vertex-"
					+ edges.getVertex1() + " is connected to "
					+ edges.getVertex2() + " with weight " + edges.getWeight()));
		}
	}

	/**
	 * Function to find if graph is connected or not
	 */
	@Override
	public boolean isConnected() {

		if (numberOfVertices <= 0) {
			return false;
		}

		Stack<Integer> stack = new Stack<>();

		// To maintain state of vertex either visited or not
		boolean state[] = new boolean[this.numberOfVertices];

		// iterating through listOfEdges
		for (int i = 0; i < numberOfVertices; i++) {
			if (stack.isEmpty()) {
				edges = listOfEdges[0];
				state[0] = true;
			} else {
				edges = listOfEdges[stack.peek()];
				state[stack.pop()] = true;
			}
			// iterating in linkedlist stored in listOfEdges
			for (int j = 0; j < edges.size(); j++) {
				if (!state[edges.get(j).getVertex2()]) {
					stack.push(edges.get(j).getVertex2());
				}
			}

		}
		// checking vertices status
		for (boolean statecheck : state) {
			if (!statecheck) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Function to display all the reachable nodes from the given vertices
	 */
	@Override
	public List<Integer> reachable(int vertex) {

		if (vertex >= numberOfVertices) {
			throw new AssertionError("Vertex not in graph");
		}
		List<Integer> listOfReachableVertex = new ArrayList<Integer>();
		edges = listOfEdges[vertex];
		for (EdgeAndVertices listOfReachable : edges) {
			listOfReachableVertex.add(listOfReachable.getVertex2());

		}
		if (listOfReachableVertex.size() == 0) {
			return null;
		}
		return listOfReachableVertex;
	}

	/**
	 * Helper function to find the vertex with minimum key value, from the set
	 * of vertices not yet included in MST
	 * 
	 * @param key
	 * @param boolSet
	 * @return
	 */
	int minKey(int key[], Boolean boolSet[]) {
		// Initialize min value
		int min = Integer.MAX_VALUE, min_index = -1;

		for (int vertex = 0; vertex < numberOfVertices; vertex++)
			if (boolSet[vertex] == false && key[vertex] < min) {
				min = key[vertex];
				min_index = vertex;
			}

		return min_index;
	}
	/**
	 * Function to find the minimum spanning tree
	 */
	@Override
	public List<EdgeAndVertices> minimumSpanningTree() {

		List<EdgeAndVertices> minSpanningtree;

		// Array to store constructed Minimum Spanning Tree
		int parent[] = new int[numberOfVertices];

		// Key values used to pick minimum weight edge
		int key[] = new int[numberOfVertices];

		// To represent set of vertices not yet included in Minimum Spanning
		// Tree
		Boolean mstSet[] = new Boolean[numberOfVertices];

		// Initialize all keys as INFINITE
		for (int i = 0; i < numberOfVertices; i++) {
			key[i] = Integer.MAX_VALUE;
		}

		// Always include first vertex in MST.
		key[0] = 0;
		parent[0] = -1;

		// The MST will have numberOfVertices vertices
		for (int count = 0; count < numberOfVertices - 1; count++) {

			// Pick the minimum key vertex from the set of vertices
			// not yet included in MST
			int vertex1 = minKey(key, mstSet);

			// Add the picked vertex to the MST Set
			mstSet[vertex1] = true;

			edges = listOfEdges[vertex1];

			// Update key value and parent index of the adjacent
			// vertices of the picked vertex
			for (int vertex2 = 0; vertex2 < numberOfVertices; vertex2++) {

				for (EdgeAndVertices listEdges : edges) {

					if (listEdges.getVertex2() == vertex2) {

						// Update the key only if weight(vertex1,vertex2) is
						// smaller than
						// key[vertex2]
						if (listEdges.getWeight() != 0 && !mstSet[vertex2] && listEdges.getWeight() < key[vertex2]) {

							parent[vertex2] = vertex1;
							key[vertex2] = listEdges.getWeight();

						}
					}
				}
			}
		}

		// Add the constructed MST to list
		minSpanningtree = new ArrayList<>();

		for (int i = 1; i < numberOfVertices; i++) {
			edges = listOfEdges[i];
			for (EdgeAndVertices edgeConnected : edges) {

				if (edgeConnected.getVertex2() == parent[i]) {

					edge = new EdgeAndVertices(parent[i], i, edgeConnected.getWeight());

					minSpanningtree.add(edge);
				}
			}
		}

		return minSpanningtree;
	}
	
	/**
	 * Function to find the shortest path between two vertices
	 */
	@Override
	public List<EdgeAndVertices> shortestPath(int vertex1, int vertex2) {
		List<EdgeAndVertices> shortestPath;
		int distance[] = new int[numberOfVertices];
		Boolean isProcessed[] = new Boolean[numberOfVertices];

		// Initialize all distances as INFINITE
		for (int i = 0; i < numberOfVertices; i++) {
			distance[i] = Integer.MAX_VALUE;
			isProcessed[i] = false;
		}

		// Distance of source vertex from itself is always 0
		distance[vertex1] = 0;

		// to find shortest path for all vertices
		for (int count = 0; count < numberOfVertices - 1; count++) {
			// Pick the minimum distance vertex not yet processed
			int minVertex1 = minKey(distance, isProcessed);

			// Mark the picked vertex as processed
			isProcessed[minVertex1] = true;

			edges = listOfEdges[minVertex1];
			// Update distance value of the adjacent vertices of the
			// picked vertex.
			for (int adjacentVertex = 0; adjacentVertex < numberOfVertices; adjacentVertex++){

				// Update distance[adjacentVertex] only if is not in isProcessed[]
				for (EdgeAndVertices listEdges : edges) {
					// getting weight connected with vertex
					if (listEdges.getVertex2() == adjacentVertex) {

						if (!isProcessed[adjacentVertex]
								&& listEdges.getWeight() != 0
								&& distance[minVertex1] != Integer.MAX_VALUE
								&& distance[minVertex1] + listEdges.getWeight() < distance[adjacentVertex]) {

							distance[adjacentVertex] = distance[minVertex1]
									+ listEdges.getWeight();
						}
					}
				}
			}
		}

		// store the resulting list in a arrayList along with their
		// distance
		shortestPath = new ArrayList<>();

		for (int i = vertex1; i < vertex2 + 1; i++) {
			edge = new EdgeAndVertices(i - 1, i, distance[i]);
			shortestPath.add(edge);
		}
		return shortestPath;
	}
}
