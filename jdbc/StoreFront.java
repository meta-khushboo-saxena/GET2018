package jdbc;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Class for inserting , deleting and displaying data
 */
public class StoreFront {

	private Connection connection = ConnectionManager.getConnection();
	private PreparedStatement statement;
	private ResultSet resultSet = null;
	private List<OrderDetail> listOfOrders = new ArrayList<OrderDetail>();
	private List<CategoryDetail> listOfParentCategory = new ArrayList<CategoryDetail>();
	private Queries queries = new Queries();
	private OrderDetail orderDetail;
	private CategoryDetail categoryDetail;

	/**
	 * Function to fetch all orders detail of that user which are in shipped
	 * state
	 * 
	 * @param userId
	 *            : id of the user
	 * @return list of order detail
	 */
	public List<OrderDetail> getOrderDetail(int userId) {
		System.out.println("dvsdv");
		try {
			statement = connection.prepareStatement(queries.getSelect_query());
			statement.setString(1, "Shipped");
			statement.setInt(2, userId);
			resultSet = statement.executeQuery();

			// Move the cursor to the next row, return false if no more row
			while (resultSet.next()) {
				orderDetail = new OrderDetail(resultSet.getInt("order_id"),
						resultSet.getDate("order_date"),
						resultSet.getDouble("total_amount"));

				// storing the data in the array list
				listOfOrders.add(orderDetail);
				System.out.println("id: " + orderDetail.getOrderId()
						+ " date: " + orderDetail.getOrderDate()
						+ " total_amount:" + orderDetail.getTotalAmount());
			}
		} catch (SQLException ex) {
			System.out.println("error");
		}
		return listOfOrders;
	}

	/**
	 * Function to insert five or more images of a product using batch insert
	 * technique
	 * 
	 * @param imageList
	 *            : contain list of image deatails inserted by the user
	 * @return number of images inserted
	 */
	public int insertImage(List<Image> imageList) {
		System.out.println("dvsdv");
		int result = 0;
		try {
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(queries.getInsert_query());

			// inserting the data into the database table using batch
			for (int i = 0; i < imageList.size(); i++) {
				statement.setInt(1, imageList.get(i).getProductId());
				statement.setString(2, imageList.get(i).getImageName());
				statement.addBatch();
			}
			result = statement.executeBatch().length;
			// if there is no error
			connection.commit();
			// if there is error
			connection.rollback();
		} catch (SQLException ex) {
			System.out.println("error");
		}
		return result;
	}

	/**
	 * Function to set products as inactive which were not ordered in last 1
	 * year
	 * 
	 * @return the number of products updated
	 */
	public int UpdateProduct() {
		int dataCount = 0;
		try {
			statement = connection.prepareStatement(queries.getUpdated_query());
			dataCount = statement.executeUpdate();
			// if dataCount is 0 then return 0
			if (dataCount == 0) {
				return 0;
			}
		} catch (SQLException ex) {
			System.out.println("error");
		}
		return dataCount;
	}

	/**
	 * Function to select and display the category title of all top parent
	 * categories sorted alphabetically and the count of their child categories
	 * 
	 * @return display the list of categories
	 */
	public List<CategoryDetail> selectAndDispaly() {
		try {
			statement = connection.prepareStatement(queries
					.getSelect_display_query());
			resultSet = statement.executeQuery();

			// Move the cursor to the next row, return false if no more row
			while (resultSet.next()) {

				categoryDetail = new CategoryDetail(resultSet.getInt("id"),
						resultSet.getString("category_name"),
						resultSet.getInt("count"));

				// storing the data in the array list
				listOfParentCategory.add(categoryDetail);

				System.out.println("CategoryId: "
						+ categoryDetail.getCategoryId() + " Category Name: "
						+ categoryDetail.getParentCategoryName()
						+ " No Of Childs:" + categoryDetail.getNoOfChild());
			}
		} catch (SQLException ex) {
			System.out.println("error");
		}
		return listOfParentCategory;
	}

	/**
	 * Function to close the connection
	 */
	public void closeConnection() {
		try {
			// Close Result Set Object
			if (resultSet != null) {
				resultSet.close();
			}
			// Close Prepared Statement Object
			if (statement != null) {
				statement.close();
			}
			// Close Connection Object
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String arg[]) {
		StoreFront storefront = new StoreFront();
		System.out.println(storefront.getOrderDetail(1));
		System.out.println(storefront.UpdateProduct());
		storefront.selectAndDispaly();
	}
}
