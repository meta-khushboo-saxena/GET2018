package jdbc;

/**
 * Class containing all queries
 */
public class Queries {

	private final String select_query = "SELECT o.id AS order_id, o.order_date , SUM(p.product_price) AS total_amount "
			+ "FROM order_items i INNER JOIN orders o ON i.order_id = o.id "
			+ "INNER JOIN product p ON p.id = i.product_id "
			+ "WHERE i.order_status = ? AND o.user_id = ? "
			+ "GROUP BY i.order_id ORDER BY order_date DESC;";

	private final String insert_query = "INSERT INTO image (product_id, image_name) VALUES(?,?)";

	private final String update_query = " UPDATE product SET product_state = 'Inactive' "
			+ "WHERE id Not IN ("
			+ "SELECT product_id FROM ( "
			+ "SELECT DISTINCT(p.id) AS product_id FROM order_items i "
			+ "INNER JOIN product p ON i.product_id = p.id "
			+ "INNER JOIN orders o ON i.order_id = o.id "
			+ "WHERE o.order_date >= CURDATE() - INTERVAL 1 YEAR ) AS id );";

	private final String select_display_query = "SELECT C.id, C.category_name, COUNT(C.id) as count "
			+ "FROM category C LEFT JOIN category P ON P.parent_id = C.id WHERE P.parent_id IN "
			+ "(SELECT id FROM category WHERE parent_id IS NULL) GROUP BY C.id ORDER BY category_name;";

	// GETTER STARTS
	public String getSelect_query() {
		return select_query;
	}

	public String getInsert_query() {
		return insert_query;
	}

	public String getUpdated_query() {
		return update_query;
	}

	public String getSelect_display_query() {
		return select_display_query;
	}
	// GETTER ENDS
}
