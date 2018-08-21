package jdbc;

/**
 * Class containing the image details
 */
public class Image {

	private int productId;
	private String imageName;

	/**
	 * Constructor to initialize the image details
	 * 
	 * @param id
	 * @param imageName
	 */
	public Image(int productId, String imageName) {
		this.productId = productId;
		this.imageName = imageName;
	}

	// GETTER STARTS
	public int getProductId() {
		return productId;
	}

	public String getImageName() {
		return imageName;
	}
	// GETTER ENDS
}
