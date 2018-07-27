package SCF_Session5_Recursion;

/**
 * main class to calculate LCM and HCF
 */
public class LCMnHCF {

	/**
	 * function to calculate Highest Common Factor
	 * 
	 * @param number1
	 * @return HCF:highest common factor of number1 and number2
	 */
	int HCF(int number1, int number2) {
		if (number1 == number2) {
			return number1;
		} else if (number1 > number2) {
			return HCF(number1 - number2, number2);
		} else
			return HCF(number1, number2 - number1);
	}

	/**
	 * function to calculate Least Common Multiple
	 * 
	 * @param number1
	 * @param number2
	 * @return LCM :Least Common Multiple of number1 and number2
	 */

	int LCM(int number1, int number2) {
		int lcm;
		lcm = (number1 * number2) / HCF(number1, number2);
		return lcm;
	}

}
