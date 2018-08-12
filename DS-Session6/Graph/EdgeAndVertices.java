package Graph;

/**
 * class to encapsulate vertices and weight in single entity
 */
public class EdgeAndVertices {

	private int vertex1;
	private int vertex2;
	private int weight;

	/**
	 * initializing vertices and their weight
	 * 
	 * @param vertex1
	 * @param vertex2
	 * @param weight
	 */
	public EdgeAndVertices(int vertex1, int vertex2, int weight) {
		this.vertex1 = vertex1;
		this.vertex2 = vertex2;
		this.weight = weight;
	}

	// Getter and Setter START
	public int getVertex1() {
		return vertex1;
	}

	public int getVertex2() {
		return vertex2;
	}

	public int getWeight() {
		return weight;
	}
	// Getter and Setter END
}
