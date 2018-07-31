package shapeFactory;

import shapeModule.Circle;
import shapeModule.Point;
import shapeModule.Rectangle;
import shapeModule.Square;
import shapeModule.Triangle;

import java.util.List;

import shapeModule.Shapes;

public class ShapeFactory {

    public static Shapes shapeType(String shapeType, Point point,
            List<Integer> integerList) {
        Shapes shape = null;
        try {

            if (shapeType.equalsIgnoreCase(ShapeTypeEnum.SQUARE.name())) {

                int side = integerList.get(0);
                return new Square(side, point);

            } else if (shapeType.equalsIgnoreCase(ShapeTypeEnum.RECTANGLE
                    .name())) {

                int length = integerList.get(0);
                int width = integerList.get(1);
                return new Rectangle(length, width, point);

            } else if (shapeType
                    .equalsIgnoreCase(ShapeTypeEnum.TRIANGLE.name())) {

                int side1 = integerList.get(0);
                int side2 = integerList.get(1);
                int side3 = integerList.get(2);
                return new Triangle(side1, side2, side3, point);

            } else if (shapeType.equalsIgnoreCase(ShapeTypeEnum.CIRCLE.name())) {

                int radius = integerList.get(0);
                return new Circle(radius, point);
            } else {
                System.out.println("No such shape found");
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("!!Invalid !!");
        }
        return shape;

    }
}
