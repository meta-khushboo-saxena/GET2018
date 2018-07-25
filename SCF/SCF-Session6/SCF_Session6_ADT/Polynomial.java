package SCF_Session6;

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

        for (int i = 0; i < sort.length; i++) {
            for (int j = i + 1; j < sort.length; j++) {
                if (sort[i][1] > sort[j][1]) {
                    int temp = sort[i][1];
                    int temp2 = sort[i][0];
                    sort[i][1] = sort[j][1];
                    sort[i][0] = sort[j][0];
                    sort[j][1] = temp;
                    sort[j][0] = temp2;
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
        System.out.println("length:" + coefficient.length);
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
        int poly1[][] = p1.coefficient;
        int poly2[][] = p2.coefficient;
        sort(poly1);
        sort(poly2);
        int newDegree;
        if (poly1.length < poly2.length) {
            newDegree = poly2.length;
            int result[][] = add(p2, p1);
            return result;
        } else {
            newDegree = poly1.length;
        }
        int polySumArray[][] = new int[newDegree][2];

        for (int i = 0; i < poly1.length; i++) {
            polySumArray[i][0] = poly1[i][0];
            polySumArray[i][1] = poly1[i][1];
        }
        for (int i = 0, j = 0; i < poly1.length; i++) {
            if (poly1[i][1] == poly2[j][1]) {
                polySumArray[i][0] += poly2[j][0];
                j++;
                System.out.println("sum " + polySumArray[i][0]);
            } else {
                System.out.println("sum " + polySumArray[i][0]);
            }
        }
        System.out.println("degree" + polySumArray.length);
        for (int i = 0; i < newDegree; i++) {

            System.out.println("Index:" + polySumArray[i][1]);
            System.out.println("Sum:" + polySumArray[i][0]);

        }
        return polySumArray;
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
        for (i = 0; i < newIndex; i++) {
            System.out.println("After multi: [" + i + "][0]" + multi[i][0]);
            System.out.println("After multi: [" + i + "][1]" + multi[i][1]);
        }
        return multi;
    }

}
