package shapeModule;

public class Point {

	// Setting the maximum and minimum coordinate

	final public int xMaxCoordinate = 500;
	final public int yMaxCoordinate = 500;
	final public int xMinCoordinate = 0;
	final public int yMinCoordinate = 0;

	private int XCoordinate;
	private int YCoordinate;

	// getter and setter for setting x and y coordinates
	public int getXCoordinate() {
		return XCoordinate;
	}

	public void setXCoordinate(int xCoordinate) {
		XCoordinate = xCoordinate;
	}

	public int getYCoordinate() {
		return YCoordinate;
	}

	public void setYCoordinate(int yCoordinate) {
		YCoordinate = yCoordinate;
	}

}
