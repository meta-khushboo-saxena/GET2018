package Marksheet;

import java.util.Scanner;

/**
 * main class for grade calculation
 */
public class Marksheet {

    static Scanner sc = new Scanner(System.in);

    public static void main(String arg[]) {

        GradeCalculation marks = new GradeCalculation();
        int n = 0;
        float grade[] = {};
        System.out.println("Enter the number of Student");
        while (true) {
            n = sc.nextInt();

            if (n <= 0) {
                System.out.println("Number should be positive: Enter again!!");
            } else {
                grade = new float[n];
                break;
            }

        }
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the grades of students " + (i + 1) + ":");
            while (true) {
                grade[i] = sc.nextFloat();
                if (grade[i] < 0 || grade[i] > 100) {
                    System.out
                            .println("Grade should be between 0 and 100: Enter grade again!!");
                } else {
                    break;
                }
            }
        }

        System.out.printf("Average of all grades:" + "%.2f\n", marks.average(
                grade, n));
        System.out.printf("Maximum of all grades:" + "%.2f\n", marks.maximum(
                grade, n));
        System.out.printf("Minimum of all grades:" + "%.2f\n", marks.minimum(
                grade, n));
        System.out.printf("Percentage of students passed:" + "%.2f\n", marks
                .percentage(grade, n));

    }
}
