package SCF_Session6_ADT;

/**
 * main class for performing various operations on polynomial equations
 */
final class Polynomial {

	private int[][] coefficient;

	public Polynomial() {

	}

	/**
	 * Parameterized constructor for initializing the array for storing
	 * polynomial
	 * 
	 * @param coefficient
	 *            : 2-D array to store the coefficient and degree of polynomial
	 */
	public Polynomial(int[][] coefficient) {
		this.coefficient = coefficient;
	}

	/**
	 * Function for sorting degree of polynomials
	 */
	public void sort(int sort[][]) {

		for (int i = 0; i < sort.length - 1; i++) {
			for (int j = 0; j < sort.length - i - 1; j++) {
				if (sort[j][1] > sort[j + 1][1]) {
					int temp = sort[j][1];
					int temp2 = sort[j][0];
					sort[j][1] = sort[j + 1][1];
					sort[j][0] = sort[j + 1][0];
					sort[j + 1][1] = temp;
					sort[j + 1][0] = temp2;
				}
			}
		}
	}

	/**
	 * function to calculate the power
	 * 
	 * @param x
	 * @param d
	 * @return
	 */
	private double power(double x, int d) {
		int power = 1;
		for (int i = 0; i < d; i++) {
			power *= x;
		}
		return power;
	}

	/**
	 * function to calculate the degree of the polynomial equation
	 * 
	 * @return degree
	 */
	public int degree() {
		int degree = coefficient[0][1];
		for (int i = 0; i < coefficient.length; i++) {
			if (degree < coefficient[i][1]) {
				degree = coefficient[i][1];
			}
		}
		return degree;
	}

	/**
	 * function to evaluate the polynomial equation
	 * 
	 * @param x
	 * @return sum after calculating
	 */
	public double evaluate(double x) {
		double sum = 0;
		for (int i = 0; i < coefficient.length; i++) {
			sum += coefficient[i][0] * power(x, coefficient[i][1]);
		}
		return sum;
	}

	/**
	 * function to add two polynomial equations
	 * 
	 * @param p1
	 * @param p2
	 * @return polySumArray: array containing sum of two polynomial
	 */
	public int[][] add(Polynomial p1, Polynomial p2) {
		int i = 0, j = 0, k, count = 0;
		int poly1[][] = p1.coefficient;
		int poly2[][] = p2.coefficient;
		sort(poly1);
		sort(poly2);
		int newDegree;
		newDegree = p1.degree();
		if ((p1.degree() < p2.degree())
				|| ((p1.degree() == p2.degree()) && (poly1.length < poly2.length))) {
			newDegree = p2.degree();
			int result[][] = add(p2, p1);
			return result;
		}
		int polySumArray[][] = new int[newDegree + 1][2];

		for (i = 0; i < poly1.length; i++) {
			polySumArray[i][0] = poly1[i][0];
			polySumArray[i][1] = poly1[i][1];
		}

		for (k = 0; k < poly1.length; k++) {
			for (j = 0; j < poly2.length; j++) {
				if (polySumArray[k][1] == poly2[j][1]) {
					polySumArray[k][0] += poly2[j][0];
					count++;
				}
			}
		}

		while (count < poly2.length) {
			polySumArray[k][0] = poly2[count][0];
			polySumArray[k][1] = poly2[count][1];
			count++;
			k++;
		}
		
		int polySumArrayNew[][] = new int[k][2];
		for (j = 0; j < k; j++) {
			polySumArrayNew[j][0] = polySumArray[j][0];
			polySumArrayNew[j][1] = polySumArray[j][1];
		}
		sort(polySumArrayNew);
		System.out.println("\nAfter Addition:");
		 for (i = 0; i < polySumArrayNew.length; i++) {
			 System.out.println("Coefficient: " + polySumArrayNew[i][0]);
			 System.out.println("Degree:" + polySumArrayNew[i][1]);
			 }
		return polySumArrayNew;
	}

	/**
	 * function to multiply two polynomial equations
	 * 
	 * @param p1
	 * @param p2
	 * @return polySumArray: array containing sum of two polynomial
	 */
	public int[][] multiplyPoly(Polynomial p1, Polynomial p2) {
		int i, j;
		int multiply[][] = new int[p1.coefficient.length
				* p2.coefficient.length][2];
		int newIndex = 0;

		for (i = 0; i < p1.coefficient.length; i++) {
			for (j = 0; j < p2.coefficient.length; j++) {
				multiply[newIndex][0] = p1.coefficient[i][0]
						* p2.coefficient[j][0];
				multiply[newIndex][1] = p1.coefficient[i][1]
						+ p2.coefficient[j][1];
				newIndex++;
			}
			System.out.println();
		}
		sort(multiply);
		for (i = 1; i < newIndex; i++) {
			if (multiply[i][1] == multiply[i - 1][1]) {
				multiply[i - 1][0] += multiply[i][0];
				for (j = i; j < newIndex - 1; j++) {
					multiply[j][0] = multiply[j + 1][0];
					multiply[j][1] = multiply[j + 1][1];
				}
				newIndex--;
			}
		}
		int multi[][] = new int[newIndex][2];

		for (i = 0; i < newIndex; i++) {
			multi[i][0] = multiply[i][0];
			multi[i][1] = multiply[i][1];
		}
		 System.out.println("After Multiply:");
		 for (i = 0; i < newIndex; i++) {
		 System.out.println("After multi: [" + i + "][0]" + multi[i][0]);
		 System.out.println("After multi: [" + i + "][1]" + multi[i][1]);
		 }
		return multi;
	}

}
