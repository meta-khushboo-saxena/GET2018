package jdbc;

import java.util.Date;

/**
 * Class to store the order details
 */
public class OrderDetail {

	private int orderId;
	private Date orderDate;
	private double totalAmount;

	/**
	 * Constructor to initialize the order details
	 * 
	 * @param orderId
	 * @param orderDate
	 * @param totalAmount
	 */
	public OrderDetail(int orderId, Date orderDate, double totalAmount) {
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
	}

	// GETTER STARTS
	public int getOrderId() {
		return orderId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public double getTotalAmount() {
		return totalAmount;
	}
	// GETTER ENDS
}
