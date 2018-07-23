import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Computes Area of Triangle,Rectangle,Circle,Square
 */

public class Area {

	static Scanner sc = new Scanner(System.in);

	/**
	 * Function to calculate area of Triangle
	 * 
	 * @param height
	 *            ,base
	 * 
	 * @return area
	 */
	double triangleArea(double height, double base) throws ArithmeticException {
		if (Double.isInfinite(base) || Double.isInfinite(height)
				|| Double.isNaN(base) || Double.isNaN(height)) {
			throw new ArithmeticException("Invalid double value");
		}
		double area = (double) (0.5) * (base * height);
		return area;
	}

	/**
	 * Function to calculate area of Rectangle
	 * 
	 * @param width
	 *            ,height
	 * 
	 * @return area
	 */
	double rectangleArea(double width, double height)
			throws ArithmeticException {
		if (Double.isInfinite(width) || Double.isInfinite(height)
				|| Double.isNaN(width) || Double.isNaN(height)) {
			throw new ArithmeticException("Invalid double value");
		}
		double area = (width * height);
		return area;
	}

	/**
	 * Function to calculate area of Circle
	 * 
	 * @param radius
	 * 
	 * @return area
	 */
	double circleArea(double radius) throws ArithmeticException {
		if (Double.isInfinite(radius) || Double.isNaN(radius)) {
			throw new ArithmeticException("Invalid double value");
		}
		double area = (double) ((3.14) * radius * radius);
		return area;
	}

	/**
	 * Function to calculate area of Square
	 * 
	 * @param sides
	 * 
	 * @return area
	 */
	double squareArea(double sides) throws ArithmeticException {
		if (Double.isInfinite(sides) || Double.isNaN(sides)) {
			throw new ArithmeticException("Invalid double value");
		}
		double area = (double) (sides * sides);
		return area;
	}

	public static void main(String args[]) {
		int choice = 0;

		Area area = new Area();

		do {
			System.out.println("1. Triangle");
			System.out.println("2. Rectangle");
			System.out.println("3. Circle");
			System.out.println("4. Square");
			System.out.println("5. Exit");

			try {
				System.out.println("Enter your choice : ");
				choice = sc.nextInt();

				switch (choice) {
				case 1: {
					double base, height;

					while (true) {
						System.out.println("Enter Base : ");
						base = sc.nextDouble();
						System.out.println("Enter Height : ");
						height = sc.nextDouble();

						if (base <= 0 || height <= 0) {
							System.out
									.println("Base and height should be greater than 0: Enter again");
						} else {
							break;
						}
					}

					System.out.println("Area of Triangle : "
							+ area.triangleArea(height, base));
					break;
				}
				case 2: {
					double width, height;
					while (true) {
						System.out.println("Enter Width : ");
						width = sc.nextDouble();
						System.out.println("Enter Height : ");
						height = sc.nextDouble();
						if (width <= 0 || height <= 0) {
							System.out
									.println("Width and height should be greater than 0: Enter again");
						} else {
							break;
						}
					}
					System.out.println("Area of Rectangle : "
							+ area.rectangleArea(height, width));
					break;
				}
				case 3: {
					double radius;
					while (true) {
						System.out.println("Enter Radius : ");
						radius = sc.nextDouble();
						if (radius <= 0) {
							System.out
									.println("Radius should be greater than 0: Enter again");
						} else {
							break;
						}
					}
					System.out.println("Area of Circle : "
							+ area.circleArea(radius));
					break;
				}
				case 4: {
					double sides;
					while (true) {
						System.out.println("Enter Side : ");
						sides = sc.nextDouble();
						if (sides <= 0) {
							System.out
									.println("Sides should be greater than 0: Enter again");
						} else {
							break;
						}
					}
					System.out.println("Area of Square : "
							+ area.squareArea(sides));
					break;
				}
				case 5: {
					System.exit(0);
				}
				default: {
					System.out.println("Invalid choice");
					break;
				}
				}
			} catch (InputMismatchException e) {
				System.out.println("Please Enter a Valid Choice!!");
				sc.nextLine();
			}

		} while (true);

	}
}
