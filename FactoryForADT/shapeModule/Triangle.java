package shapeModule;

import java.util.Date;

public class Triangle implements Shapes {

    private int xCoordinate;
    private int yCoordinate;
    private int height;
    private int base;
    private Date date;
    final private String shape = "TRIANGLE";

    public Triangle(int height, int base, Point point) {
        this.height = height;
        this.base = base;
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
        return height;
    }

    public int getWidth() {
        return base;
    }

    public Date getDate() {
        return date;
    }

    // Getter End

    public float getArea() {
        float area;
        area = (float) Math.sqrt(3) / 4 * this.height * this.base;
        return area;
    }

    public float getPerimeter() {
        float perimeter = 0;
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
