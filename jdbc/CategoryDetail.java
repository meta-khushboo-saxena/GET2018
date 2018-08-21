package jdbc;

/**
 * Class to store the Category details
 */
public class CategoryDetail {
	private int categoryId;
	private String parentCategoryName;
	private int noOfChild;

	/**
	 * Constructor to initialize the category details
	 * 
	 * @param categoryId
	 * @param parentCategoryName
	 * @param noOfChild
	 */
	public CategoryDetail(int categoryId, String parentCategoryName,
			int noOfChild) {
		this.categoryId = categoryId;
		this.parentCategoryName = parentCategoryName;
		this.noOfChild = noOfChild;
	}

	// GETTER STARTS
	public int getCategoryId() {
		return categoryId;
	}

	public String getParentCategoryName() {
		return parentCategoryName;
	}

	public int getNoOfChild() {
		return noOfChild;
	}
	// GETTER ENDS
}
