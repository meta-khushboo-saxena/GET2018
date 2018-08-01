package shapeModule;

import java.util.Date;

public class Circle implements Shapes {

    private int xCoordinate;
    private int yCoordinate;
    private int radius;
    private Date date;
    private String shape = "CIRCLE";

    public Circle(int radius, Point point) {
        this.radius = radius;
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
        return radius;
    }

    public Date getDate() {
        return date;
    }

    // Getter End

    public double getArea() {
        float area;
        area = this.radius * this.radius;
        return area;
    }

    public double getPerimeter() {
        float perimeter;
        perimeter = 4 * this.radius;
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
        
        if ((point.getXCoordinate() - this.xCoordinate)
                * (point.getXCoordinate() - this.xCoordinate)
                + (point.getYCoordinate() - this.yCoordinate)
                * (point.getYCoordinate() - this.yCoordinate) <= radius
                * radius) {
            flag = true;
        }
        return flag;
    }
}
