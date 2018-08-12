package Graph;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class TestGraph {
	GraphCreate graph;

	List<Integer> listOfReachable;

	// list minimum spanning tree and shortest path
	List<EdgeAndVertices> list;

	@Before
	public void iniTialize() {
		graph = new GraphCreate(4);
	}

	// Helper function to convert array from list to perform testing
	int[] listToArrayForTest(List<EdgeAndVertices> list) {
		int array[] = new int[list.size()];

		int i = 0;
		for (EdgeAndVertices edgeList : list) {
			array[i] = edgeList.getWeight();
			i++;
		}
		System.out.println(Arrays.toString(array));
		return array;
	}

	@Test
	public void testisConnected() {

		graph.addEdge(0, 1, 3);
		graph.addEdge(0, 2, 5);
		graph.addEdge(0, 3, 2);
		graph.addEdge(1, 2, 9);
		graph.addEdge(2, 3, 9);

		assertEquals(true, graph.isConnected());
	}

	@Test
	public void testisConnected2() {

		graph.addEdge(0, 1, 4);
		graph.addEdge(1, 2, 5);
		graph.addEdge(1, 3, 6);
		graph.addEdge(2, 2, 9);
		graph.addEdge(3, 3, 4);

		assertEquals(true, graph.isConnected());
	}

	@Test
	public void testisConnected3() {

		graph.addEdge(0, 1, 2);
		graph.addEdge(1, 2, 5);
		graph.addEdge(3, 3, 6);
		graph.addEdge(2, 2, 9);
		graph.addEdge(1, 1, 4);

		assertEquals(false, graph.isConnected());
	}

	@Test
	public void testisConnected4() {

		graph.addEdge(0, 1, 9);
		graph.addEdge(0, 2, 5);
		graph.addEdge(0, 3, 6);
		graph.addEdge(1, 2, 9);
		graph.addEdge(2, 3, 4);

		assertEquals(true, graph.isConnected());
	}

	@Test
	public void testReachable() {

		graph.addEdge(0, 1, 4);
		graph.addEdge(0, 2, 5);
		graph.addEdge(0, 3, 6);
		graph.addEdge(1, 2, 9);
		graph.addEdge(2, 3, 4);

		listOfReachable = graph.reachable(0);

		assertEquals(Arrays.asList(3, 2, 1), (listOfReachable));
	}

	@Test
	public void testReachable2() {

		graph.addEdge(0, 1, 4);
		graph.addEdge(0, 2, 5);
		graph.addEdge(0, 3, 6);
		graph.addEdge(1, 2, 9);
		graph.addEdge(2, 3, 4);

		listOfReachable = graph.reachable(1);

		assertEquals(Arrays.asList(2, 0), (listOfReachable));
	}

	@Test
	public void testReachable3() {

		graph.addEdge(0, 1, 4);
		graph.addEdge(0, 2, 5);
		graph.addEdge(0, 3, 6);
		graph.addEdge(1, 2, 9);
		graph.addEdge(2, 3, 4);

		listOfReachable = graph.reachable(2);

		assertEquals(Arrays.asList(3, 1, 0), (listOfReachable));
	}

	@Test
	public void testReachable4() {

		graph.addEdge(0, 1, 4);
		graph.addEdge(0, 2, 5);
		graph.addEdge(0, 3, 6);
		graph.addEdge(1, 2, 9);
		graph.addEdge(2, 3, 4);

		listOfReachable = graph.reachable(3);

		assertEquals(Arrays.asList(2, 0), (listOfReachable));
	}

	@Test
	public void testminimumSpanningTree() {

		graph.addEdge(0, 1, 4);
		graph.addEdge(0, 2, 3);
		graph.addEdge(1, 2, 1);
		graph.addEdge(1, 3, 2);
		graph.addEdge(2, 3, 4);

		list = graph.minimumSpanningTree();

		assertArrayEquals(new int[] { 1, 3, 2 }, this.listToArrayForTest(list));
	}

	@Test
	public void testminimumSpanningTree2() {

		graph.addEdge(0, 1, 4);
		graph.addEdge(0, 2, 5);
		graph.addEdge(0, 3, 6);
		graph.addEdge(1, 2, 9);
		graph.addEdge(2, 3, 4);

		list = graph.minimumSpanningTree();

		assertArrayEquals(new int[] { 4, 5, 4 }, this.listToArrayForTest(list));
	}

	@Test
	public void shortestPathTest() {
		graph.addEdge(0, 1, 4);
		graph.addEdge(0, 2, 5);
		graph.addEdge(0, 3, 6);
		graph.addEdge(1, 2, 9);
		graph.addEdge(2, 3, 4);

		list = graph.shortestPath(0, 2);

		assertArrayEquals(new int[] { 0, 4, 5 }, this.listToArrayForTest(list));
	}

	@Test
	public void shortestPathTest2() {

		graph.addEdge(0, 1, 4);
		graph.addEdge(0, 2, 3);
		graph.addEdge(1, 2, 1);
		graph.addEdge(1, 3, 2);
		graph.addEdge(2, 3, 4);

		list = graph.shortestPath(0, 2);

		assertArrayEquals(new int[] { 0, 4, 3 }, this.listToArrayForTest(list));
	}
}
