package shapeModule;

import java.util.Date;

public class Rectangle implements Shapes {

	private int xCoordinate;
	private int yCoordinate;
	private int length;
	private int width;
	private Date date;
	final private String shape = "RECTANGLE";

	public Rectangle(int length, int width, Point point) {
		this.length = length;
		this.width = width;
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

	public int getLength() {
		return length;
	}

	public int getWidth() {
		return width;
	}

	public Date getDate() {
		return date;
	}

	// Getter End

	public double getArea() {
		float area;
		area = this.length * this.width;
		return area;
	}

	public double getPerimeter() {
		float perimeter;
		perimeter = 2 * this.length * this.width;
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
				&& point.getXCoordinate() < (this.xCoordinate + this.width)) || (point.getYCoordinate() > this.yCoordinate
						&& point.getYCoordinate() < (this.yCoordinate + this.length)) ) {
				flag=true;
		}
		return flag;
	}
}
