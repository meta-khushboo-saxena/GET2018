package HexCalculation;

/**
 * contain various arithmetic operations on hexadecimal number convert
 * hexadecimal to decimal number and decimal to hexadecimal
 */
public class HexCalc {

	/**
	 * operation to convert hexadecimal to decimal number
	 * 
	 * @param hexadecimal
	 * @return decimalvalue
	 */
	int hexadecimalToDecimal(String hexadecimal) {
		int decimalvalue = 0, base = 1;

		char hexval[] = hexadecimal.toCharArray();

		for (int i = hexval.length - 1; i >= 0; i--) {
			if (hexval[i] >= '1' && hexval[i] <= '9') {

				decimalvalue += (hexval[i] - 48) * base;
				base = base * 16;

			} else if (hexval[i] >= 'A' && hexval[i] <= 'F') {

				decimalvalue += (hexval[i] - 55) * base;
				base = base * 16;

			} else {

				System.out.println("Invalid Hexadecimal Code");

			}
		}

		return decimalvalue;
	}

	/**
	 * operation to convert decimal to hexadecimal number
	 * 
	 * @param decimal
	 * @return hexvalue
	 */
	String decimaltoHex(int decimal) {
		String hexadecimalval = "", hexvalue = "";
		int remainder;
		while (decimal != 0) {
			remainder = decimal % 16;
			if (remainder < 10) {

				hexadecimalval = hexadecimalval
						+ Character.toString((char) (remainder + 48));

			} else {

				hexadecimalval = hexadecimalval
						+ Character.toString((char) (remainder + 55));

			}

			decimal = decimal / 16;
		}

		for (int i = hexadecimalval.length() - 1; i >= 0; i--) {
			hexvalue += hexadecimalval.charAt(i);
		}
		return hexvalue;
	}

	/**
	 * operation to add two hexadecimal number
	 * 
	 * @param hexadecimal1
	 *            ,hexadecimal2
	 * @return sum
	 */
	String addition(String hexadecimal1, String hexadecimal2) {
		int sum;

		sum = hexadecimalToDecimal(hexadecimal1)
				+ hexadecimalToDecimal(hexadecimal2);

		return decimaltoHex(sum);
	}

	/**
	 * operation to subtract two hexadecimal number
	 * 
	 * @param hexadecimal1
	 *            ,hexadecimal2
	 * @return sub
	 */
	String subtraction(String hexadecimal1, String hexadecimal2) {

		int sub;

		sub = hexadecimalToDecimal(hexadecimal1)
				- hexadecimalToDecimal(hexadecimal2);

		return decimaltoHex(sub);
	}

	/**
	 * operation to multiply two hexadecimal number
	 * 
	 * @param hexadecimal1
	 *            ,hexadecimal2
	 * @return mult
	 */
	String multiply(String hexadecimal1, String hexadecimal2) {

		int mult;

		mult = hexadecimalToDecimal(hexadecimal1)
				* hexadecimalToDecimal(hexadecimal2);

		return decimaltoHex(mult);
	}

	/**
	 * operation to divide two hexadecimal number
	 * 
	 * @param hexadecimal1
	 *            ,hexadecimal2
	 * @return div
	 */
	String divide(String hexadecimal1, String hexadecimal2) {

		int div;

		div = hexadecimalToDecimal(hexadecimal1)
				/ hexadecimalToDecimal(hexadecimal2);

		return decimaltoHex(div);
	}

	/**
	 * operation to check greater between two hexadecimal number
	 * 
	 * @param hexadecimal1
	 *            ,hexadecimal2
	 */
	public boolean isGreater(String hexadecimal1, String hexadecimal2) {

		if (hexadecimal1.length() > hexadecimal2.length()) {
			return true;

		} else if (hexadecimal1.length() == hexadecimal2.length()) {
			char hex1[] = hexadecimal1.toCharArray();
			char hex2[] = hexadecimal2.toCharArray();

			for (int i = 0; i < hexadecimal1.length(); i++) {
				if (hex1[i] > hex2[i]) {
					return true;
				} else if (hex1[i] < hex2[i]) {
					return false;
				}
			}
		}

		return false;
	}

	/**
	 * operation to check smaller between two hexadecimal number
	 * 
	 * @param hexadecimal1
	 *            ,hexadecimal2
	 */
	public boolean isSmaller(String hexadecimal1, String hexadecimal2) {

		if (hexadecimal1.length() < hexadecimal2.length()) {
			return true;

		} else if (hexadecimal1.length() == hexadecimal2.length()) {
			char hex1[] = hexadecimal1.toCharArray();
			char hex2[] = hexadecimal2.toCharArray();

			for (int i = 0; i < hexadecimal1.length(); i++) {
				if (hex1[i] < hex2[i]) {
					return true;
				} else if (hex1[i] > hex2[i]) {
					return false;
				}
			}
		}

		return false;
	}

	/**
	 * operation to check if two hexadecimal number are equal
	 * 
	 * @param hexadecimal1
	 *            ,hexadecimal2
	 */
	public boolean isEqualto(String hexadecimal1, String hexadecimal2) {

		if (hexadecimal1.length() == hexadecimal2.length()) {
			char hex1[] = hexadecimal1.toCharArray();
			char hex2[] = hexadecimal2.toCharArray();

			for (int i = 0; i < hexadecimal1.length(); i++) {
				if (hex1[i] > hex2[i]) {
					return false;
				} else if (hex1[i] < hex2[i]) {
					return false;
				}
			}
		}

		return true;
	}


	public boolean valid(String hexadecimal, String hexadecimal2) {
		char hexval[] = hexadecimal.toCharArray();

		for (int i = hexval.length - 1; i >= 0; i--) {

			if ((hexval[i] >= '1' && hexval[i] <= '9')
					|| (hexval[i] >= 'A' && hexval[i] <= 'F')) {

				continue;

			} else {

				return false;

			}
		}
		return true;
	}

}
