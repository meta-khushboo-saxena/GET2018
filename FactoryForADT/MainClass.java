import shapeFactory.ShapeFactory;
import shapeFactory.ShapeTypeEnum;
import shapeModule.Point;
import shapeModule.Shapes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainClass {

	static Scanner scanner = new Scanner(System.in);
	int xCoordinate, yCoordinate;
	static Point point = new Point();

	/**
	 * Function to set the coordinates
	 */
	public Point setCoordinates() {
		while (true) {
			System.out
					.println("Set point for Square on screen (X and Y) Coordinates : ");
			xCoordinate = scanner.nextInt();
			point.setXCoordinate(xCoordinate);
			yCoordinate = scanner.nextInt();
			point.setYCoordinate(yCoordinate);

			if (xCoordinate > point.xMaxCoordinate
					|| xCoordinate < point.xMinCoordinate
					|| yCoordinate > point.yMaxCoordinate
					|| yCoordinate < point.yMinCoordinate) {
				System.out
						.println("Coordinates should be between 0 and 500!!\n");
			} else {
				break;
			}
		}
		return point;
	}


	public static void main(String arg[]) {
		int side, length, width, side1, side2, side3, radius;

		int choice;
		int index;
		List<Integer> integerList = new ArrayList<Integer>();
		MainClass main = new MainClass();
		Screen screen = new Screen();
		do {
			try {
				System.out.println("1. Add Square");
				System.out.println("2. Add Rectangle");
				System.out.println("3. Add Triangle");
				System.out.println("4. Add Circle");
				System.out.println("5. Display Shapes");
				System.out.println("6. Display Shapes in Ascending Order");
				System.out.println("7. Display Shapes enclosing a point");
				System.out.println("8. Remove");
				System.out.println("9. Remove all");
				System.out.println("10. Exit");

				System.out.println("Enter your choice");
				choice = scanner.nextInt();

				switch (choice) {
				case 1: {
					System.out.println("Enter the side of square");
					side = scanner.nextInt();
					integerList.add(0, side);
					point = main.setCoordinates();
					// Setting the size , x-coordinate and y-coordinate of
					// square
					Shapes shapeSquare = ShapeFactory.shapeType(
							ShapeTypeEnum.SQUARE.name(), point, integerList);

					screen.addShape(shapeSquare);
					break;
				}
				case 2: {
					System.out.println("Enter the length of rectangle");
					length = scanner.nextInt();
					integerList.add(0, length);
					System.out.println("Enter the width of rectangle");
					width = scanner.nextInt();
					integerList.add(1, width);
					point = main.setCoordinates();

					// Setting the size , x-coordinate and y-coordinate of
					// square
					Shapes shapeRectangle = ShapeFactory.shapeType(
							ShapeTypeEnum.RECTANGLE.name(), point, integerList);

					screen.addShape(shapeRectangle);
					break;
				}
				case 3: {
					System.out.println("Enter the side1 of triangle");
					side1 = scanner.nextInt();
					integerList.add(0, side1);

					System.out.println("Enter the side2 of triangle");
					side2 = scanner.nextInt();
					integerList.add(1, side2);

					System.out.println("Enter the side3 of triangle");
					side3 = scanner.nextInt();
					integerList.add(2, side3);

					point = main.setCoordinates();

					// Setting the height, base , x-coordinate and y-coordinate
					// of square
					Shapes shapeTriangle = ShapeFactory.shapeType(
							ShapeTypeEnum.TRIANGLE.name(), point, integerList);

					screen.addShape(shapeTriangle);
					break;
				}
				case 4: {
					System.out.println("Enter the radius of Circle");
					radius = scanner.nextInt();
					integerList.add(0, radius);

					point = main.setCoordinates();

					// Setting the radius , x-coordinate and y-coordinate of
					// square
					Shapes shapeCircle = ShapeFactory.shapeType(
							ShapeTypeEnum.CIRCLE.name(), point, integerList);

					screen.addShape(shapeCircle);
					break;
				}
				case 5: {
					screen.displayShapes();
					break;
				}
				case 6: {
					String display[] = screen.displayinAscending();
					for (int i = 0; i < display.length; i++) {
						System.out.println(display[i]);
					}
					break;
				}
				case 7: {
					point = main.setCoordinates();
					screen.displayEnclosedShape(point);
					break;
				}
				case 8: {
					screen.displayShapes();
					scanner.nextLine();
					System.out
							.println("Enter the index which you wanna delete:");
					index = scanner.nextInt();
					screen.removeShapes(index);
					break;
				}
				case 9: {
					screen.removeAllShapes();
					break;
				}
				case 10: {
					System.exit(0);
					break;
				}
				}

			} catch (Exception e) {
				// e.printStackTrace();
				System.out.println("Please enter correct Input !! ");
				scanner.nextLine();
			}
		} while (true);

	}

}
