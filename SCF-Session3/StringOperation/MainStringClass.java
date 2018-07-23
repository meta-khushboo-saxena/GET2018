package StringOperation;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * contain various operation on string string should not be null
 */
public class MainStringClass {

	static Scanner sc = new Scanner(System.in);

	public static void main(String arg[]) {
		StringOperations operation = new StringOperations();
		int choice = 0;

		do {

			System.out.println("1. Compare two String");
			System.out.println("2. Reverse a String");
			System.out.println("3. Change the case of a String");
			System.out.println("4. Find largest word in the String");
			System.out.println("5. Exit");

			try {
				System.out.println("Enter your choice");
				choice = sc.nextInt();

				switch (choice) {

				case 1: {
					String string1 = new String();
					String string2 = new String();

					while (true) {
						System.out.println("Enter two strings : ");
						sc.nextLine();
						string1 = sc.nextLine();
						string2 = sc.nextLine();
						if (string1.isEmpty() || string2.isEmpty()) {
							System.out.println("String cannot be Empty!!");
						} else {
							break;
						}
					}
					boolean compareString = operation.compareStrings(string1,
							string2);
					if (compareString) {
						System.out.println("Both Strings are Same");
					} else {
						System.out.println("Both Strings are NOT Same");
					}
					break;

				}
				case 2: {
					String string = new String();

					while (true) {
						System.out.println("Enter the string : ");
						sc.nextLine();
						string = sc.nextLine();
						if (string.isEmpty()) {
							System.out.println("String cannot be Empty!!");

						} else {
							break;
						}
					}
					String ReversedString = operation.stringReverse(string);
					System.out
							.println("Reversed String is : " + ReversedString);
					break;
				}
				case 3: {

					String string = new String();
					while (true) {
						System.out.println("Enter the string : ");
						sc.nextLine();
						string = sc.nextLine();
						if (string.isEmpty()) {
							System.out.println("String cannot be Empty!!");
						} else {
							break;
						}
					}
					String NewString = operation.CaseChange(string);
					System.out.println("Case changed String is : " + NewString);
					break;

				}
				case 4: {
					String string = new String();

					while (true) {
						System.out.println("Enter the string : ");
						sc.nextLine();
						string = sc.nextLine();
						if (string.isEmpty()) {
							System.out.println("String cannot be Empty!!");
						} else {
							break;
						}
					}
					System.out.println(operation.LongestWordFromString(string));
					break;
				}
				case 5: {
					System.exit(0);
				}
				default:
					System.out.println("Invalid choice");

				}
			} catch (InputMismatchException e) {
				System.out.println("Please Enter a Valid Choice!!");
				sc.nextLine();
			}

		} while (true);

	}
}
