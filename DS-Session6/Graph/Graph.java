package Graph;

import java.util.List;

/**
 * Interface to define graph
 */
public interface Graph {

	boolean isConnected();

	List<Integer> reachable(int vertex);

	List<EdgeAndVertices> minimumSpanningTree();

	List<EdgeAndVertices> shortestPath(int vertex1, int vertex2);
}
