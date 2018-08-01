package shapeModule;

import java.util.Date;

public class Triangle implements Shapes {

	private int xCoordinate;
	private int yCoordinate;
	private int side1;
	private int side2;
	private int side3;
	private Date date;
	final private String shape = "TRIANGLE";

	public Triangle(int side1, int side2, int side3, Point point) {
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
		this.xCoordinate = point.getXCoordinate();
		this.yCoordinate = point.getYCoordinate();
		this.date = new Date();
	}

	// Getter Start
	public int getxCoordinate() {
		return xCoordinate;
	}

	public int getyCoordinate() {
		return yCoordinate;
	}

	public int getSide1() {
		return side1;
	}

	public int getSide2() {
		return side2;
	}

	public int getSide3() {
		return side3;
	}

	public Date getDate() {
		return date;
	}

	// Getter End

	public double getArea() {
		double area;
		double intermediatePerimeter = this.getPerimeter() / 2;
		area = Math.sqrt(intermediatePerimeter * (intermediatePerimeter - side1) * (intermediatePerimeter - side2)
				* (intermediatePerimeter - side3));
		return area;
	}

	public double getPerimeter() {
		float perimeter = side1 + side2 + side3;
		return perimeter;
	}

	public String getOrigin() {
		return "(" + this.xCoordinate + "," + this.yCoordinate + ")";
	}

	public String getShape() {
		return this.shape;
	}

	/**
	 * Function to check if a point lie on the triangle
	 */
	public boolean isEnclosed(Point point) {
		boolean flag = false;
		double x1, y1, x2, y2, constant1, constant2, constant3;
		x1 = ((side3 * side3) - (side2 * side2) + (side1 * side1)) / (2 * side1);
		y1 = Math.sqrt((side3 * side3) - (x1 * x1));
		x2 = this.getxCoordinate() + side1;
		y2 = this.getyCoordinate();

		constant1 = point.getYCoordinate() - ((this.getyCoordinate() - y2) / (this.getxCoordinate() - x2))
				* point.getXCoordinate();
		constant2 = point.getYCoordinate() - ((y2 - y1) / (x2 - x1)) * point.getXCoordinate();
		constant3 = point.getYCoordinate() - ((this.getyCoordinate() - y1) / (this.getxCoordinate() - x1))
				* point.getXCoordinate();
		if (constant1 > 0 && constant2 > 0 && constant3 > 0) {
			flag = true;
		}
		return flag;
	}
}
