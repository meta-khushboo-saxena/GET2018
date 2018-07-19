package Marksheet;

/*
 * class to calculate average, maximum, minimum and percentage of student grades
 */
public class GradeCalculation {

	int i;

	/**
	 * calculate average of all grades
	 * 
	 * @param grade
	 *            [] array , n
	 * @return average
	 */
	float average(float grade[], int n) {

		float average = 0, sum = 0;
		for (i = 0; i < n; i++) {
			sum += grade[i];
		}
		average = sum / n;

		return average;
	}

	/**
	 * find maximum of all grades
	 * 
	 * @param grade
	 *            [] array , n
	 * @return maximum
	 */
	float maximum(float grade[], int n) {
		float maximum = grade[0];
		for (i = 1; i < n; i++) {
			if (maximum < grade[i]) {
				maximum = grade[i];
			} else {
				continue;
			}
		}
		return maximum;
	}

	/**
	 * find minimum of all grades
	 * 
	 * @param grade
	 *            [] array , n
	 * @return minimum
	 */
	float minimum(float grade[], int n) {
		float minimum = grade[0];
		for (i = 1; i < n; i++) {
			if (minimum > grade[i]) {
				minimum = grade[i];
			} else {
				continue;
			}
		}
		return minimum;
	}

	/**
	 * Calculate percentage of pass students
	 * 
	 * @param grade
	 *            [] array , n
	 * @return percentage
	 */
	float percentage(float grade[], int n) {
		int count = 0;
		float percentage;
		for (i = 0; i < n; i++) {
			if (grade[i] >= 40) {
				count++;
			}
		}
		percentage = (float) count / n * 100;
		return percentage;
	}

}
