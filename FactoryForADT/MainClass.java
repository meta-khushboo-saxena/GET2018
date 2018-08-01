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
			System.out.println("Set point for Square on screen (X and Y) Coordinates : (Between 0 and 500)");
			xCoordinate = check();
			point.setXCoordinate(xCoordinate);
			yCoordinate = check();
			point.setYCoordinate(yCoordinate);

			if (xCoordinate > point.xMaxCoordinate || xCoordinate < point.xMinCoordinate || yCoordinate > point.yMaxCoordinate
					|| yCoordinate < point.yMinCoordinate) {
				System.out.println("Coordinates should be between 0 and 500!!\n");
			} else {
				break;
			}
		}
		return point;
	}

	/**
	 * Function to check if the inputs are Integer
	 */
	public int check() {
		int value = 0;

		// Loop until user inputs non integer values or negative values
		while (!scanner.hasNextInt() || (scanner.hasNextInt() && (value = scanner.nextInt()) <= 0)) {
			System.out.print("Enter Positive Integer !!\n");
			if (!scanner.hasNextInt())
				scanner.next();
		}
		return value;
	}

	public static void main(String arg[]) {
		int side, length, width, side1, side2, side3, radius;
		int choice = 0;
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
				System.out.println("6. Display Shapes according to Area");
				System.out.println("7. Display Shapes according to Perimeter");
				System.out.println("8. Display Shapes according to TimeStamp");
				System.out.println("9. Display Shapes enclosing a point");
				System.out.println("10. Remove");
				System.out.println("11. Remove all");
				System.out.println("12. Exit");

				System.out.println("Enter your choice");
				choice = scanner.nextInt();

				switch (choice) {
				case 1: {
					point = main.setCoordinates();
					while (true) {
						System.out.println("Enter the side of square");
						side = main.check();

						integerList.add(0, side);
						if (side + point.getXCoordinate() > point.xMaxCoordinate
								|| side + point.getYCoordinate() > point.yMaxCoordinate) {
							System.out.println("Size of square is greater than screen!!Enter again \n");
						} else {
							break;
						}
					}
					// Setting the size , x-coordinate and y-coordinate of
					// square
					Shapes shapeSquare = ShapeFactory.shapeType(ShapeTypeEnum.SQUARE.name(), point, integerList);

					screen.addShape(shapeSquare);
					break;
				}
				case 2: {
					point = main.setCoordinates();
					while (true) {
						System.out.println("Enter the length of rectangle");
						length = main.check();
						integerList.add(0, length);
						System.out.println("Enter the width of rectangle");
						width = main.check();
						integerList.add(1, width);

						if (length + point.getYCoordinate() > point.yMaxCoordinate
								|| width + point.getXCoordinate() > point.xMaxCoordinate) {
							System.out.println("Size of rectangle is greater than screen!!Enter again \n");
						} else {
							break;
						}
					}

					// Setting the size , x-coordinate and y-coordinate of
					// square
					Shapes shapeRectangle = ShapeFactory.shapeType(ShapeTypeEnum.RECTANGLE.name(), point, integerList);

					screen.addShape(shapeRectangle);
					break;
				}
				case 3: {
					point = main.setCoordinates();

					System.out.println("Enter the side1 of triangle");
					side1 = main.check();
					integerList.add(0, side1);

					System.out.println("Enter the side2 of triangle");
					side2 = main.check();
					integerList.add(1, side2);

					System.out.println("Enter the side3 of triangle");
					side3 = main.check();
					integerList.add(2, side3);

					// Setting the sides, x-coordinate and y-coordinate
					// of square
					Shapes shapeTriangle = ShapeFactory.shapeType(ShapeTypeEnum.TRIANGLE.name(), point, integerList);

					screen.addShape(shapeTriangle);
					break;
				}
				case 4: {
					point = main.setCoordinates();
					while (true) {
						System.out.println("Enter the radius of Circle");
						radius = scanner.nextInt();
						integerList.add(0, radius);

						if (radius + point.getYCoordinate() > point.yMaxCoordinate
								|| radius + point.getXCoordinate() > point.xMaxCoordinate) {
							System.out.println("Size of circle is greater than screen!!Enter again \n");
						} else {
							break;
						}
					}

					// Setting the radius , x-coordinate and y-coordinate of
					// square
					Shapes shapeCircle = ShapeFactory.shapeType(ShapeTypeEnum.CIRCLE.name(), point, integerList);

					screen.addShape(shapeCircle);
					break;
				}
				case 5: {
					screen.displayShapes(screen.shapeList);
					break;
				}
				case 6: {
					screen.sortUsingArea();
					break;
				}
				case 7: {
					screen.sortUsingPerimeter();
					;
					break;
				}
				case 8: {
					screen.sortUsingTimeStamp();
					break;
				}
				case 9: {
					if (screen.shapeList.size() == 0) {
						System.out.println("No Shape present in the screen !!\n");
					} else {
						point = main.setCoordinates();
						screen.displayEnclosedShape(point);
					}
					break;
				}
				case 10: {
					screen.displayShapes(screen.shapeList);
					scanner.nextLine();
					System.out.println("Enter the index which you wanna delete:");
					index = scanner.nextInt();
					screen.removeShapes(index);
					break;
				}
				case 11: {
					screen.removeAllShapes();
					break;
				}
				case 12: {
					System.exit(0);
					break;
				}
				default:
					System.out.println("Invalid Choice!!\n");
				}

			} catch (Exception e) {

				System.out.println("Please enter correct Input !! ");
				scanner.nextLine();
			}
		} while (choice != 12);

	}

}
