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

    public float getArea() {
        float area;
        float intermediatePerimeter = this.getPerimeter() / 2;
        area = (float) Math.sqrt(intermediatePerimeter
                * (intermediatePerimeter - side1)
                * (intermediatePerimeter - side2)
                * (intermediatePerimeter - side3));
        return area;
    }

    public float getPerimeter() {
        float perimeter = side1 + side2 + side3;
        return perimeter;
    }

    public String getOrigin() {
        return "(" + this.xCoordinate + "," + this.yCoordinate + ")";
    }

    public String getShape() {
        return this.shape;
    }

    public boolean isEnclosed(Point point) {
        boolean flag = false;

        return flag;
    }
}
