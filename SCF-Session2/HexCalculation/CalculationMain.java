package HexCalculation;

import java.util.Scanner;

public class CalculationMain {

	static HexCalc calculation = new HexCalc();
	static Scanner sc = new Scanner(System.in);

	public static void main(String arg[]) {

		String hexadecimal1, hexadecimal2;
		String add, sub, mult, divide;
		boolean greater, smaller, equalto;
		int choice;

		System.out.println("Enter first Hexadecimal number:");
		hexadecimal1 = sc.next();

		System.out.println("Enter second Hexadecimal number:");
		hexadecimal2 = sc.next();

		if (!(calculation.valid(hexadecimal1, hexadecimal2))) {
			System.out.println("Not a valid Numbers");
			System.exit(0);
		}
		do {
			System.out.println("1. Add Numbers");
			System.out.println("2. Subtract Numbers");
			System.out.println("3. Multiply Numbers");
			System.out.println("4. Divide Numbers");
			System.out.println("5. Comparision for Greater Numbers");
			System.out.println("6. Comparision for Smaller Numbers");
			System.out.println("7. Comparision for equal Numbers");
			System.out.println("8. Exit");
			System.out.println("Enter your choice");
			choice = sc.nextInt();

			switch (choice) {

			case 1: {
				add = calculation.addition(hexadecimal1, hexadecimal2);
				System.out.println("After Addition =" + add);
				break;
			}
			case 2: {
				if (calculation.isGreater(hexadecimal1, hexadecimal2)) {
					sub = calculation.subtraction(hexadecimal1, hexadecimal2);
					System.out.println("After Substraction =" + sub);

				} else {
					System.out.println("Not valid for subtraction");
				}
				break;
			}
			case 3: {
				mult = calculation.multiply(hexadecimal1, hexadecimal2);
				System.out.println("After Multiplication =" + mult);
				break;
			}
			case 4: {
				divide = calculation.divide(hexadecimal1, hexadecimal2);
				System.out.println("After Division =" + divide);
				break;
			}
			case 5: {
				greater = calculation.isGreater(hexadecimal1, hexadecimal2);
				if (greater) {
					System.out.println("Number is Greater");
				} else {
					System.out.println("Number is not Greater");
				}
				break;
			}
			case 6: {
				smaller = calculation.isSmaller(hexadecimal1, hexadecimal2);
				if (smaller) {
					System.out.println("Number is Smaller");
				} else {
					System.out.println("Number is not Smaller");
				}
				break;
			}
			case 7: {
				equalto = calculation.isEqualto(hexadecimal1, hexadecimal2);
				if (equalto) {
					System.out.println("Number is Equal");
				} else {
					System.out.println("Number is not Equal");
				}
				break;
			}
			case 8: {
				System.exit(0);

			}
			default:
				System.out.println("Invalid choice");
			}

		} while (true);

	}

}
