package Algorithm1;

/**
 * Class to generate key and value pair
 */
public class KeyValuePair {

	private String key;
	private String value;

	// constructor for initialization
	public KeyValuePair(String word, String meaning) {
		this.key = word;
		this.value = meaning;
	}

	// Getter START
	public String getkey() {
		return key;
	}

	public String getValue() {
		return value;
	}
	// Getter END
}
