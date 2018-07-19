package Marksheet;

import java.util.Scanner;

public class Marksheet {

	static Scanner sc = new Scanner(System.in);
	static Scanner sc1 = new Scanner(System.in);

	public static void main(String arg[]) {

		GradeCalculation marks = new GradeCalculation();
		int n = 0;
		float grade[] = {};

		try {
			System.out.println("Enter the number of Student");
			n = sc.nextInt();
			if (n <= 0) {
				throw new ArithmeticException();
			}

			grade = new float[n];

			for (int i = 0; i < n; i++) {

				System.out.println("Enter the grades of" + i + "students:");
				grade[i] = sc1.nextFloat();
				if (grade[i] < 0 || grade[i] > 100) { // if grade is not between
														// 0 and 100 throw
														// exception
					throw new Exception("Out of range");
				}
			}

		} catch (ArithmeticException e) {
			System.out.println("Number of Students cannot be negative or Zero");
			System.exit(0);
		} catch (Exception e3) {
			System.out.println("Range of Grades should be between (0-100)");
			System.exit(0);
		}

		System.out.printf("Average of all grades:" + "%.2f",
				marks.average(grade, n));
		System.out.println();
		System.out.println("Maximum of all grades:" + marks.maximum(grade, n));
		System.out.println("Minimum of all grades:" + marks.minimum(grade, n));
		System.out.printf("Percentage of students passed:" + "%.2f",
				marks.percentage(grade, n));

	}
}
