import java.util.Scanner;

//Computes Area of Triangle,Rectangle,Circle,Square

public class Area {

	/*
	 * Function to calculate area of Triangle
	 * 
	 * @param height,base
	 * 
	 * @return area
	 */
	double triangleArea(double height, double base) {
		double area = (double) (0.5) * (base * height);
		return area;
	}

	/*
	 * Function to calculate area of Rectangle
	 * 
	 * @param width,height
	 * 
	 * @return area
	 */
	double rectangleArea(double width, double height) {
		double area = (width * height);
		return area;
	}

	/*
	 * Function to calculate area of Circle
	 * 
	 * @param radius
	 * 
	 * @return area
	 */
	double circleArea(double radius) {
		double area = (double) ((3.14) * radius * radius);
		return area;
	}

	/*
	 * Function to calculate area of Square
	 * 
	 * @param sides
	 * 
	 * @return area
	 */
	double squareArea(double sides) {
		double area = (double) (sides * sides);
		return area;
	}

	public static void main(String args[]) {
		int choice = 0;
		Scanner sc = new Scanner(System.in);
		Area area = new Area();

		do {
			try {
				System.out.println("1. Triangle");
				System.out.println("2. Rectangle");
				System.out.println("3. Circle");
				System.out.println("4. Square");
				System.out.println("5. Exit");

				System.out.println("Enter your choice : ");
				choice = sc.nextInt();

				switch (choice) {
				case 1: {
					int base, height;
					System.out.println("Enter Base : ");
					base = sc.nextInt();
					if (base <= 0) {
						throw new ArithmeticException();
					}
					System.out.println("Enter Height : ");
					height = sc.nextInt();
					if (height <= 0) {
						throw new ArithmeticException();
					}
					System.out.println("Area of Triangle : "
							+ area.triangleArea(height, base));
					break;
				}
				case 2: {
					int width, height;
					System.out.println("Enter Width : ");
					width = sc.nextInt();
					if (width <= 0) {
						throw new ArithmeticException();
					}
					System.out.println("Enter Height : ");
					height = sc.nextInt();
					if (height <= 0) {
						throw new ArithmeticException();
					}
					System.out.println("Area of Rectangle : "
							+ area.rectangleArea(height, width));
					break;
				}
				case 3: {
					int radius;
					System.out.println("Enter Radius : ");
					radius = sc.nextInt();
					if (radius <= 0) {
						throw new ArithmeticException();
					}
					System.out.println("Area of Circle : "
							+ area.circleArea(radius));
					break;
				}
				case 4: {
					int sides;
					System.out.println("Enter Side : ");
					sides = sc.nextInt();
					if (sides <= 0) {
						throw new ArithmeticException();
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
			} catch (ArithmeticException e) {
				System.out.println("Input cannot be negative or Zero");
				continue;

			} catch (Exception e1) {
				System.out.println("Enter valid Input Please");
				continue;
			}
			sc.close();
		} while (true);

	}
}