package shapeModule;

import java.util.Date;

public class Square implements Shapes {

	private int xCoordinate;
	private int yCoordinate;
	private int side;
	private Date date;
	final private String shape = "SQUARE";

	public Square(int side, Point point) {
		this.side = side;
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

	public int getSide() {
		return side;
	}

	public Date getDate() {
		return date;
	}

	// Getter End

	public float getArea() {
		float area;
		area = this.side * this.side;
		return area;
	}

	public float getPerimeter() {
		float perimeter;
		perimeter = 4 * this.side;
		return perimeter;
	}

	public String getOrigin() {

		return "(" + this.xCoordinate + "," + this.yCoordinate + ")";
	}

	public String getShape() {
		return this.shape;
	}

	public boolean isEnclosed(Point point) {
		boolean flag=false;
		if ((point.getXCoordinate() > this.xCoordinate
				&& point.getXCoordinate() < (this.xCoordinate + this.side)) || (point.getYCoordinate() > this.yCoordinate
						&& point.getYCoordinate() < (this.yCoordinate + this.side)) ) {
				flag=true;
		}
		return flag;
	}

}
